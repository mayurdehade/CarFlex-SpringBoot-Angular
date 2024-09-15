package com.mayur.dtos;

import lombok.Data;

@Data
public class SignupRequest {
    private String email;
    private Long mobileNumber;
    private String name;
    private String password;
}
