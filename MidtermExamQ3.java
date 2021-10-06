/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbook
 */
public class MidtermExamQ3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DoublyLinkedList dllist = new DoublyLinkedList(); //oluşturduğumuz classdan yeni bir nesne ürettik
        dllist.append(2);
        dllist.append(3);
        dllist.append(4);
        
        System.out.println("-------");
        System.out.println("My Doublylinkedlist data");
        dllist.print();
        System.out.println("HW3 Q3.2(deleteDivisible):");
        System.out.println("My Doublylinkedlist data");
        dllist.deleteDivisible(dllist.head, 99999);
        dllist.printlist(dllist.head);
    }
    
}


class DoublyLinkedList 
{
    Node head;  // head of list
    /* Node Class */
    class Node
    {
        int data;
        Node next;
        Node prev;
        // Constructor to create a new node
        Node(int d) {data = d; next = null; prev=null;}
    }
    public void printlist(Node node)
    {
        Node last = null;
 
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
 
        System.out.println();
    }
    public void deleteDivisible(Node dllist, int K){
        Node temp = head, prev=null;//O(2) because of two operator
        int x;
        if(K==0){//O(1) because of a single operator
            System.out.println("K can not be 0");
            return;} //O(1) because of a single operator
        if(temp == null) {//O(1) because of a single operator
            System.out.println("List is empty");
            return;}//O(1) because of a single operator
        while(temp != null){//O(N) because we check all elements
            x = temp.data%K;//O(2) because of two operator
            if(x == 0){//O(1) because of a single operator
                // If node to be deleted is head node
                if (head == temp) {//O(1) because of a single operator
                    head = temp.next;//O(1) because of a single operator
                }
                // Change next only if node to be deleted
                // is NOT the last node
                if (temp.next != null) {//O(1) because of a single operator
                    temp.next.prev = temp.prev;//O(1) because of a single operator
                }

                // Change prev only if node to be deleted
                // is NOT the first node
                if (temp.prev != null) {//O(1) because of a single operator
                    temp.prev.next = temp.next;//O(1) because of a single operator
                }
            }
            temp = temp.next;//O(1) because of a single operator
        }
        /*
        Midterm Exam Q3b
        All of the function time complexity is: O(1)+O(N) => O(N)
        */
    }
    /* Given a node as next_node, add a new node before the given node */
    public void addBefore(Node next_Node, int new_data){
        /*1. check if the given prev_node is NULL */
        if (next_Node == null) {
            System.out.println("The given next node cannot be NULL ");
            return;
        }
        /* 2. allocate node
        * 3. put in the data 
        yeni bir node oluşturup yeni datayı içine yazıyoruz*/
        Node new_node = new Node(new_data);
        /* 4. Make prev of new node as prev of prev_node */
        new_node.prev = next_Node.prev;
        /* 5. Make the prev of next_node as new_node */
        next_Node.prev = new_node;
        /* 6. Make next_node as next of new_node */
        new_node.next = next_Node;
        /* 7. Change next of new_node's previous node */
        if (new_node.prev != null){
        new_node.prev.next = new_node;}
        else{
            if(new_node.prev == null){
                head=new_node;
            }
        }
    }
    /* Given a node as prev_node, insert a new node after the given node */
    public void InsertAfter(Node prev_Node, int new_data){
        /*1. check if the given prev_node is NULL */
        if (prev_Node == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }
        /* 2. allocate node
        * 3. put in the data */
        Node new_node = new Node(new_data);
        /* 4. Make next of new node as next of prev_node */
        new_node.next = prev_Node.next;
        /* 5. Make the next of prev_node as new_node */
        prev_Node.next = new_node;
        /* 6. Make prev_node as previous of new_node */
        new_node.prev = prev_Node;
        /* 7. Change previous of new_node's next node */
        if (new_node.next != null)
        new_node.next.prev = new_node;
    }
    // Add a node at the end of the list
    void append(int new_data){
        /* 1. allocate node
        * 2. put in the data */
        Node new_node = new Node(new_data);
        Node last = head; /* used in step 5*/
        /* 3. This new node is going to be the last node, so
        * make next of it as NULL*/
        new_node.next = null;
        /* 4. If the Linked List is empty, then make the new
        * node as head */
        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }
        /* 5. Else traverse till the last node */
        while (last.next != null)
            last = last.next;
        
        /* 6. Change the next of last node */
        last.next = new_node;
        
        /* 7. Make last node as previous of new node */
        new_node.prev = last;
    }
    void deleteNode(Node head_ref, Node del){
        // Base case
        if (head == null || del == null) {
            return;
        }
        // If node to be deleted is head node
        if (head == del) {
            head = del.next;
        }
        
        // Change next only if node to be deleted
        // is NOT the last node
        if (del.next != null) {
            del.next.prev = del.prev;
        }
        
        // Change prev only if node to be deleted
        // is NOT the first node
        if (del.prev != null) {
            del.prev.next = del.next;
        }
        
        // Finally, free the memory occupied by del
        return;
    }
    // Prints all of the list from start to end
    public void print()
    {
        Node current = head;
        
        while(current != null)
        {
            System.out.println(current.data);
            current = current.next;
        }
    }
    // Adding a node at the front of the list
    public void push(int new_data){
        /* 1. allocate node
        * 2. put in the data */
        Node new_Node = new Node(new_data);
        /* 3. Make next of new node as head and previous as NULL */
        new_Node.next = head;
        new_Node.prev = null;
        /* 4. change prev of head node to new node */
        if (head != null)
        head.prev = new_Node;
        /* 5. move the head to point to the new node */
  
    }
}