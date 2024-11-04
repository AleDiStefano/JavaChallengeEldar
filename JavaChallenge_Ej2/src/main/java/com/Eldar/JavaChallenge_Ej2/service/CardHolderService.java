package com.Eldar.JavaChallenge_Ej2.service;

import com.Eldar.JavaChallenge_Ej2.model.CardHolder;
import com.Eldar.JavaChallenge_Ej2.repository.ICardHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.smartcardio.Card;
import java.time.LocalDate;
import java.util.List;

@Service
public class CardHolderService  implements ICardHolderService {

    @Autowired
    private ICardHolderRepository repo;

    @Override
    public List<CardHolder> getCardHolders() {
        return repo.findAll();
    }

    @Override
    public void addCardHolder(CardHolder cardHolder) {
        repo.save(cardHolder);
    }

    @Override
    public void removeCardHolder(CardHolder cardHolder) {
        repo.delete(cardHolder);
    }

    @Override
    public CardHolder getCardHolderById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public CardHolder getCardHolderByDNI(String dni) {
        return null;
    }

    @Override
    public void updateCardHolder(CardHolder updatedCardHolder) {
        repo.findById(updatedCardHolder.getId()).ifPresent(existingCardHolder -> {
            existingCardHolder.setName(updatedCardHolder.getName());
            existingCardHolder.setLastName(updatedCardHolder.getLastName());
            existingCardHolder.setDni(updatedCardHolder.getDni());
            existingCardHolder.setBirthDate(updatedCardHolder.getBirthDate());
            existingCardHolder.setEmail(updatedCardHolder.getEmail());

            repo.save(existingCardHolder);
        });
    }
}
