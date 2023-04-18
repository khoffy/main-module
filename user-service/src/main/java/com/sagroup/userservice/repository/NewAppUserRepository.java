package com.sagroup.userservice.repository;

import com.sagroup.userservice.entity.NewAppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewAppUserRepository extends MongoRepository<NewAppUser, String> {
}
