package com.sagroup.studentservice.repositories;
import com.sagroup.studentservice.domains.Student;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, Long>  {
}
