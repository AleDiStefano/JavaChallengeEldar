package com.Eldar.JavaChallenge_Ej2.model;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
public class CardHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String lastName;
    private String dni;
    private LocalDate birthDate;
    private String email;

    public CardHolder() {
    }

    public CardHolder(int Id, String Name, String LastName, String Dni, LocalDate BirthDate, String Email) {
        this.id = Id;
        this.name = Name;
        this.lastName = LastName;
        this.dni = Dni;
        this.birthDate = BirthDate;
        this.email = Email;
    }


    public String getFormattedBirthDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return birthDate.format(formatter);
    }


}
