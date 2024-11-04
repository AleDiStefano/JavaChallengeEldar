package com.Eldar.JavaChallenge_Ej2.service;

import com.Eldar.JavaChallenge_Ej2.dto.OperationDTO;
import com.Eldar.JavaChallenge_Ej2.model.CreditCard;
import com.Eldar.JavaChallenge_Ej2.model.Operation;
import com.Eldar.JavaChallenge_Ej2.repository.ICreditCardRepository;
import com.Eldar.JavaChallenge_Ej2.repository.IOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
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
}
