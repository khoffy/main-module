package com.sagroup.teacherservice.Service;

import com.sagroup.teacherservice.Domain.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface TeacherService {
    public List<Teacher> getAll();
    public Teacher getTeacher(String id);
    public Teacher add(Teacher student);
    public Teacher update(String id, Teacher stu);
    public String delete(String id);
}
