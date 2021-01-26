package com.vivallo.monster.UI;

import javax.swing.*;
import java.io.IOException;

public class Game extends JFrame {

    public Game() throws IOException {
        super("MonsterStone");
        add(new GraphicController("assets/board/table.png"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 760);
        setVisible(true);

    }
}
