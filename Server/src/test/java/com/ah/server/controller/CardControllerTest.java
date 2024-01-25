package com.ah.server.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.ah.server.model.Card;
import com.ah.server.model.Rarete;
import com.ah.server.model.Type;
import com.ah.server.service.CardService;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

@WebMvcTest(CardController.class)
@AutoConfigureMockMvc(addFilters = false)  // Désactive les filtres de sécurité
public class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardService cardService;

    private ObjectMapper objectMapper = new ObjectMapper();

    // Test pour récupérer toutes les cartes
    @Test
    public void getAllCardsTest() throws Exception {
        Card card1 = new Card("nom1", "NomCarte1", Rarete.COMMUNE, Type.BATIMENT, 5, 300, 2);
        Card card2 = new Card("nom2", "NomCarte2", Rarete.RARE, Type.SORT, 7, 300, 2);

        given(cardService.getAllCards()).willReturn(Arrays.asList(card1, card2));

        mockMvc.perform(get("/api/cards"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
        // Ajoutez plus d'assertions si nécessaire
    }

    // Test pour récupérer des cartes par rareté
    @Test
    public void getCardsByRareteTest() throws Exception {
        Card card1 = new Card("nom1", "NomCarte1", Rarete.COMMUNE, Type.BATIMENT, 5, 300, 2);
        Rarete rarete = Rarete.RARE;

        given(cardService.getCardsByRarete(rarete)).willReturn(Arrays.asList(card1));

        mockMvc.perform(get("/api/cards/rarete/" + rarete))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
        // Ajoutez plus d'assertions si nécessaire
    }

    // Test pour récupérer des cartes par type
    @Test
    public void getCardsByTypeTest() throws Exception {
        Card card1 = new Card("nom1", "NomCarte1", Rarete.COMMUNE, Type.BATIMENT, 5, 300, 2);
        Type type = Type.SORT;

        given(cardService.getCardsByType(type)).willReturn(Arrays.asList(card1));

        mockMvc.perform(get("/api/cards/type/" + type))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
        // Ajoutez plus d'assertions si nécessaire
    }

    // Test pour ajouter une nouvelle carte
    @Test
    public void addCardTest() throws Exception {
        Card card = new Card("nom1", "NomCarte1", Rarete.COMMUNE, Type.BATIMENT, 5, 300, 2);
        given(cardService.addCard(any(Card.class))).willReturn(card);

        mockMvc.perform(post("/api/cards")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(card)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value(card.getNom()));
        // Ajoutez plus d'assertions si nécessaire
    }

    // Test pour mettre à jour une carte
    @Test
    public void updateCardTest() throws Exception {
        Card updatedCard = new Card("nom1", "NomCarte1", Rarete.COMMUNE, Type.BATIMENT, 5, 300, 2);
        given(cardService.updateCard(eq(1L), any(Card.class))).willReturn(updatedCard);

        mockMvc.perform(put("/api/cards/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedCard)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value(updatedCard.getNom()));
        // Ajoutez plus d'assertions si nécessaire
    }

    // Test pour supprimer une carte
    @Test
    public void deleteCardTest() throws Exception {
        doNothing().when(cardService).deleteCard(1L);

        mockMvc.perform(delete("/api/cards/1"))
                .andExpect(status().isOk());
    }
}
