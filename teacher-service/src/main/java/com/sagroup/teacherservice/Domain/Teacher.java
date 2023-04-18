package com.sagroup.teacherservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    private String teacherID;
    private String FirstName;
    private String LastName;
    private Contact contact;
    private School school;
    private TeachingClass teachingClass;
    private Address address;



}
