package com.vivallo.monster.player;

import com.vivallo.monster.cards.Card;
import com.vivallo.monster.deck.DeckStack;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WarManager {

    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private Player player1;
    private Player player2;
    private Card cards;
    private boolean inTurn; 

    private static Random rand = new Random();


    public WarManager(Player player1, Player player2) throws FileNotFoundException {
        this.player1 = player1;
        this.player2 = player2;


        DeckStack<Card> deck1 = new DeckStack<Card>();
        DeckStack<Card> deck2 = new DeckStack<Card>();
        createDeck(deck1);
        createDeck(deck2);

    }


    public DeckStack<Card> createDeck(DeckStack deck) throws FileNotFoundException {
        int count = 0;
        int maxCards = 8;
        int num = rand.nextInt(30);

        while (count < maxCards) {
            deck.pushCard(cards.getRandomCard(num));
            count++;
        }
        return deck;
    }


}
