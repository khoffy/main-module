package com.sagroup.teacherservice.Service.IMP;

import com.sagroup.teacherservice.Domain.Teacher;
import com.sagroup.teacherservice.Repository.TeacherRepository;
import com.sagroup.teacherservice.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceIMP implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacher(String id) {
        return teacherRepository.findById(id).orElse(null);//we said if you don't find by id let me know say null
    }

    @Override
    public Teacher add(Teacher teacher) {

        teacherRepository.save(teacher);//creat and save are the same work to do
        return teacher;
    }


    @Override
    public Teacher update(String id, Teacher teacher) {
        //we need to get the teacher first then need to save it back to
        Teacher teach = teacherRepository.findById(id).orElse(null);
        teach.setTeacherID(teacher.getTeacherID());
        teach.setFirstName(teacher.getFirstName());
        teach.setLastName(teacher.getLastName());
        teach.setAddress(teacher.getAddress());
        teach.setContact(teacher.getContact());
        teach.setSchool(teacher.getSchool());
        teacherRepository.save(teacher);
        return teacher;

    }

    @Override
    public String delete(String id) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if(teacher != null){
            teacherRepository.deleteById(id);
        }
        return "safely deleted";

    }

}
