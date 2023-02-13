package com.ExportDbToExcel.Service;
import com.ExportDbToExcel.Entity.Student;
import com.ExportDbToExcel.Repository.StudentRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    Logger logger = LoggerFactory.getLogger(StudentService.class);





    public void generateExcel(HttpServletResponse response) throws Exception {
        List<Student> getAllStudent =studentRepository.findAll();
        logger.info("Excel Sheet SuccessFully Downloaded");




    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet sheet = workbook.createSheet("Student Info");
    HSSFRow row = sheet.createRow(0);

		row.createCell(0).setCellValue("Student ID");
		row.createCell(1).setCellValue("About");
		row.createCell(2).setCellValue("student Name");

    int dataRowIndex = 1;

		for (Student student : getAllStudent) {
        HSSFRow dataRow = sheet.createRow(dataRowIndex);
        dataRow.createCell(0).setCellValue(student.getStudent_id());
        dataRow.createCell(1).setCellValue(student.getStudent_name());
        dataRow.createCell(2).setCellValue(student.getAbout());
        dataRowIndex++;
    }

    ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		workbook.close();
		ops.close();
}}
