package com.vivallo.monster.UI;

import javax.swing.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends JFrame {

    private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    public Game() {
        super("MonsterStone");

        try {
            add(new GraphicController("assets/board/table1.png"));
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(1285, 939);
            setResizable(false);
            setVisible(true);

        } catch (IOException exception) {
            exception.printStackTrace();
            logger.log(Level.SEVERE, "Couldn't initialize main Thread");
        }

    }
}
