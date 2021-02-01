package com.vivallo.monster.player;

import com.vivallo.monster.cards.Card;
import com.vivallo.monster.deck.DeckStack;

import java.io.FileNotFoundException;
import java.util.Random;

public class WarManager {

    private static Card cards;
    private static Player player1;
    private static Player player2;

    private static Random rand = new Random();


    public WarManager() throws FileNotFoundException {

        int num = rand.nextInt(31);
        cards = cards.getRandomCard(num);

        DeckStack<Card> deck1 = new DeckStack<Card>();
        DeckStack<Card> deck2 = new DeckStack<Card>();
        createDeck(deck1);
        createDeck(deck2);

        player1 = new Player(deck1);
        player2 = new Player(deck2);
    }


    public DeckStack<Card> createDeck(DeckStack deck) throws FileNotFoundException {
        int count = 0;
        int maxCards = 8;
        int num = rand.nextInt(30);

        while (count < maxCards) {
            deck.pushCard(cards.getRandomCard(num));
            //player1.decreaseCardCount();
            //player2.decreaseCardCount();
            count++;
        }
        return deck;
    }

}
