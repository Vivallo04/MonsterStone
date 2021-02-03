package com.vivallo.monster.player;

import com.vivallo.monster.cards.Card;
import com.vivallo.monster.deck.DeckStack;

public class Player {

    public DeckStack<Card> deck;
    private int mana;
    private int health;
    private boolean power;

    private int maxMana = 200;
    private int minMana = 0;

    private int maxHealth = 1000;
    private int minHealth = 0;

    private int cardCount;


    public Player(DeckStack deck) {
        mana = 200;
        health = 1000;
        power = false;
        deck = deck;
        cardCount = 16;

    }

    //Card Methods -----------------------------------
    public void playCard(String cardID) {

    }

    public boolean maxPower() {
        return power = true;
    }

    public int getCardCount() {
        return cardCount;
    }

    public void increaseCardCount() {
        cardCount++;
    }

    public void decreaseCardCount() {
        cardCount--;
    }


    //Health methods ---------------------------------
    public int getHealth() {
        return health;
    }

    public void increaseHealth() {
        if (health >= maxHealth) {
            health = maxHealth;
        }
        health += 50;
    }

    public void reduceHealth() {
        if (health <= minHealth) {
            health = 0;
        }
        health -= 50;
    }

    // Mana Methods ----------------------------------
    public int getMana() {
        return mana;
    }

    public void increaseMana() {
        if (mana >= maxMana) {
            mana = maxMana;
        }
        mana += 50;
    }

    public void reduceMana(int cardCost) {
        if (mana <= minMana) {
            mana = minMana;
        }
        mana -= cardCost;
    }


}
