package com.vivallo.monster.UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

public class GraphicController extends JPanel {

    private final Image background;
    private final Image cardStack;
    private Observer Observer;


    /**
     * Constructor, draw everything on screen
     * @throws IOException Not found
     */
    public GraphicController() throws IOException {
        background = ImageIO.read(new File("assets/board/table2.png"));
        cardStack = ImageIO.read(new File("assets/cards/cardFinalSize.png"));

        dragCard();
    }


    /**
     * Paint graphics onto the screen
     * @param graphics file Name
     */
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(background, 0, 0, Observer);
        graphics.drawImage(cardStack, 736, 340, Observer);

    }


    /**
     *Handle Mouse events
     */
    public void dragCard() {

        addMouseMotionListener(new MouseMotionListener() {
            int mouseX;
            int mouseY;

            @Override
            public void mouseDragged(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                repaint();

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

}
