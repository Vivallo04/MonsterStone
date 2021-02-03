package com.vivallo.monster.UI;

import com.vivallo.monster.cards.Card;
import com.vivallo.monster.deck.DeckStack;
import com.vivallo.monster.player.WarManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Board extends JPanel implements ActionListener {


    //Game assets
    private BufferedImage background;
    private BufferedImage cardHolder;
    private BufferedImage cardStack;
    private BufferedImage card;

    private WarManager warManager;
    private Observer Observer;
    private int mouseX;
    private int mouseY;


    private boolean takeCard = false;
    private boolean occupied = false;
    Random random = new Random();


    /**
     * Constructor, draw everything on screen
     * @throws IOException Not found
     */
    public Board() throws IOException {
        setGameAssets();
        setLayout(null);
        dragCard();

    }

    public void setGameAssets() throws IOException {
        background = ImageIO.read(new File("assets/board/board1.png"));
        cardStack = ImageIO.read(new File("assets/cards/cardFinalSize.png"));
        cardHolder = ImageIO.read(new File("assets/cards/CardHolder.png"));
        card = ImageIO.read(new File("assets/cards/minions/card1.png"));
    }

    /**
     * Paint graphics onto the screen
     * @param graphics file Name
     */
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        //Draw the game board
        graphics.drawImage(background, 0, 0, Observer);
        //Paint the UI buttons
        setUI();

        if (takeCard == true) {
            graphics.drawImage(card, mouseX, mouseY, Observer);

        }
    }


    /**
     *Handle Mouse events
     */
    public void dragCard() {
        addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();


            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    public void setUI() {
        createButton(cardStack, "Deck", 750, 355, 143, 206);
        createButton(cardHolder, "placeCard", 1010, 210, 143, 206);
        createButton(cardHolder, "placeCard", 1010, 440, 143, 206);
        createButton(cardHolder, "placeCard", 1010, 660, 143, 206);
        createButton(cardHolder, "placeCard", 1210, 210, 143, 206);
        createButton(cardHolder, "placeCard", 1210, 440, 143, 206);
        createButton(cardHolder, "placeCard", 1210, 660, 143, 206);
    }

    public void createButton(Image file, String action, int x, int y, int w, int h) {
        JButton button = new JButton(new ImageIcon(file));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);
        button.addActionListener(this);
        button.setActionCommand(action);
        button.setBounds(x, y, w, h);
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();
        if (action.equals("Deck")) {
            takeCard = true;
            System.out.println("Working");
        }
        if (action.equals("placeCard")) {
            occupied = true;
            System.out.println("working2");
        }
    }


}
