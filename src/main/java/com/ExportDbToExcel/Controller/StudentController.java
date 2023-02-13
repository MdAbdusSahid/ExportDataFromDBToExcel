package com.ExportDbToExcel.Controller;
import com.ExportDbToExcel.Service.StudentService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController("/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping("/excel")
    public void generateExcelReport(HttpServletResponse response) throws Exception{
        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=student.xls";

        response.setHeader(headerKey, headerValue);

        studentService.generateExcel(response);

        response.flushBuffer();
    }
    }
