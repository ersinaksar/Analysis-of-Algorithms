/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbook
 */
import java.util.Stack;
import java.util.*;
public class FinalExamQ3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* creating a binary tree and entering 
        the nodes */
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.inorder(); 
        
       
    }
    
}

class Node 
{ 
    int data; 
    Node left, right; 
  
    public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    }

} 
class BinaryTree 
{ 
    Node root; 
    void inorder() 
    { 
        if (root == null) 
            return; 
        Stack<Node> s = new Stack<Node>(); 
        Node curr = root; 
        while (curr != null || s.size() > 0) 
        { 
            while (curr !=  null) 
            { 
                s.push(curr); 
                curr = curr.left; 
            } 
            curr = s.pop(); 
            System.out.print(curr.data + " "); 
            curr = curr.right; 
        } 
    }
 
} 

