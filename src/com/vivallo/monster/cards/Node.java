package com.vivallo.monster.cards;

public class Node {

    public Card element;
    public Node next;

    public Node(Card element) {
        this.element = element;
    }

   public Card getElement() {
        return this.element;
   }



}
