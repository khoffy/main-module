package com.sagroup.teacherservice.Repository;

import com.sagroup.teacherservice.Domain.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {

}
