package com.vivallo.monster.UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends JFrame implements Runnable{

    private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    //Game Constants
    private int WIDTH = 1285;
    private int HEIGHT = 939;

    //Game Assets
    private Image icon = Toolkit.getDefaultToolkit().getImage("assets/extras/icon.png");
    private Image card_stack = Toolkit.getDefaultToolkit().getImage("assets/extras/cardFinalSize");


    public Game() {
        drawGameBoard();
        gameLoop();

    }


    public void drawGameBoard() {

        try {
            add(new GraphicController());

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        setTitle("MonsterStone");
        setIconImage(icon);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setVisible(true);
    }


    /**
     * Stop the Thread so that the
     * the CPU can focus on other stuff
     */
    public void gameLoop() {

        try {
            while (true) {
                Thread.sleep(5);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "Unable to run game main loop");
        }
    }


    /**
     * Start Game class as a new Thread
     */
    @Override
    public void run() {
        new Thread().start();
    }


    public void stop(){
        System.exit(0);
    }
}
