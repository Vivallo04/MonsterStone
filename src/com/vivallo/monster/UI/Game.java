package com.vivallo.monster.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends JFrame implements Runnable{

    private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    //Game Constants
    private int WIDTH = 1285;
    private int HEIGHT = 939;
    private volatile boolean running = true;
    public final BufferStrategy bufferStrategy = getBufferStrategy();

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
        setIgnoreRepaint(true);
        //createBufferStrategy(2);
        setVisible(true);
        setLocationRelativeTo(null);

        try {
            add(new GraphicController());

        } catch (IOException exception) {
            exception.printStackTrace();
            logger.log(Level.SEVERE, "Unable to initialize game graphics");
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
        while (running) {
            drawGame();
            run();
            repaint();

            try {
                Thread.sleep(60);

            } catch (InterruptedException e) {
                e.printStackTrace();
                logger.log(Level.SEVERE, "Unable to run game main loop");
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



}
