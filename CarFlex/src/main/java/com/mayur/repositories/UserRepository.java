package com.mayur.repositories;

import com.mayur.entitys.Users;
import com.mayur.enums.UserRole;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findFirstByEmail(String email);

    Users findByUserRole(UserRole userRole);
}
