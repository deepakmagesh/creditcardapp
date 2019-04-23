package com.app.creditcard.service.impl;

import com.app.creditcard.model.CustomUser;
import com.app.creditcard.model.User;
import com.app.creditcard.repo.UserRepo;
import com.app.creditcard.service.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerUserDetailsServiceImpl implements UserDetailsService, CustomerUserDetailsService {

    @Autowired
    private UserRepo userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional <User> optionalUsers = userRepository.findByUserName(username);

        optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUsers
                .map(CustomUser::new).get();
    }
}
