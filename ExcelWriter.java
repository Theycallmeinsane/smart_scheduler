import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelWriter {
    public static void writeClassesToExcel(ArrayList<Class> classes, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Generated_Schedule");

        Row headerRow = sheet.createRow(0);
        String[] headers = {"Day", "Start Time", "End Time", "Professor", "Course", "Class Room"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        int rowNum = 1;
        for (Class c : classes) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(c.Day);
            row.createCell(1).setCellValue(c.getTimeSlot().getStart().toString());
            row.createCell(2).setCellValue(c.getTimeSlot().getEnd().toString());
            row.createCell(3).setCellValue(c.getProfessor().getName());
            row.createCell(4).setCellValue(c.getCourse().getName());
            row.createCell(5).setCellValue(c.getClassRoom().getClassRoomNo());
        }


        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
    }
}
