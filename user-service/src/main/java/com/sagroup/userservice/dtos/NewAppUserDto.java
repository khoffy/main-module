package com.sagroup.userservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewAppUserDto {
    private String id;
    private String username;

    private String password;

    private String role;
}
