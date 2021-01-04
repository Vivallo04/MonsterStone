package com.vivallo.monster.launcher;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {

    private Canvas canvas;

    public Display(int width, int height){
        setTitle("MonsterStone");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        canvas = new Canvas();
        canvas.setPreferredSize((new Dimension(width, height)));
        canvas.setFocusable(false);
        add(canvas);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
