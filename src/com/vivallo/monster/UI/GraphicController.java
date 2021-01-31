package com.vivallo.monster.UI;

import com.vivallo.monster.cards.Card;
import com.vivallo.monster.deck.DeckStack;

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

public class GraphicController extends JPanel implements ActionListener {


    //Game assets
    private final Image background;
    private final Image cardStack;
    private BufferedImage card;
    private int mouseX;
    private int mouseY;
    private Observer Observer;
    private DeckStack deck;
    private boolean takeCard = false;


    /**
     * Constructor, draw everything on screen
     * @throws IOException Not found
     */
    public GraphicController() throws IOException {

        Card cards = new Card();

        DeckStack deck = new DeckStack(cards.getCards());
        deck.pushCard(cards.file(0));

        cardStack = ImageIO.read(new File("assets/cards/cardFinalSize.png"));
        background = ImageIO.read(new File("assets/board/table.png"));
        card = ImageIO.read(new File(deck.peek().getFile()));
        createButton(cardStack, "Deck", 735, 340, 143, 206);
        setLayout(null);

        dragCard();

    }


    /**
     * Paint graphics onto the screen
     * @param graphics file Name
     */
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.drawImage(background, 0, 0, Observer);

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
        }
    }


}
