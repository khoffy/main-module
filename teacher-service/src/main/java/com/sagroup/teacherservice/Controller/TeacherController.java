package com.sagroup.teacherservice.Controller;

import com.sagroup.teacherservice.Domain.Teacher;
import com.sagroup.teacherservice.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    List<Teacher> getAllTeacher(){
        return teacherService.getAll();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable("id") String  id){ //in the link port I will type id
        return teacherService.getTeacher(id);
    }

    @PostMapping
    public Teacher saveTeacher(@RequestBody Teacher teacher){

        teacherService.add(teacher);
        return teacher;
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable String id, @RequestBody Teacher teacher){
        teacherService.update(id, teacher);
        return teacher;
    }
    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable String id){
        teacherService.delete(id);
        return  "Safely deleted";
    }
}
