package com.mycompany.javachallenge_ej1;

import java.time.LocalDate;

public class Operation {
    
    public int Id;
    public double Amount;
    public LocalDate Date;

    public Operation() {
    }

    public Operation(int Id, double Amount, LocalDate Date) {
        this.Id = Id;
        this.Amount = Amount;
        this.Date = Date;
    }

    
    public boolean isValidOperation(){
        return Amount < 10000;
    }
            
            
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }
    
    
}
