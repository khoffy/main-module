package com.sagroup.userservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class NewAppUser {
    @Id
    private String id;

    private String username;

    private String password;

    private String role;
}
