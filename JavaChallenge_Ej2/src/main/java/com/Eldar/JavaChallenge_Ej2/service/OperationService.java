package com.Eldar.JavaChallenge_Ej2.service;

import com.Eldar.JavaChallenge_Ej2.dto.OperationDTO;
import com.Eldar.JavaChallenge_Ej2.model.CreditCard;
import com.Eldar.JavaChallenge_Ej2.model.CreditCardType;
import com.Eldar.JavaChallenge_Ej2.model.Operation;
import com.Eldar.JavaChallenge_Ej2.repository.ICreditCardRepository;
import com.Eldar.JavaChallenge_Ej2.repository.IOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.List;

@Service
public class OperationService implements IOperationService {

    @Autowired
    private IOperationRepository repo;
    @Autowired
    private ICreditCardService creditCardService;

    @Autowired
    private EmailService emailService;


    @Override
    public List<Operation> getAllOperation() {
        return repo.findAll();
    }

    @Override
    public void addOperation(OperationDTO  operation) throws MessagingException {
        Operation operationEntity = operation.toEntity();
        CreditCard card = creditCardService.getCreditCard(operationEntity.getId());
        emailService.createEmail(card.getCardHolder().getEmail(),"OPERACION REALIZADA","<h1>Nueva operacion realizada challenge Eldar</h1>");
        emailService.sendEmail();
        repo.save(operationEntity);
    }

    @Override
    public Operation getOperationById(int id) {
        return repo.findById(id).orElse(null);
    }

    public String getRate(CreditCardType creditCardType, double amount){
        LocalDate consult = LocalDate.now();

        int year = consult.getYear();
        int month = consult.getMonthValue();
        int lastTwoDigitsOfYear = year % 100;

        System.out.println("VISA: " +  lastTwoDigitsOfYear / month);
        System.out.println("NARA: " + consult.getDayOfMonth() * 0.5);
        System.out.println("AMEX: " + consult.getMonthValue() * 0.1);
        String response;
        double visa = (double) lastTwoDigitsOfYear / month;
        double nara = consult.getDayOfMonth() * 0.5;
        double amex = consult.getMonthValue() * 0.1;



        switch (creditCardType){
            case CreditCardType.VISA:
                response = "La tasa para VISA es " + String.format("%.2f", visa) + "%, por lo tanto el monto seria: " + String.format("%.2f", amount * (1 + (visa / 100)));
                break;
            case CreditCardType.NARA:
                response = "La tasa para NARA es " +  String.format("%.2f", nara) + "%, por lo tanto el monto seria: " + String.format("%.2f", amount * (1 + (nara / 100)));
                break;
            case CreditCardType.AMEX:
                response = "La tasa para AMEX es " +  String.format("%.2f", amex) + "%, por lo tanto el monto seria: " + String.format("%.2f", amount * (1 + (amex / 100)));
                break;
            default:
                response = "Tipo de tarjeta inválida";
                break;
        }
        return response;
    }
}
