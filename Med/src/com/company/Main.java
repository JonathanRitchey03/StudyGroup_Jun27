package com.company;

public class Main {

    public static void main(String[] args) {
        medSectionA();
        medSectionB();
    }
    static void medSectionB() {
        printSection("Med-Section B");
        /*
        5$A		 		RLE-decodes to: A→A→A→A→A
	    3$B→C		 	RLE-decodes to: B→B→B→C
         */
        List testList = new List("5$A");
        testList.print();
        testList.rleDecodeList().print();
        List testList2 = new List("3$B").append("C");
        testList2.print();
        testList2.rleDecodeList().print();
        List testList3 = new List("B").append("2$C").append("3$Z").append("R");
        testList3.print();
        testList3.rleDecodeList().print();
    }
    static void medSectionA() {
        printSection("Med-Section A");
        /*
        B→A→A→A 		RLE-encodes to: B→3$A
	    B→A→A→Z→Z 	RLE-encodes to: B→2$A→2$Z
	    B→R→Z→M 		RLE-encodes to: B→R→Z→M
         */
        List testList = new List("B").append("A").append("A").append("A");
        testList.print();
        testList.rleEncodeList().print();
        List testList2 = new List("B").append("A").append("A").append("A").append("Z").append("Z");
        testList2.print();
        testList2.rleEncodeList().print();
        List testList3 = new List("B").append("R").append("Z").append("M");
        testList3.print();
        testList3.rleEncodeList().print();
    }
    static void printSection(String sectionName) {
        System.out.println();
        System.out.println(sectionName);
        System.out.println("---------------------------");
    }
}
