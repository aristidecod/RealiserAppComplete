package com.ah.towerfight.entities;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cartes;

    public Deck() {
        this.cartes = new ArrayList<>();
    }

    public void ajouterCarte(Card carte) {
        cartes.add(carte);
    }

    public void retirerCarte(Card carte) {
        cartes.remove(carte);
    }

    public List<Card> getCartes() {
        return cartes;
    }

    public void setCartes(List<Card> cartes) {
        this.cartes = cartes;
    }
}

