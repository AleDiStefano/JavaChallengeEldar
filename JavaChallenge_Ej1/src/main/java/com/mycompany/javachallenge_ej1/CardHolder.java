package com.mycompany.javachallenge_ej1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CardHolder {
    
    public int Id;
    public String Name;
    public String LastName;
    public String Dni;
    public LocalDate BirthDate;
    public String Email;

    public CardHolder() {
    }

    public CardHolder(int Id, String Name, String LastName, String Dni, LocalDate BirthDate, String Email) {
        this.Id = Id;
        this.Name = Name;
        this.LastName = LastName;
        this.Dni = Dni;
        this.BirthDate = BirthDate;
        this.Email = Email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getFormattedBirthDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return BirthDate.format(formatter);
    }
    
    public LocalDate getBirthDate() {
        return BirthDate;
    }
    
    public void setBirthDate(LocalDate BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
}
