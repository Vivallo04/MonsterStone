package com.vivallo.monster.deck;

import com.vivallo.monster.cards.Card;

/*
* This class is used as a stack
* for the cards before they go
* to the player's hand.
*/

public class DeckStack {

    public Node next;
    public Node head;
    public int size = 0;


    /**
     *Add a card to the tail of the
     * stack
     * @param element to append
     */
    public void appendCard(Card[] element) {

        if (isEmpty()) {
            head = new Node(element);
            size++;

        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(element);
            size++;
        }
    }


    public boolean isEmpty(){
        return this.size == 0;
    }

    public int len(){
        return this.size;
    }

    public void pop() {

        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        Node currentNode = head.next;
        this.size--;
    }

    public void getDeck() {
        Node currentNode = head;

        while (currentNode != null) {
            System.out.println(currentNode.getElement());
            currentNode = currentNode.next;
        }
    }

}
