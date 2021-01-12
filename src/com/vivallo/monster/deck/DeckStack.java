package com.vivallo.monster.deck;

import com.vivallo.monster.cards.Card;
/*
* This class is used as a stack
*
*
*
*/

public class DeckStack {

    public Node next;
    public Node head = null;
    public int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public void append(Card element) {
        Node newNode = new Node(element);

    }
}
