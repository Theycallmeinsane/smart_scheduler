import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jgrapht.Graph;
import org.jgrapht.generate.GnpRandomGraphGenerator;
import org.jgrapht.generate.GraphGenerator;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ScheduleGUI {

    public ScheduleGUI(String classFile, String professorFile) throws IOException {

        ArrayList<ClassRoom> classRooms = new ArrayList<>();
        ArrayList<Class> scheduleClass = new ArrayList<>();
        ArrayList<Professor> professors = new ArrayList<>();
        ArrayList<Class> allClasses = new ArrayList<>();

        String fileName = classFile;
        String filename2 = professorFile;
        try {
            FileInputStream excelFile = new FileInputStream(fileName);
            Workbook workbook = WorkbookFactory.create(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            int numRows = sheet.getLastRowNum() + 1;
            for (int i = 1; i < numRows; i++) {
                Row row = sheet.getRow(i);
                String Class = row.getCell(0).getStringCellValue();
                double quantity = row.getCell(1).getNumericCellValue();
                classRooms.add(new ClassRoom(Class, (int) quantity));


            }
            excelFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        ArrayList<Course> coursesnew = new ArrayList<>();
        ArrayList<Slots> timee = new ArrayList<>();
        int hours = 0;
        int mins = 0;
        try {
            FileInputStream excelFile2 = new FileInputStream(filename2);
            Workbook workbook2 = WorkbookFactory.create(excelFile2);
            Sheet sheet2 = workbook2.getSheetAt(0);
            int numRows2 = sheet2.getLastRowNum() + 1;
            for (int i = 1; i < numRows2; i++) {
                Row row = sheet2.getRow(i);
                String name = row.getCell(0).getStringCellValue();
                String[] courseList = row.getCell(1).getStringCellValue().split(",");
                String[] capacity = row.getCell(2).getStringCellValue().split(",");
                String[] timeee = row.getCell(3).getStringCellValue().split(",");
                ArrayList<Course> courseList1 = new ArrayList<>();
                ArrayList<Slots> timeeee = new ArrayList<>();
                for (String times : timeee) {
                    String[] parts = times.split(":");
                    hours = Integer.parseInt(parts[0]);
                    mins = Integer.parseInt(parts[1]);
                    timeeee.add(new Slots(new MyTime(hours, mins)));
                }
                List<String> courseName = Arrays.asList(courseList);
                List<String> capacity1 = Arrays.asList(capacity);
                for (int j = 0; j < courseName.size(); j++) {
                    courseList1.add(new Course(courseName.get(j), Integer.parseInt(capacity1.get(j))));
                }
                professors.add(new Professor(name, courseList1, timeeee));
            }

            excelFile2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Slots slot = new Slots();
        ArrayList<Slots> timeSlots = new ArrayList<>();
        timeSlots.add(new Slots(new MyTime(8, 30), new MyTime(9, 45)));
        timeSlots.add(new Slots(new MyTime(10, 00), new MyTime(11, 15)));
        timeSlots.add(new Slots(new MyTime(11, 30), new MyTime(12, 45)));
        timeSlots.add(new Slots(new MyTime(13, 00), new MyTime(14, 15)));
        timeSlots.add(new Slots(new MyTime(14, 30), new MyTime(15, 45)));
        timeSlots.add(new Slots(new MyTime(16, 00), new MyTime(17, 15)));
        timeSlots.add(new Slots(new MyTime(17, 30), new MyTime(18, 45)));

        ArrayList<String> Days = new ArrayList();
        Days.add("Monday/Wednesday");
        Days.add("Tuesday/Thursday");
        Days.add("Friday/Saturday");
        for (int i = 0; i < Days.size(); i++) {
            for (int j = 0; j < timeSlots.size(); j++) {
                for (int k = 0; k < classRooms.size(); k++) {
                    scheduleClass.add(new Class(Days.get(i), timeSlots.get(j), classRooms.get(k)));
                }
            }
        }
        for (int i = 0; i < scheduleClass.size(); i++) {
            scheduleClass.get(i).setAvailabilityTime(true);
        }

     Graph<Class, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        // Generate a random connected graph (G(n, p))
        int n = scheduleClass.size(); // Number of vertices
        double p = 0.3; // Probability of an edge between two vertices

        GraphGenerator<Class, DefaultEdge, Class> generator =
            new GnpRandomGraphGenerator<>(n, p);
        generator.generateGraph(graph, null);


        List<Class> shuffledVertices = new ArrayList<>(graph.vertexSet());
        Collections.shuffle(shuffledVertices);

        for (int i = 1; i < shuffledVertices.size(); i++) {
            Class currentVertex = shuffledVertices.get(i);
            Class previousVertex = shuffledVertices.get(i - 1);
            graph.addEdge(currentVertex, previousVertex);
        }

        Class lastVertex = shuffledVertices.get(shuffledVertices.size() - 1);
        Class firstVertex = shuffledVertices.get(0);
        graph.addEdge(lastVertex, firstVertex);


        for (Professor professor : professors) {
            List<Course> courses = professor.getCourses();
            List<Slots> availableTimings = professor.getProfessorAvailableTimeSlots();
            while (!courses.isEmpty() && !availableTimings.isEmpty()) {
                Course course = courses.get(0);
                Slots availableTiming = availableTimings.get(0);
                boolean isAssigned = false;
                DepthFirstIterator<Class, DefaultEdge> dfs = new DepthFirstIterator<Class, DefaultEdge>(graph, scheduleClass.get(0));
                while (dfs.hasNext()) {
                    Class vertex = dfs.next();
                    if (vertex.isAvailabilityTime()) {
                        if (vertex.getClassRoom().getClassRoomCapacity() - course.getCourseCapacity() <= 10 && vertex.getClassRoom().getClassRoomCapacity() - course.getCourseCapacity() >= 0) {
                            if (vertex.getTimeSlot().getStart().getHour() == availableTiming.getStart().getHour() && vertex.getTimeSlot().getStart().getMinute() == availableTiming.getStart().getMinute()) {
                                allClasses.add(new Class(vertex.Day, vertex.timeSlot, professor, course, vertex.classRoom));
                                vertex.setAvailabilityTime(false);
                                availableTimings.remove(0);
                                courses.remove(0);
                                isAssigned = true;
                                break;
                            }
                        }
                    }
                }
                if (!isAssigned) {
                    availableTimings.remove(0);
                }
            }
        }

        Collections.sort(allClasses, new ClassTimeSlotComparator());
        for (int j = 0; j < allClasses.size(); j++) {
            System.out.println(j + ") " + allClasses.get(j));
        }
        String filePath = System.getProperty("user.home") + "/Desktop/Generated_Schedule.xlsx";
        ExcelWriter.writeClassesToExcel(allClasses, filePath);

    }
}


