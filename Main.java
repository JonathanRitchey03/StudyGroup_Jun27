package com.company;

public class Main {

    public static void main(String[] args) {
        easySectionA();
        easySectionB();
        easySectionC();
    }
    static void easySectionC() {
        printSection("Easy-Section C");
        List.createPalindromeList(3, 'A', 'C').print();
        List.createPalindromeList(4, 'C', 'C').print();
        List.createPalindromeList(5, 'F', 'R').print();
        List.createPalindromeList(2,'G','G').print();
    }
    static void easySectionB() {
        printSection("Easy-Section B");
        List.createRandomList(6,'A','C').print();
        List.createRandomList(5,'C','C').print();
        List.createRandomList(2,'A','Z').print();
    }
    static void easySectionA() {
        printSection("Easy-Section A");
        List testList = new List("Apple");
        testList.append("Boat");
        testList.append("Cat");
        testList.append("Dog");
        testList.append("Eye");
        testList.print();
        List testList2 = new List("A");
        testList2.print();
        List testList3 = new List("Z");
        testList3.append("12");
        testList3.append("M");
        testList3.append("String1");
        testList3.print();
    }
    static void printSection(String sectionName) {
        System.out.println();
        System.out.println(sectionName);
        System.out.println("---------------------------");
    }
}
