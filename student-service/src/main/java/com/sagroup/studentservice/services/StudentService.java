package com.sagroup.studentservice.services;

import com.sagroup.studentservice.domains.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface StudentService {
    public Optional<Student> getById(Long id);
    public  void  addStudent(Student student);
    void update(long id,Student student);
    void removeById(long id);
    List<Student> getAllStudents();
}
