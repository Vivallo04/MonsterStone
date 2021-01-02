package com.vivallo.monster.cards;

public class CircularLinkedList {

    public Node head = null;
    public Node tail = null;
    public int size = 0;


    public boolean isEmpty() {
        return size == 0;
    }

    public int len() {
        return size;
    }


    public void appendCard(Card element){

        Node newNode = new Node(element);

        if(isEmpty()) {
          head = newNode;
          tail = newNode;
          newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void getList(){
        Node currentNode = head;

        if(isEmpty()) {
            System.out.println("The list is empty");
        }
        while (currentNode != head) {
            System.out.println(currentNode.getElement());
        }
    }

}
