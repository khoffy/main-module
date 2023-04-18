package com.sagroup.studentservice.controllers;
import com.sagroup.studentservice.domains.Student;
import com.sagroup.studentservice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class studentController {
    @Autowired
    private StudentService studentService;

    @GetMapping({"/{id}"})
    public Optional<Student> getStudent(@PathVariable Long id){
        return studentService.getById(id);
    }


    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student)  {
        studentService.addStudent(student);
    }

    @GetMapping("/getStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable long id,@RequestBody Student student){
        studentService.update(id, student);
    }
    @DeleteMapping("/delete/{id}")
    public void remove(@PathVariable long id){
        studentService.removeById(id);
    }
//     @PostMapping("/buy")
//
////    public void buy  ( @RequestBody Element element ){
////               studentService.buyAvatar();
//     }
}
