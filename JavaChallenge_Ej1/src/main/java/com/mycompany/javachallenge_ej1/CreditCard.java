package com.mycompany.javachallenge_ej1;
import java.time.LocalDate;
import java.time.YearMonth;

public class CreditCard {
    
    protected String Number;
    protected CardHolder CardHolder;  
    protected YearMonth ExpirationDate;
    protected String CVV;
    protected CreditCardType Type;

    public CreditCard() {
    }

    public CreditCard(String Number, CardHolder CardHolder, YearMonth ExpirationDate, String CVV, CreditCardType Type) {
        this.Number = Number;
        this.CardHolder = CardHolder;
        this.ExpirationDate = ExpirationDate;
        this.CVV = CVV;
        this.Type = Type;
    }

    public Boolean isValidToOperate(){  
       return ExpirationDate.isAfter(YearMonth.now());
    } 
        
    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public CardHolder getCardHolder() {
        return CardHolder;
    }

    public void setCardHolder(CardHolder CardHolder) {
        this.CardHolder = CardHolder;
    }

    public YearMonth getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(YearMonth ExpirationDate) {
        this.ExpirationDate = ExpirationDate;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public CreditCardType getType() {
        return Type;
    }

    public void setType(CreditCardType Type) {
        this.Type = Type;
    }
    
    
}
