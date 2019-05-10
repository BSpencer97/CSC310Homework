/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5prob2;

import java.util.*;

class Node {
    int value;
    Node left;
    Node right;

    Node (int n) {
        this.value = n;
        right = null;
        left = null;
    }

}

// A Java program to introduce Binary Tree 
class BinaryTree {
    Node root;

    // Constructors 
    BinaryTree(int n) {
        root = new Node(n);
    }

    BinaryTree() {
        root = null;
    }

}

public class Hw5Prob2 {
    
    List<Integer> a = new ArrayList<>();

    public static List<Integer> inorder(Node root, List<Integer> a) {
        if (root == null) {
            return null;
        } else {
            inorder(root.left, a);
            a.add(root.value);
            inorder(root.right, a);
        }
        return a;
    }

    public static List<Integer> preorder(Node root, List<Integer> a) {
        if (root == null) {
            return null;
        } else {
            a.add(root.value);
            preorder(root.left, a);
            preorder(root.right, a);
        }
        return a;
    }
    
    public static void main(String[] args) {
        List<Integer> i = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.right = new Node(2);
        tree.root.right.left = new Node(3);

        System.out.println("Inorder: ");
        i = inorder(tree.root, i);
        i.forEach((n) -> System.out.print(n+" "));
        System.out.println();

        System.out.println("Preorder: ");
        r = preorder(tree.root, r);
        r.forEach((n) -> System.out.print(n+" "));
        System.out.println();

    }

}
