package com.Eldar.JavaChallenge_Ej2.repository;

import com.Eldar.JavaChallenge_Ej2.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICreditCardRepository extends JpaRepository<CreditCard, Integer> {
    Optional<CreditCard> findByNumberAndCvv(String number, String cvv);


    Optional<CreditCard> findByNumber(String number);
}
