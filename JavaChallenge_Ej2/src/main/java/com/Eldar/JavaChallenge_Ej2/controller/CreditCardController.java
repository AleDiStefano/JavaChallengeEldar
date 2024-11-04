package com.Eldar.JavaChallenge_Ej2.controller;

import com.Eldar.JavaChallenge_Ej2.model.CreditCard;
import com.Eldar.JavaChallenge_Ej2.service.ICreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
public class CreditCardController {


    @Autowired
    private ICreditCardService creditCardService;

    @GetMapping("/creditCard/get")
    public List<CreditCard> getCreditCards() {
        return creditCardService.getCreditCards();
    }

    @PostMapping("/creditCard/create")
    public String createCreditCard(@RequestBody CreditCard creditCard) throws MessagingException {
        creditCardService.addCreditCard(creditCard);
        return "Tarjeta creada con exito";
    }


}
