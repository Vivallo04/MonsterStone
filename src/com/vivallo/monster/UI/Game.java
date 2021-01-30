package com.vivallo.monster.UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends JFrame {

    private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private Image icon = Toolkit.getDefaultToolkit().getImage("assets/extras/icon.png");

    public Game() {

        try {
            add(new GraphicController("assets/board/table1.png"));
            setTitle("MonsterStone");
            setIconImage(icon);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(1285, 939);
            setResizable(false);
            setVisible(true);


        } catch (IOException exception) {
            exception.printStackTrace();
            logger.log(Level.SEVERE, "Couldn't initialize main Thread");
            System.out.println("Error");
        }

    }
}
