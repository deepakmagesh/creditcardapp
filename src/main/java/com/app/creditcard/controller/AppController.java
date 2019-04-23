package com.app.creditcard.controller;

import com.app.creditcard.model.CreditCard;
import com.app.creditcard.service.CreditCardService;
import com.app.creditcard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private CreditCardService creditCardService;


    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secure/home")
    public ModelAndView loginPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secure/search")
    public ModelAndView searchCreditCard(@RequestParam("dropdown") String dropdown,
                                         @RequestParam("searchText") String searchText){

        List <CreditCard> creditCardList = creditCardService.search(dropdown,searchText);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("creditCardList", creditCardList);
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secure/createcreditcard")
    public ModelAndView createCreditCard(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newcreditcard");
        return modelAndView;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secure/savecard")
    public ModelAndView saveCreditCard(@RequestParam("cardnumber") String cardNumber,
                                       @RequestParam("cardname") String cardName,
                                       @RequestParam("expiry") String expiry){
        boolean isSaved = creditCardService.saveCreditCard(cardNumber,cardName,expiry);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("isSaved", String.valueOf(isSaved));
        modelAndView.setViewName("creditcardresults");
        return modelAndView;
    }

    @GetMapping("/app/welcome")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/app/register")
    public ModelAndView registerationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @GetMapping("/error")
    public ModelAndView error() {
        ModelAndView modelAndView = new ModelAndView();
        String errorMessage= "You are not authorized for the requested data.";
        modelAndView.addObject("errorMsg", errorMessage);
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @GetMapping("/app/register/form")
    public ModelAndView registerUser(@RequestParam("userName") String userName,
                                     @RequestParam("password") String password) {

        boolean isSaved = userService.registerUser(userName,password);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("isSaved", String.valueOf(isSaved));
        modelAndView.setViewName("registerresults");
        return modelAndView;
    }

}
