package com.Eldar.JavaChallenge_Ej2.service;

import com.Eldar.JavaChallenge_Ej2.model.CardHolder;

import java.util.List;

public interface ICardHolderService {

    public List<CardHolder> getCardHolders();

    public void addCardHolder(CardHolder cardHolder);

    public void removeCardHolder(CardHolder cardHolder);
    public CardHolder getCardHolderById(int id);
    public CardHolder getCardHolderByDNI(String dni);
    public void updateCardHolder(CardHolder cardHolder);
}
