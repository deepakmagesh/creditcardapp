package com.app.creditcard.service.impl;

import com.app.creditcard.model.CreditCard;
import com.app.creditcard.repo.CreditCardRepo;
import com.app.creditcard.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    CreditCardRepo creditCardRepo;


    @Override
    public List <CreditCard> search(String searchParam, String searchValue) {
        List<CreditCard> creditCardList = new ArrayList <>();
        String userName = getCurrentUser();
        if("cardnumber".equals(searchParam)){
            creditCardList = creditCardRepo.findByCreditCardNumAndUserName(searchValue,userName);
        }else if("cardname".equals(searchParam)){
            System.out.println(searchValue);
            System.out.println(userName);
            List<CreditCard> allCreditCardList = creditCardRepo.findAll();
            creditCardList = creditCardRepo.findByCreditCardNameAndUserName(searchValue,userName);
        }else if("expiry".equals(searchParam)){
            creditCardList = creditCardRepo.findByExpiryDateAndUserName(searchValue,userName);
        }

        return creditCardList;

    }

    @Override
    public boolean saveCreditCard(String cardNumber, String cardName, String expiry) {
        boolean isSaved = true;
        CreditCard creditCard = null;
        String userName = getCurrentUser();
        List<CreditCard> creditCardList = creditCardRepo.findByCreditCardNumAndUserName(cardNumber,userName);
        if(creditCardList!=null && creditCardList.size()>0){
            creditCard = creditCardList.get(0);
        }else{
            creditCard = new CreditCard();
        }
        creditCard.setCreditCardName(cardName);
        creditCard.setCreditCardNum(cardNumber);
        creditCard.setExpiryDate(expiry);
        creditCard.setUserName(userName);
        creditCardRepo.save(creditCard);
        return isSaved;
    }

    private String getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }

}
