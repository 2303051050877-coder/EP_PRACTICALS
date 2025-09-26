package com.practical.spring.dao;

import com.practical.spring.entity.Student;
import java.util.List;

public interface StudentDAO {
    void saveStudent(Student student);
    Student getStudent(int id);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudent(int id);
}
