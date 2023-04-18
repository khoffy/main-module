package com.sagroup.avatarservice.repository;

import com.sagroup.avatarservice.entity.Avatar;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepository extends MongoRepository<Avatar, Long> {
}
