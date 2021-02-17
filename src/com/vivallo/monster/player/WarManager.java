package com.vivallo.monster.player;

import com.vivallo.monster.cards.Card;
import com.vivallo.monster.cards.CircularHand;
import com.vivallo.monster.deck.DeckStack;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WarManager {

    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private DeckStack<Card> deck = new DeckStack<Card>();
    private Player player1;
    private Player player2;
    private boolean inTurn = false;


    public WarManager() throws FileNotFoundException {
        this.player1 = new Player(null);
        this.player2 = new Player(null);


    }


    public void getAttack() {

    }


    public void getCard() {

    }

    public Image getPlayersCards(Player player) throws IOException {
        return player.getCardImageFile();
    }




}
