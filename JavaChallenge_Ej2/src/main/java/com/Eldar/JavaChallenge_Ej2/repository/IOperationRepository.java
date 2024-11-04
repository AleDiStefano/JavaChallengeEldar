package com.Eldar.JavaChallenge_Ej2.repository;

import com.Eldar.JavaChallenge_Ej2.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOperationRepository extends JpaRepository<Operation, Integer> {
}
