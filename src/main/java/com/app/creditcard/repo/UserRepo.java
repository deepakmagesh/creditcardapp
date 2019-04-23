package com.app.creditcard.repo;

import com.app.creditcard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository <User,String> {

    Optional <User> findByUserName(String username);
}
