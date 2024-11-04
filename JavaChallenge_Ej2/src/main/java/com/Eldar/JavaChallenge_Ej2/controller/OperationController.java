package com.Eldar.JavaChallenge_Ej2.controller;

import com.Eldar.JavaChallenge_Ej2.dto.OperationDTO;
import com.Eldar.JavaChallenge_Ej2.model.CreditCard;
import com.Eldar.JavaChallenge_Ej2.model.Operation;
import com.Eldar.JavaChallenge_Ej2.repository.ICreditCardRepository;
import com.Eldar.JavaChallenge_Ej2.service.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;

@RestController
public class OperationController {

    @Autowired
    private IOperationService repo;
    @Autowired
    private ICreditCardRepository creditCardRepository;


    @GetMapping("/operation/get")
    public List<Operation> operationGet(){
        return repo.getAllOperation();
    }

    @PostMapping("/operation/create")
    public String createOperation(@RequestBody OperationDTO operation) throws MessagingException {
        repo.addOperation(operation);
        return "Operacion exitosa";
    }
}
