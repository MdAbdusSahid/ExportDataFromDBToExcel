package com.ExportDbToExcel.Repository;

import com.ExportDbToExcel.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface StudentRepository extends JpaRepository<Student, Serializable> {
}
