package com.ah.server.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Embeddable;

@Entity
@Table(name = "usercards")
public class UserCard {

    @EmbeddedId
    private UserCardId id;

    private Integer quantity;

    public UserCard(UserCardId id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Embeddable
    public static class UserCardId implements java.io.Serializable {
        @Column(name = "user_id")
        private Long userId;

        @Column(name = "card_id")
        private Long cardId;

        public UserCardId() {
        }

        public UserCardId(Long userId, Long cardId) {
            this.userId = userId;
            this.cardId = cardId;
        }

        public Long getUserId() {
            return userId;
        }

        public Long getCardId() {
            return cardId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public void setCardId(Long cardId) {
            this.cardId = cardId;
        }
    }
}
