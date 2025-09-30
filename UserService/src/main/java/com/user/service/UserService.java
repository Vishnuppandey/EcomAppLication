package com.user.service;

import com.user.model.entity.User;
import com.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    UserRepository userRepo;
    public UserService(UserRepository userRepo){
        this.userRepo=userRepo;
    }

    @Transactional
    public String createUser(User user){
        userRepo.save(user);
        return "account created successfully";
    }

}
