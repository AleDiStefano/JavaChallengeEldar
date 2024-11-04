package com.Eldar.JavaChallenge_Ej2.controller;

import com.Eldar.JavaChallenge_Ej2.model.CardHolder;
import com.Eldar.JavaChallenge_Ej2.service.CardHolderService;
import com.Eldar.JavaChallenge_Ej2.service.ICardHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardHolderController {

    @Autowired
    private ICardHolderService cardHolderService;

    @GetMapping("/cardHolder/get")
    public List<CardHolder> getCardHolder() {
        return cardHolderService.getCardHolders();
    }

    @GetMapping("/cardHolder/getById/{id}")
    public CardHolder getCardHolderById(@PathVariable int id) {
        return (CardHolder) cardHolderService.getCardHolderById(id);
    }

    @PostMapping("/cardHolder/create")
    public void createCardHolder(@RequestBody CardHolder cardHolder) {
        cardHolderService.addCardHolder(cardHolder);
    }

    @DeleteMapping("/cardHolder/delete/{id}")
    public void deleteCardHolder(@PathVariable int id) {
        cardHolderService.removeCardHolder(cardHolderService.getCardHolderById(id));
    }

    @PutMapping("cardHolder/edit")
    public void updateCardHolder(@RequestBody CardHolder cardHolder) {
        cardHolderService.updateCardHolder(cardHolder);
    }
}
