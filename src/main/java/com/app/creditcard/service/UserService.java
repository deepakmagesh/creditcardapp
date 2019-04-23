package com.app.creditcard.service;

import com.app.creditcard.model.User;

import java.util.Optional;

public interface UserService {

    public Optional <User> findByUserName (String userName);
    public boolean registerUser(String userName, String password);
}
