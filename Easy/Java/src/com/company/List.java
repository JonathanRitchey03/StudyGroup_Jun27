package com.company;

public class List {
    ListNode head, tail;
    public List(String data) {
        head = tail = new ListNode(data);
    }
    public void append(String data) {
        ListNode node = new ListNode(data);
        if ( head == null ) {
            head = tail = node;
        } else {
            tail = tail.next = node;
        }
    }
    public void print() {
        for ( ListNode n = head; n != null; n = n.next ) {
            boolean isThereAnotherNode = n.next != null;
            String rightArrow = "→", carriageReturn = "\n";
            System.out.print(n.data + (isThereAnotherNode ? rightArrow : carriageReturn) );
        }
    }
}
