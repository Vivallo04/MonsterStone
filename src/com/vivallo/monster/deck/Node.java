package com.vivallo.monster.deck;

import com.vivallo.monster.cards.Card;

public class Node {

    public Card element;
    public Node next;

    /**
     * Create a new Node that contains:
     * @param element Card
     */
    public Node(Card element) {
        this.element = element;
    }


    /**
     * Get the element of the Node
     * @return Node that contains card
     */
    public Card getElement() {
        return this.element;
    }
}
