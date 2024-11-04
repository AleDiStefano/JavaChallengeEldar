package com.Eldar.JavaChallenge_Ej2.dto;

import com.Eldar.JavaChallenge_Ej2.model.CreditCard;
import com.Eldar.JavaChallenge_Ej2.model.Operation;
import com.Eldar.JavaChallenge_Ej2.repository.ICreditCardRepository;

import java.time.LocalDate;
import java.util.Optional;

public class OperationDTO {

    public int id;
    public double amount;
    public LocalDate date;
    public CreditCard creditCard;

    public Operation toEntity() {
        Operation operation = new Operation();
        operation.setId(this.id);
        operation.setAmount(this.amount);
        operation.setDate(this.date);
        operation.setCreditCard(this.creditCard);
        return operation;
    }
}
