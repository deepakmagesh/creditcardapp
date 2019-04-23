package com.app.creditcard.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CustomerUserDetailsService {
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
