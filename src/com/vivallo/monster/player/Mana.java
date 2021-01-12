package com.vivallo.monster.player;

public class Mana {

    private int currentMana;
    private int maxMana;
    private int minimumMana;

    public int getMana() {
        return currentMana;
    }

    public void increaseMana() {
        currentMana++;
    }

    public void reduceMana() {
        currentMana--;
    }

}
