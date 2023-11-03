import java.util.ArrayList;

public class Professor {
    private String name;
    private ArrayList<Course> courses;
    ArrayList<Slots> professorAvailableTimeSlots = new ArrayList<>();


    public Professor(String name, ArrayList<Course> course, ArrayList<Slots> professorAvailableTimeSlots) {

        this.name = name;
        this.courses = course;
        this.professorAvailableTimeSlots = professorAvailableTimeSlots;

    }

    public String getName() {
        return name;
    }


    public ArrayList getCourses() {
        return courses;
    }

    public Course retrieveCourse(int i) {
        return courses.get(i);
    }

    public Slots retrieveAvailableTiming(int i) {
        return professorAvailableTimeSlots.get(i);
    }

    public void setCourses(ArrayList courses) {
        this.courses = courses;
    }

    public void setProfessorAvailableTimeSlots(ArrayList timeSlots) {
        this.professorAvailableTimeSlots = timeSlots;
    }

    public ArrayList<Slots> getProfessorAvailableTimeSlots() {
        return professorAvailableTimeSlots;
    }

    public String toString() {
        return
                name + " "
                ;
    }
}


