package com.company;

import java.util.Random;
import java.util.Stack;

public class List {
    ListNode head, tail;
    static Random random = new Random();
    List() {}
    List(String data) { head=tail=new ListNode(data); }
    List append(String data) {
        ListNode node = new ListNode(data);
        if ( head == null ) {
            head = tail = node;
        } else {
            tail = tail.next = node;
        }
        return this;
    }
    void print() {
        for ( ListNode n = head; n != null; n = n.next ) {
            boolean isThereAnotherNode = n.next != null;
            String rightArrow = "→", carriageReturn = "\n";
            System.out.print(n.data + (isThereAnotherNode ? rightArrow : carriageReturn) );
        }
    }
    // Section Med, Challenge A
    List rleEncodeList() {
        List r = new List();
        int rleCount = 1;
        for ( ListNode n = head; n != null; n = n.next ) {
            String currentCharString = n.data;
            String nextCharString = n.next == null ? "" : n.next.data;
            boolean shouldWrite = false;
            final int COMPARISON_IS_EQUAL_CONSTANT = 0;
            if ( currentCharString.compareTo(nextCharString) == COMPARISON_IS_EQUAL_CONSTANT ) {
                rleCount++;
            } else {
                shouldWrite = true;
            }
            if ( shouldWrite ) {
                String rlePrefix = rleCount > 1 ? ("" + rleCount + "$") : "";
                r.append(rlePrefix + currentCharString);
                rleCount = 1;
            }
        }
        return r;
    }
    int getRleCount(String s) {
        if (s.indexOf('$') == -1) return 1;
        String number = s.substring(0,s.indexOf('$'));
        return Integer.parseInt(number);
    }
    String getRleSuffix(String s) {
        if (s.indexOf('$') == -1) return s;
        return s.substring(s.indexOf('$')+1);
    }
    List rleDecodeList() {
        List r = new List();
        for ( ListNode n = head; n != null; n = n.next ) {
            String str = n.data;
            int getRleCount = getRleCount(str);
            for (int i = 0; i < getRleCount; i++) {
                String suffix = getRleSuffix(str);
                r.append(suffix);
            }
        }
        return r;
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
