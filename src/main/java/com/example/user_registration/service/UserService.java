package com.example.user_registration.service;

import com.example.user_registration.dto.UserPassDto;
import com.example.user_registration.entity.Users;
import com.example.user_registration.exceptions.UserNotFoundException;
import com.example.user_registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;
    public void register(UserPassDto request) {
        Users user= new Users();
        String userName= request.getUserName();
        String passWord= request.getPassWord();
        String role= request.getRole();
        user.setUserName(userName);
        user.setPassWord(new BCryptPasswordEncoder().encode(passWord));
        user.setIsActive(true);
        user.setLastLogin(null);
        user.setRole(role);
        userRepo.save(user);
    }

    public Users findByUsername(String userName) {
        Optional<Users> foundUser=userRepo.findByUserName(userName);
        return foundUser.orElseThrow(() -> new UserNotFoundException(userName));
    }
}
