package com.vivallo.monster.cards;

public class CircularHand {

    private Node head = null;
    private int size;


    public CircularHand() {
        size = 0;
    }

    public Node getCardAt(int index) {
        Node current = head;
        int pos = 0;
        while (pos <= index) {
            current = current.next;
            if (current == head) {
                return null;
            }
        }
        return current;
    }

    public void push(Card element) {
        Node newNode = new Node(element);

        newNode.next = head;
        newNode.previous = null;

        if (isEmpty()) {
            size++;
            head.previous = newNode;
        }
        size++;
        head = newNode;
    }

    public void insertAfter(Node prev, Node element) {
        size++;
        element.previous = prev;
        element.next = prev.next;
        element.next.previous = element;
        prev.next = element;

    }

    public void insertBefore(Node reference, Node element) {
        insertAfter(reference.previous, element);
    }

    public void appendCard(Card element){
        Node newNode = new Node(element);
        Node last = head;

        newNode.next = null;

        if(isEmpty()) {
            size++;
            newNode.previous = null;
            head = newNode;

        }

        while (last.next != null) {
            last = last.next;
        }
        size++;
        last.next = newNode;
        newNode.previous = last;
    }


    public void getList(){
        Node currentNode = head;

        if(isEmpty()) {
            System.out.println("The list is empty");
        }
        while (currentNode != null) {
            System.out.println(currentNode.getElement());
            Node last = head;
            currentNode = currentNode.next;
        }
    }


    public void removeCard(Node card) {
        size--;
        if (head.next == head) {
            head = null;
        } else {
            card.previous.next = card.next;
            card.next.previous = card.previous;

            if(head == card) {
                head = card.next;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int len() {
        return size;
    }

}