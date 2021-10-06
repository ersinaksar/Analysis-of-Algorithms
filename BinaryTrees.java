
//import java.util.*;
//import java.lang.*;
//import java.io.*;
public class BinaryTrees {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Array_imp obj = new Array_imp();
        //obj.Root("A");
        // obj.set_Left("B", 0);
        /*
        obj.set_Right("C", 0);
        obj.set_Left("D", 1);
        obj.set_Right("E", 1);
        obj.set_Left("F", 2);
        obj.print_Tree();
        */
        
        /*
        obj.set_Left("B", 0);
        obj.set_Left("c", 1);
        obj.print_Tree();*/
        
        //Node_imp tree = new Node_imp(1);
        //System.out.println(tree.root.key);
        Node_imp tree = new Node_imp();
        //create root
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        System.out.println(tree.root.left.key);
        
        
    }
    
}
/* Class containing left and right child of current
   node and key value*/
class Node
{
    int key;
    Node left, right;
 
    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}
class Node_imp{
    // Root of Binary Tree
    Node root;
 
    // Constructors
    Node_imp(int key)
    {
        root = new Node(key);
    }
 
    Node_imp()
    {
        root = null;
    }
}


//----------
class Array_imp {
    static int root = 0;
    static String[] str = new String[10];
 
    /*create root*/
    public void Root(String key)
    {
        str[0] = key;
    }
 
    /*create left son of root*/
    public void set_Left(String key, int root)
    {
        int t = (root * 2) + 1;
 
        if (str[root] == null) {
            System.out.printf("Can't set child at %d, no parent found\n", t);
        }
        else {
            str[t] = key;
        }
    }
 
    /*create right son of root*/
    public void set_Right(String key, int root)
    {
        int t = (root * 2) + 2;
 
        if (str[root] == null) {
            System.out.printf("Can't set child at %d, no parent found\n", t);
        }
        else {
            str[t] = key;
        }
    }
 
    public void print_Tree()
    {
        for (int i = 0; i < 10; i++) {
            if (str[i] != null)
                //System.out.print(str[i]);
                System.out.println(i + " => " + str[i]);
            else
                System.out.println("-");
        }
    }
}