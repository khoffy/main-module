package com.sagroup.schoolservice.repositories;

import com.sagroup.schoolservice.entities.School;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends MongoRepository<School, String> {
}
