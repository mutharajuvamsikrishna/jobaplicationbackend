package com.web.service;

import com.web.model.Register;
import com.web.repo.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private RegisterRepo userRepository;

    public Register processOAuthPostLogin(Register user) {
        Register existingUser = userRepository.findByEmail(user.getEmail());
        System.out.println("In service User is " + user);
        if (existingUser == null) {
            userRepository.save(user);

        }
        return user;
    }
}
