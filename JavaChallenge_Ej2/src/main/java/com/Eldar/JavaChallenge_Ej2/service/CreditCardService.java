package com.Eldar.JavaChallenge_Ej2.service;

import com.Eldar.JavaChallenge_Ej2.model.CardHolder;
import com.Eldar.JavaChallenge_Ej2.model.CreditCard;
import com.Eldar.JavaChallenge_Ej2.repository.CreditCardRepository;
import com.Eldar.JavaChallenge_Ej2.repository.ICardHolderRepository;
import com.Eldar.JavaChallenge_Ej2.repository.ICreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
@Service
public class CreditCardService implements ICreditCardService {

    @Qualifier("ICreditCardRepository")
    @Autowired
    private ICreditCardRepository repo;

    @Autowired
    private ICardHolderService cardHolderService;

    @Autowired
    private EmailService emailService;

    @Override
    public List<CreditCard> getCreditCards() {
        return repo.findAll();
    }

    @Override
    public CreditCard addCreditCard(CreditCard creditCard) throws MessagingException {
        CardHolder cardHolder = cardHolderService.getCardHolderById(creditCard.getCardHolder().getId());
        if (cardHolder == null) {
            throw new IllegalArgumentException("CardHolder no encontrado para el ID especificado.");
        }
        if (repo.findByNumber(creditCard.getNumber()).isPresent()) {
            throw new IllegalArgumentException("Ya existe una tarjeta con ese número.");
        }
        emailService.createEmail(cardHolder.getEmail(),"NUEVA TARJETA CREADA","<h1>PAN: </h1> <h3>" + creditCard.getNumber() + "</h3> <h1>CVV: </h1><h3>" + creditCard.getCvv()+"</h3>");
        emailService.sendEmail();
        repo.save(creditCard);
        return creditCard;
    }

    @Override
    public void updateCreditCard(CreditCard updatedCreditCard) {
        repo.findById(updatedCreditCard.getId()).ifPresent(existingCreditCard -> {
            existingCreditCard.setNumber(updatedCreditCard.getNumber());
            existingCreditCard.setCardHolder(updatedCreditCard.getCardHolder());
            existingCreditCard.setExpirationDate(updatedCreditCard.getExpirationDate());
            existingCreditCard.setCvv(updatedCreditCard.getCvv());
            existingCreditCard.setType(updatedCreditCard.getType());

            repo.save(existingCreditCard);
        });
    }

    @Override
    public void deleteCreditCard(CreditCard creditCard) {
        repo.delete(creditCard);
    }

    @Override
    public CreditCard getCreditCard(int id) {
        return repo.findById(id).orElse(null);
    }
}
