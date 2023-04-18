package com.sagroup.studentservice.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collation = "Students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private Long studentNumber;
    private String firstName;
    private String lastName;
    private String school;
    private String yearGroup;
    private   int    score;
//    private Avatar avatar;
//    private List<Rewards> rewards;
}
