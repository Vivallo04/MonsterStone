package com.vivallo.monster.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.*;

public class Game extends JFrame implements Runnable{

    private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    //Game Constants
    private int WIDTH = 1420;
    private int HEIGHT = 962;
    private volatile boolean running = true;


    //Game Assets
    private Image icon = Toolkit.getDefaultToolkit().getImage("assets/extras/icon.png");


    /**
     * Main Thread, run run method
     * while the game runs
     */
    public Game() {
        run();

    }

    /**
     * Draw all the game graphics and
     * create a new window
     */
    public void drawGame() {

        setTitle("MonsterStone");
        setIconImage(icon);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        //setIgnoreRepaint(true);
        //createBufferStrategy(2);
        setVisible(true);
        setLocationRelativeTo(null);

        try {
            add(new GraphicController());

        } catch (IOException exception) {
            exception.printStackTrace();
            logger.log(Level.SEVERE, "Unable to initialize game graphics", exception);
            System.out.println("ERROR");
        }

    }


    /**
     * Start Game class as a new Thread and
     * Stop the Thread so that the
     * the CPU can focus on other stuff.
     */
    @Override
    public void run() {

        new Thread().start();

        try {
            setupLogger();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        while (running) {
            drawGame();
            run();
            repaint();

            try {
                Thread.sleep(60);

            } catch (InterruptedException e) {
                e.printStackTrace();
                logger.log(Level.SEVERE, "Unable to run game main loop", e);

            }
        }
        stop();
    }


    /**
     * Exit the application
     */
    public void stop(){
        System.exit(0);
    }


    public void setupLogger() throws IOException {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);

        //Console Handler
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.WARNING);
        logger.addHandler(ch);

        //TODO Research on the file handler

    }

}
