package com.vivallo.monster.cards;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

public class Card {

    protected int id;
    protected String type;
    protected String name;
    protected String rarity;
    protected int cost;
    protected int attack;
    protected boolean heal;
    protected boolean steal;
    protected boolean power;
    protected boolean freeze;
    protected String event;
    protected String file;
    private Random rand = new Random();
    private boolean[] isUsed = new boolean[30];

    private static final Gson gson = new Gson();


    /**
     * Read "cards.json" file which contains all the
     * different cards for the game
     * @throws FileNotFoundException
     * @return
     */
    public Class<? extends Card> getCards() throws FileNotFoundException {
        Card[] cards = readCard();
        for (Card card: cards) {
            return card.getClass();
        }
        return null;
    }

    public Card[] readCard() throws FileNotFoundException {
        JsonReader cardsFile = new JsonReader(new FileReader("src/cards.json"));
        Card[] cards = gson.fromJson(cardsFile, Card[].class);
        return cards;
    }

    public void Events() throws FileNotFoundException {
        Card[] cards = readCard();
        for (Card card: cards) {
            card.getEvent();
        }
    }


    public Card getRandomCard(int num) throws FileNotFoundException {
        Card[] cards = readCard();

        if (isUsed[num] && num == 30) {
            return getRandomCard(1);
        } else if (isUsed[num]) {
            return getRandomCard(num + 1);
        }
        isUsed[num] = true;
        return cards[num];
    }


    public void resetIsUsed() {
        for (int i = 0; i < isUsed.length; i++) {
            isUsed[i] = false;
        }
    }



    // Getters & Setters -------------------------------------------------------- ||
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getRarity() {
        return rarity;
    }

    public int getCost() {
        return cost;
    }

    public int getAttack() {
        return attack;
    }

    public boolean isHeal() {
        return heal;
    }

    public boolean isSteal() {
        return steal;
    }

    public boolean isPower() {
        return power;
    }

    public boolean isFreeze() {
        return freeze;
    }

    public String getEvent() {
        return event;
    }

    public String getFile(){
        return file;
    }
}