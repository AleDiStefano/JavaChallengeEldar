package com.Eldar.JavaChallenge_Ej2.repository;

import com.Eldar.JavaChallenge_Ej2.model.CardHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardHolderRepository extends JpaRepository<CardHolder, Integer> {

}
