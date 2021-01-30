package com.vivallo.monster.launcher;

/**
 * Costa Rica 2020 - TEC
 * May the glory be for God
 *
 * @author Andrés Vivallo
 * @version 1.0
 */

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.vivallo.monster.UI.Game;
import com.vivallo.monster.cards.Card;
import com.vivallo.monster.cards.CardReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        new Thread((Runnable) new Game()).start();

    }
}
