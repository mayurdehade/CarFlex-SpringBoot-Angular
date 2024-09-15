package com.mayur.services.auth;

import com.mayur.dtos.SignupRequest;
import com.mayur.dtos.UserDto;
import com.mayur.entitys.Users;
import com.mayur.enums.UserRole;
import com.mayur.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceimpl implements AuthService {

    private final UserRepository userRepository;

    @PostConstruct
    public void createAdminAccount() {
        Users adminAccount = userRepository.findByUserRole(UserRole.ADMIN);

        if (adminAccount == null) {
            Users newAdminAccount = new Users();
            newAdminAccount.setName("Admin");
            newAdminAccount.setEmail("admin@test.com");
            newAdminAccount.setPassword(new BCryptPasswordEncoder().encode("admin"));
            newAdminAccount.setUserRole(UserRole.ADMIN);
            userRepository.save(newAdminAccount);
            System.out.println("Admin account created");
        }
    }

    @Override
    public UserDto createCustomer(SignupRequest signupRequest){
        Users user = new Users();
        user.setEmail(signupRequest.getEmail());
        user.setMobileNumber(signupRequest.getMobileNumber());
        user.setName(signupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setUserRole(UserRole.CUSTOMER);

        Users createdCustomer = userRepository.save(user);

        UserDto createdUserDto = new UserDto();
        createdUserDto.setId(createdCustomer.getId());
        createdUserDto.setMobileNumber(createdCustomer.getMobileNumber());
        createdUserDto.setEmail(createdCustomer.getEmail());
        createdUserDto.setName(createdCustomer.getName());
        createdUserDto.setUserRole(createdCustomer.getUserRole());
        return createdUserDto;
    }

    @Override
    public boolean hasCustomerWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
