package com.app.creditcard.repo;

import com.app.creditcard.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepo extends JpaRepository <UserRole,String> {
}
