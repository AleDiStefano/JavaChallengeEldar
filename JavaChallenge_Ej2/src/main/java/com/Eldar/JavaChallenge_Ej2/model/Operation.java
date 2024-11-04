



package com.Eldar.JavaChallenge_Ej2.model;


import com.Eldar.JavaChallenge_Ej2.dto.OperationDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@Getter @Setter
@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private double amount;
    private LocalDate date;
    @Setter
    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;

    public Operation() {
    }

    public OperationDTO toDTO() {
        OperationDTO dto = new OperationDTO();
        dto.id = this.id;
        dto.amount = this.amount;
        dto.date = this.date;
        dto.creditCard = this.creditCard;
        return dto;
    }

}
