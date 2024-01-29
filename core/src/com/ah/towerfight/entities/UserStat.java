package com.ah.towerfight.entities;

public class UserStat {
    private int xp;
    private int coins;
    private int gems;
    private int level;

    public UserStat() {
        // Initialisation par défaut
    }

    public UserStat(int xp, int coins, int gems, int level) {
        this.xp = xp;
        this.coins = coins;
        this.gems = gems;
        this.level = level;
    }

    // Getters et Setters pour xp
    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    // Getters et Setters pour coins
    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    // Getters et Setters pour gems
    public int getGems() {
        return gems;
    }

    public void setGems(int gems) {
        this.gems = gems;
    }

    // Getters et Setters pour level
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
