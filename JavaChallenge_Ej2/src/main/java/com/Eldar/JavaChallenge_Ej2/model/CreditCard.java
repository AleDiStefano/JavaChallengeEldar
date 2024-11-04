package com.Eldar.JavaChallenge_Ej2.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.YearMonth;

@Getter @Setter
@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected int id;
    protected String number;
    @ManyToOne
    @JoinColumn(name = "card_holder_id")
    protected CardHolder cardHolder;
    protected YearMonth expirationDate;
    protected String cvv;
    protected CreditCardType type;

    public CreditCard() {
    }

    public CreditCard(String number, CardHolder cardHolder, YearMonth expirationDate, String cvv, CreditCardType type) {
        this.number = number;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.type = type;
    }

    public Boolean isValidToOperate(){
        return expirationDate.isAfter(YearMonth.now());
    }

}
