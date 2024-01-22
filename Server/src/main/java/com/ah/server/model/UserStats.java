package com.ah.server.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "userstats")
public class UserStats {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Integer xp;
    private Integer level;
    private Integer coins;
    private Integer gems;

    public UserStats(Long userId, User user, Integer xp, Integer level, Integer coins, Integer gems) {
        this.userId = userId;
        this.user = user;
        this.xp = xp;
        this.level = level;
        this.coins = coins;
        this.gems = gems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getGems() {
        return gems;
    }

    public void setGems(Integer gems) {
        this.gems = gems;
    }
}
