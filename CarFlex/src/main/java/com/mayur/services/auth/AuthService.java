package com.mayur.services.auth;

import com.mayur.dtos.SignupRequest;
import com.mayur.dtos.UserDto;

public interface AuthService {

    public UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail (String email);

}
