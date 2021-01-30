package com.vivallo.monster.cards;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

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

    private static final Gson gson = new Gson();

    /**
     * Read "cards.json" file which contains all the
     * different cards for the game
     * @throws FileNotFoundException
     */

    public static void getCards() throws FileNotFoundException {
        JsonReader cardsFile = new JsonReader(new FileReader("src/cards.json"));
        Card[] cards = gson.fromJson(cardsFile, Card[].class);
        for (Card card: cards) {
            card.getEvent();
        }
    }


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

}