package com.vivallo.monster.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class Menu extends JPanel implements ActionListener {

    Font font = new Font("JetBrains Mono NL Regular", Font.BOLD, 30);
    Font Lfont = new Font("JetBrains Mono NL Regular", Font.BOLD, 90);


    public Menu() {
        setUI();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);


    }

    public void createButton(String text, String action, int x, int y, int w, int h) {
        JButton button = new JButton(text);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);
        button.addActionListener(this);
        button.setActionCommand(action);
        button.setBounds(x, y, w, h);
        button.setFont(font);
        button.setForeground(Color.WHITE);
        add(button);
    }

    public void createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(Lfont);
        label.setBounds(x, y, 1000, 200);
        label.setForeground(Color.WHITE);
        add(label);

    }

    public void setUI() {
        setLayout(null);
        setBackground(Color.BLACK);
        createButton("Play (Host)","Board", 625, 330, 200, 50);
        createButton("Join", "Game", 625, 400, 200, 50);
        createButton("Credits","Game",  625, 470, 200, 50);
        createButton("Exit", "Exit", 625, 540, 200, 50);
        createLabel("MonsterStone", 410, 25);
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();
        if (action.equals("Board")) {

        }
        if (action.equals("Exit")) {
            System.exit(0);
        }

    }
}
