package com.sagroup.studentservice.services.ServiceImp;
import com.sagroup.studentservice.domains.Student;
import com.sagroup.studentservice.repositories.StudentRepo;
import com.sagroup.studentservice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentSerImp implements StudentService{
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public Optional<Student> getById(Long id){
        return studentRepo.findById ( id );
    }

    @Override
    public void addStudent(Student student) {
        studentRepo.save ( student);

    }

    @Override
    public void update(long id, Student student) {
        Optional<Student> newStudent = studentRepo.findById ( id );
        Student repoStudent = newStudent.orElse(null);
        repoStudent.setStudentNumber(student.getStudentNumber());
        repoStudent.setFirstName(student.getFirstName());
        repoStudent.setLastName(student.getLastName());
//        repoStudent.setSchool(student.getStudentNumber);
        repoStudent.setYearGroup(student.getYearGroup());
        repoStudent.setScore(student.getScore());
//    private Avatar avatar;
//    private List<Rewards> rewards
        studentRepo.save (repoStudent);

    }

    @Override
    public void removeById(long id) {
        studentRepo.deleteById ( id );
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll ();
    }
}
