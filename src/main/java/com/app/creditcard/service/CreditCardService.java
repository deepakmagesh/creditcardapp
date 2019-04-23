package com.app.creditcard.service;

import com.app.creditcard.model.CreditCard;

import java.util.List;

public interface CreditCardService {

    public List <CreditCard> search(String searchParam, String searchValue);

    boolean saveCreditCard(String cardNumber, String cardName, String expiry);
}
