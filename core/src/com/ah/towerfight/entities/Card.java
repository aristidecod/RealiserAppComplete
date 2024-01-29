package com.ah.towerfight.entities;

public class Card {
    private String nom;
    private String description;
    private Rarete rarete;
    private Type type;
    private int degats;
    private int pointsDeVie;
    private int coutEnElixir;

    public Card(String nom, String description, Rarete rarete, Type type, int degats, int pointsDeVie, int coutEnElixir) {
        this.nom = nom;
        this.description = description;
        this.rarete = rarete;
        this.type = type;
        this.degats = degats;
        this.pointsDeVie = pointsDeVie;
        this.coutEnElixir = coutEnElixir;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Rarete getRarete() {
        return rarete;
    }

    public void setRarete(Rarete rarete) {
        this.rarete = rarete;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public int getCoutEnElixir() {
        return coutEnElixir;
    }

    public void setCoutEnElixir(int coutEnElixir) {
        this.coutEnElixir = coutEnElixir;
    }
}



