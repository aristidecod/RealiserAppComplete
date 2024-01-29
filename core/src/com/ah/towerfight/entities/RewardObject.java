package com.ah.towerfight.entities;

public class RewardObject {
    private String type;
    private String name;
    private int quantitie;

    public RewardObject(String type, String name, int quantitie) {
        this.type = type;
        this.name = name;
        this.quantitie = quantitie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters et Setters pour quantitie
    public int getQuantitie() {
        return quantitie;
    }

    public void setQuantitie(int quantitie) {
        this.quantitie = quantitie;
    }
}
