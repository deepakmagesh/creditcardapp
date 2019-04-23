package com.app.creditcard.repo;

import com.app.creditcard.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditCardRepo extends JpaRepository <CreditCard,String> {

    public List <CreditCard> findByCreditCardNumAndUserName(String creditCardNum, String userName);
    public List <CreditCard> findByCreditCardNameAndUserName(String creditCardName, String userName);
    public List <CreditCard> findByExpiryDateAndUserName(String creditCard, String userName);

}
