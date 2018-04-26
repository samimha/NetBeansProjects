/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binstree;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Sami
 */
public class BinSTree {

    private Node root;
    private int tries = 0;

    public BinSTree() {
        root = null;
    }

    public Node insert_to_tree(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            if (this.root == null) {
                this.root = root;
            }
            return root;
        }

        if (data < root.data) {
            root.left = insert_to_tree(root.left, data);
        } else {
            root.right = insert_to_tree(root.right, data);
        }
        return root;
    }

    public boolean isInTree(Node root, int data) {
        tries++;
        if (root == null) {
            System.out.println("Not in tree, result in " + tries + " tries");
            tries = 0;
            return false;
        } else if (root.data == data) {
            System.out.println("Is in tree, result in " + tries + " tries");
            tries = 0;
            return true;
        } else {
            if (data < root.data) {
                return isInTree(root.left, data);
            } else {
                return isInTree(root.right, data);
            }
        }

    }

    class Node {

        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinSTree tree = new BinSTree();
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 10000; i++) {
            int number = r.nextInt(10000);
            tree.insert_to_tree(tree.root, number);
        }
        while(true){
            tree.isInTree(tree.root, s.nextInt());
        }

    }

}
