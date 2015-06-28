package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        hardSectionA();
        hardSectionB();
        hardSectionC();
    }
    static void hardSectionC() {
        printSection("Hard Section C");
        Node randomTree = Node.makeRandomTree(10,90);
        randomTree.printTree();
        ArrayList<String> list = randomTree.serialize();
        for ( String s : list ) {
            System.out.print(s+" ");
        }
        System.out.println();
        Node deserializedTree = Node.deserialize(list);
        deserializedTree.printTree();
    }
    static void hardSectionB() {
        printSection("Hard Section B");
        Node.makeRandomTree(20,90).printTree();
    }
    static void hardSectionA() {
        printSection("Hard Section A");
        Node root = new Node("d","h","f");
        root.left.right = new Node("c");
        root.left.right.left = new Node("b");
        root.right.left = new Node("e");
        root.right.right = new Node("a");
        root.right.right.left = new Node("g");
        root.printTree();
    }
    static void printSection(String section) {
        System.out.println();
        System.out.println(section);
        System.out.println("--------------------");
    }
}
