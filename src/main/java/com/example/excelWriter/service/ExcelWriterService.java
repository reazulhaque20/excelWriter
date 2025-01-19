package com.example.excelWriter.service;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

@Service
public class ExcelWriterService {

    public void exportToExcel(List<?> students, List<?> schools) throws IOException {
        // Create a workbook
        Workbook workbook = new XSSFWorkbook();

        // Create "Student" sheet dynamically
        Sheet studentSheet = workbook.createSheet("Student");
        if (!students.isEmpty()) {
            createDynamicSheet(studentSheet, students);
        }

        // Create "School" sheet dynamically
        Sheet schoolSheet = workbook.createSheet("School");
        if (!schools.isEmpty()) {
            createDynamicSheet(schoolSheet, schools);
        }

        File outputFile = new File("output/", "DynamicData.xlsx");
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            workbook.write(fileOutputStream);
        }

        workbook.close();
        System.out.println("Excel file written to: " + outputFile.getAbsolutePath());
    }

    private void createDynamicSheet(Sheet sheet, List<?> data) {
        // Get the class of the first object to extract headers
        Class<?> clazz = data.get(0).getClass();
        Field[] fields = clazz.getDeclaredFields();

        // Create header row
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true); // Make private fields accessible
            headerRow.createCell(i).setCellValue(fields[i].getName()); // Use field name as header
        }

        // Populate data rows
        int rowIndex = 1;
        for (Object obj : data) {
            Row row = sheet.createRow(rowIndex++);
            for (int i = 0; i < fields.length; i++) {
                try {
                    Object value = fields[i].get(obj); // Get field value
                    if (value != null) {
                        row.createCell(i).setCellValue(value.toString());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
