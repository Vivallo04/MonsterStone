package com.vivallo.monster.launcher;
/*
* May the glory be for God
*
* @author: Andrés Vivallo
 */


public class Main {

    public static void main(String[] args) {

      new Thread(new GameLoop(new Game(1000, 600))).start();

    }
}
