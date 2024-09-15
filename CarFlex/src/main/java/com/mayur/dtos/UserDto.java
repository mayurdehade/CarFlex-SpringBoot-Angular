package com.mayur.dtos;

import com.mayur.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String name;

    private String email;

    private Long mobileNumber;

    private String password;

    private UserRole userRole;
}
