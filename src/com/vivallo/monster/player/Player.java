package com.vivallo.monster.player;

import com.vivallo.monster.cards.Card;
import com.vivallo.monster.cards.CircularHand;
import com.vivallo.monster.deck.DeckStack;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.io.File;
import java.io.IOException;

public class Player {

    private CircularHand hand;

    private int mana;
    private int health;
    private boolean power;


    private int maxMana = 200;
    private int minMana = 0;

    private int maxHealth = 1000;
    private int minHealth = 0;

    private int cardCount;


    public Player(Card cards) {
        hand = new CircularHand();
        mana = 200;
        health = 1000;
        power = false;
        cards = cards;
        cardCount = 16;


    }


    public void addCard(DeckStack<Card> deck) {
         hand.appendCard(deck.peek());
         deck.pop();
    }

    public Image getCardImageFile() throws IOException {
        int counter = 0;

        while (counter <= hand.getSize()) {
            return ImageIO.read(new File(hand.getCardAt(1).getElement().getFile()));
        };
        return null;
    }




    //Card Methods ----------------------------------- ||
    public void playCard(String cardID) {

    }

    public boolean maxPower() {
        this.power = true;
        return power;
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
