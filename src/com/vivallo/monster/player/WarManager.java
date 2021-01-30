package com.vivallo.monster.player;

import com.vivallo.monster.UI.Observer;

import java.awt.*;

public abstract class WarManager implements Observer {

    private Player player1;
    private Player player2;

    public void startWar() {
        System.out.println("War has started");
    }



}
