package com.vivallo.monster.UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

public class GraphicController extends JComponent {

    private final Image background;
    private Observer Observer;


    /**Constructor
     *
     * @param fileName background file directory
     * @throws IOException Not found
     */

    public GraphicController(String fileName) throws IOException {
        background = ImageIO.read(new File(fileName));
        dragCard();
    }


    /**
     * Paint graphics onto the screen
     * @param graphics file Name
     */
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(background, 0, 0, Observer);
    }


    /**Handle Mouse Events
     *
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
