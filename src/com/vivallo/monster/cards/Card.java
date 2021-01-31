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
    protected String file;

    private static final Gson gson = new Gson();

    /**
     * Read "cards.json" file which contains all the
     * different cards for the game
     * @throws FileNotFoundException
     * @return
     */
    public Class<? extends Card> getCards() throws FileNotFoundException {
        JsonReader cardsFile = new JsonReader(new FileReader("src/cards.json"));
        Card[] cards = gson.fromJson(cardsFile, Card[].class);
        for (Card card: cards) {
            return card.getClass();
        }
        return null;
    }


    public void Events() throws FileNotFoundException {
        JsonReader cardsFile = new JsonReader(new FileReader("src/cards/cards.json"));
        Card[] cards = gson.fromJson(cardsFile, Card[].class);
        for (Card card: cards) {
            card.getEvent();
        }
    }

    public Card file(int pos) throws FileNotFoundException {
        JsonReader cardsFile = new JsonReader(new FileReader("src/cards.json"));
        Card[] cards = gson.fromJson(cardsFile, Card[].class);
        return cards[pos];

    }


    /**
     * Create a new deck for players
     */
    public void createDeck() throws FileNotFoundException {
        int count = 0;
        int deckSize = 16;

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

    public String getFile(){
        return file;
    }
}