package com.Eldar.JavaChallenge_Ej2.repository;
import com.Eldar.JavaChallenge_Ej2.model.CreditCard;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class CreditCardRepository implements ICreditCardRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<CreditCard> findByNumberAndCvv(String number, String cvv){
        String query = "SELECT c FROM CreditCard c WHERE c.number = :number AND c.cvv = :cvv";
        CreditCard creditCard = entityManager.createQuery(query, CreditCard.class)
                .setParameter("number", number)
                .setParameter("cvv", cvv)
                .getSingleResult();

        return Optional.ofNullable(creditCard);
    };

    @Query("SELECT c FROM CreditCard c WHERE c.number = ?1")
    public Optional<CreditCard> findByNumber(String number) {
        String jpql = "SELECT c FROM CreditCard c WHERE c.number = :number";
        TypedQuery<CreditCard> query = entityManager.createQuery(jpql, CreditCard.class);
        query.setParameter("number", number);

        return query.getResultStream().findFirst();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends CreditCard> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends CreditCard> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<CreditCard> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public CreditCard getOne(Integer integer) {
        return null;
    }

    @Override
    public CreditCard getById(Integer integer) {
        return null;
    }

    @Override
    public CreditCard getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends CreditCard> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends CreditCard> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends CreditCard> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends CreditCard> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends CreditCard> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends CreditCard> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends CreditCard, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends CreditCard> S save(S entity) {
        return null;
    }

    @Override
    public <S extends CreditCard> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<CreditCard> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<CreditCard> findAll() {
        return List.of();
    }

    @Override
    public List<CreditCard> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(CreditCard entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends CreditCard> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<CreditCard> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<CreditCard> findAll(Pageable pageable) {
        return null;
    }
}
