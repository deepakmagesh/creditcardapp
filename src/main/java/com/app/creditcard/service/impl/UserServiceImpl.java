package com.app.creditcard.service.impl;

import com.app.creditcard.model.Role;
import com.app.creditcard.model.User;
import com.app.creditcard.model.UserRole;
import com.app.creditcard.repo.UserRepo;
import com.app.creditcard.repo.UserRoleRepo;
import com.app.creditcard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserRoleRepo userRoleRepo;

    @Override
    public Optional <User> findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public boolean registerUser(String userName, String password) {
        boolean userCreated = true;
        Optional<User> user = findByUserName(userName);
        if (user.isPresent()) {
            userCreated = false;
        }else{
            User newUser = new User();
            newUser.setPassword(password);
            newUser.setUserName(userName);
            User savedUser = save(newUser);
            userRoleRepo.save(new UserRole(savedUser.getUserId(),"1"));
        }

        return userCreated;
    }
}
