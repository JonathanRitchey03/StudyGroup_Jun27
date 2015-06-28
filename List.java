package com.company;

import java.util.Random;
import java.util.Stack;

public class List {
    ListNode head, tail;
    static Random random = new Random();
    List() {}
    List(String data) { head=tail=new ListNode(data); }
    void append(String data) {
        ListNode node = new ListNode(data);
        if ( head == null ) {
            head = tail = node;
        } else {
            tail = tail.next = node;
        }
    }
    void print() {
        for ( ListNode n = head; n != null; n = n.next ) {
            boolean isThereAnotherNode = n.next != null;
            String rightArrow = "→", carriageReturn = "\n";
            System.out.print(n.data + (isThereAnotherNode ? rightArrow : carriageReturn) );
        }
    }
    // Section Easy, Challenge B
    static List createRandomList(int numNodes, char minLetter, char maxLetter) {
        List list = new List();
        for ( int i = 0; i < numNodes; i++ ) {
            list.append(getRandomLetterString(minLetter,maxLetter));
        }
        return list;
    }
    static List createPalindromeList(int numNodes, char minLetter, char maxLetter) {
        List list = new List();
        Stack<String> stack = new Stack<String>();
        int midPointIndex = (numNodes-1)/2;
        boolean isNumNodesOdd = numNodes % 2 == 1;
        for ( int i = 0; i <= midPointIndex; i++ ) {
            String randomLetterString = getRandomLetterString(minLetter, maxLetter);
            boolean skipPushOnExactMidpoint = isNumNodesOdd && i == midPointIndex;
            if ( !skipPushOnExactMidpoint ) stack.push(randomLetterString);
            list.append(randomLetterString);
        }
        while ( !stack.empty() ) {
            list.append(stack.pop());
        }
        return list;
    }
    static String getRandomLetterString(char minLetter, char maxLetter) {
        int delta = maxLetter - minLetter;
        int randomDelta = ( delta > 0) ? random.nextInt(delta) : 0;
        int randomLetterCode = minLetter + randomDelta;
        return ""+(char)randomLetterCode;
    }
}
