package com.app.creditcard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "USER_ROLE")
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements Serializable {


    @Id
    @Column(name = "user_id")
    int userId;

    @Column(name = "role_id")
    String roleId;


}
