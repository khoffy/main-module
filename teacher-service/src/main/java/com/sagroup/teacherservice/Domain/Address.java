package com.sagroup.teacherservice.Domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String state;
    private String city;
    private String zip;
    private String country;
}
