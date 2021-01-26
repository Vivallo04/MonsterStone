package com.vivallo.monster.cards;

public abstract class Card implements CardReader {

    protected int cost;
    protected int heal;
    protected int attack;
    protected Card type;
    protected String id;
    protected String name;
    protected Boolean steal;
    protected Boolean power;
    protected Boolean freeze;
    protected String event;

    public int getCost() {
        return this.cost;
    }

    public int getDamage() {
        return this.attack;
    }

    public Card getType() {
        return this.type;
    }

    public String getId() {

        return this.id;
    }


}
