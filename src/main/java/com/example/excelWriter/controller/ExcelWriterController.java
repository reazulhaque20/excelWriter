package com.example.excelWriter.controller;

import com.example.excelWriter.dto.School;
import com.example.excelWriter.dto.Student;
import com.example.excelWriter.service.ExcelWriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ExcelWriterController {

    @Autowired
    private ExcelWriterService excelWriterService;

    @GetMapping("/writeExcel")
    public void writeExcel() throws IOException {
        List<Student> studentList = List.of(
                new Student("Student-1", 1, 10),
                new Student("Student-2", 2, 11),
                new Student("Student-3", 3, 12),
                new Student("Student-4", 4, 13),
                new Student("Student-5", 5, 14),
                new Student("Student-6", 6, 15)
        );

        List<School> schoolList = List.of(
                new School("School-1", "SC-1", "Add-1"),
                new School("School-2", "SC-2", "Add-2"),
                new School("School-3", "SC-3", "Add-3"),
                new School("School-4", "SC-4", "Add-4")
        );

        excelWriterService.exportToExcel(studentList, schoolList);
    }
}
