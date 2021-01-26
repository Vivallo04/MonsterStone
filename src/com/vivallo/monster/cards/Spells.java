package com.vivallo.monster.cards;

import java.util.concurrent.ThreadLocalRandom;

public class Spells extends Card{

    public boolean isFrozen() {
        return this.freeze = true;
    }

    public boolean stealCard() {
        return this.steal = true;
    }

    public int heal() {
        int number = ThreadLocalRandom.current().nextInt(1, 4 + 1);
        return number;
    }

    public void ultimatePower() {

    }



}
