package com.vivallo.monster.deck;

import com.vivallo.monster.cards.Card;

import java.util.EmptyStackException;

/*
* This class is used as a stack
* for the cards before they go
* to the player's hand.
*/


public class DeckStack {

    public Node top;
    public int size = 0;

    public DeckStack(Class<? extends Card> cardFiles) {
        Node top = null;
        int size = 0;
    }

    /**
     *Add a card to the top of the
     * stack
     * @param element to append
     */
    public void pushCard(Card element) {

        Node card = new Node(element);
        card.next = top;
        top = card;
        size++;
    }

    /**
     * Return Card at the top of the Stack
     * @return Card
     */
    public Card peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return top.getElement();
        }
    }

    /**
     * Return if stackis empty
     * @return boolean
     */
    public boolean isEmpty(){
        return this.size == 0;
    }


    /**
     * Return stack size
     * @return int Size of the stack
     */
    public int len(){
        return this.size;
    }


    /**
     * Delete the first Node of the Stack
     */
    public void pop() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Card currentNode = top.getElement();
        top = top.next;
        this.size--;
        //return currentNode;
    }


    /**
     * Print the Deck elements to the console
     */
    public void getDeck() {
        Node currentNode = top;

        while (currentNode != null) {
            System.out.println(currentNode.getElement());
            currentNode = currentNode.next;
        }
    }



}
