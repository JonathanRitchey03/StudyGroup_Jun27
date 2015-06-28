package com.company;

public class Main {

    public static void main(String[] args) {
        List testList = new List("Apple");
	    testList.append("Boat");
        testList.append("Cat");
        testList.append("Dog");
        testList.append("Eye");
        testList.print();
    }
}
