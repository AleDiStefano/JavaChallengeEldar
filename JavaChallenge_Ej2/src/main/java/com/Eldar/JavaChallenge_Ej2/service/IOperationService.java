package com.Eldar.JavaChallenge_Ej2.service;

import com.Eldar.JavaChallenge_Ej2.dto.OperationDTO;
import com.Eldar.JavaChallenge_Ej2.model.Operation;

import javax.mail.MessagingException;
import java.util.List;

public interface IOperationService {

    public List<Operation> getAllOperation();
    public void addOperation(OperationDTO operation) throws MessagingException;
    public Operation getOperationById(int id);

}
