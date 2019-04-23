package com.app.creditcard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "CREDIT_CARD")
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {

    @Id
    @Column(name ="CARDNUMBER")
    String creditCardNum;
    @Column(name ="NAME")
    String creditCardName;
    @Column(name ="EXPIRY")
    String expiryDate;
    @Column(name ="USERNAME")
    String userName;
}
