package com.vivallo.monster.deck;

import com.vivallo.monster.cards.Card;

/*
* This class is used as a stack
* for the cards before they go
* to the player's hand.
*/

public class DeckStack {

    public Node next;
    public Node head = null;
    public int size = 0;


    /**
     *
     * @param element to append
     *
     */

    public void append(Card element) {
        Node newNode = new Node(element);
        size++;
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode = head;
            while (newNode != null) {
                newNode = newNode.next;
            }
            newNode.next = new Node(element);
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
