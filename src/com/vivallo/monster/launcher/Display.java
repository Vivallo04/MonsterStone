package com.vivallo.monster.launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

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

        canvas.createBufferStrategy(3);



        setLocationRelativeTo(null);
        setVisible(true);
    }


    public void render(Game game) {
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        //Free the graphics memory
        graphics.dispose();
        bufferStrategy.show();


    }
}
