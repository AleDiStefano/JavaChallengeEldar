package com.Eldar.JavaChallenge_Ej2.service;

import com.Eldar.JavaChallenge_Ej2.model.CreditCard;

import javax.mail.MessagingException;
import java.util.List;

public interface ICreditCardService {

    public List<CreditCard> getCreditCards();
    public CreditCard addCreditCard(CreditCard creditCard) throws MessagingException;
    public void updateCreditCard(CreditCard creditCard);
    public void deleteCreditCard(CreditCard creditCard);
    public CreditCard getCreditCard(int id);

}
