package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Node {
    String data; Node left, right;
    Node(String aData) { data = aData; }
    Node(String aData,String leftData,String rightData) {
        data = aData; left = new Node(leftData); right = new Node(rightData);
    }
    public void printTree() {
        if (right != null) right.printTree(true, "");
        printNodeValue();
        if (left != null) left.printTree(false, "");
    }
    private void printNodeValue() {
        System.out.print((data==null ? "<null>" : data) + '\n');
    }
    private void printTree(boolean isRight, String indent) {
        if (right != null) {
            right.printTree(true, indent + (isRight ? "        " : " |      "));
        }
        System.out.print(indent + (isRight ? " ┌" : " └") + "───── ");
        printNodeValue();
        if (left != null) {
            left.printTree(false, indent + (isRight ? " |      " : "        "));
        }
    }
    boolean isBST() {
        return isBST(this);
    }
    boolean isBST(Node node)
    {   Node prev = null;
        if (node != null)
        {   if (!isBST(node.left)) return false;
            if (prev != null && node.data.compareTo(node.data)<=0 )
                return false;
            prev = node;
            return isBST(node.right);
        }
        return true;
    }
    static String getRandomLetterString() {
        int letter = 'A' + random.nextInt(26);
        return ""+(char)letter;
    }
    static Random random = new Random();
    static int numNodes = 0;
    static Node makeRandomTree(int aNumNodes, int percentChance ) {
        Node root = new Node(getRandomLetterString());
        numNodes = aNumNodes;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while ( !queue.isEmpty() ) {
            Node n = queue.remove();
            n.left = makeRandomNode(percentChance);
            n.right = makeRandomNode(percentChance);
            if ( n.left != null ) {
                queue.add(n.left);
            }
            if ( n.right != null ) {
                queue.add(n.right);
            }
        }
        return root;
    }
    private static Node makeRandomNode(int percentChance ) {
        numNodes--;
        int randomNumber = random.nextInt(100);
        boolean passed = randomNumber > (100 - percentChance);
        boolean shouldCreate = numNodes > 0 && passed;
        return shouldCreate ? new Node(getRandomLetterString()) : null;
    }
    // https://gist.github.com/bittib/5620951
    public ArrayList<String> serialize(){
        ArrayList<String> list = new ArrayList<String>();
        serialize(list, this);
        return list;
    }
    static private void serialize(ArrayList<String> list, Node root) {
        if (root == null) {
            list.add(null);
        } else {
            list.add(root.data);
            serialize(list,root.left);
            serialize(list,root.right);
        }
    }
    static public Node deserialize(ArrayList<String> list) {
        if ( list.isEmpty() ) return null;
        String token = list.remove(0);
        if ( token == null ) return null;
        Node node = new Node(token);
        node.left = deserialize(list);
        node.right = deserialize(list);
        return node;
    }
}
