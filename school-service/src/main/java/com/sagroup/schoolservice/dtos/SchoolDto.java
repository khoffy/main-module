package com.sagroup.schoolservice.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class SchoolDto {
    private String id;

    private String name;

    private AddressDto address;

    private ContactDto contact;
}
