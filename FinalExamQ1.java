/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbook
 */
public class FinalExamQ1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        
        llist.addFirst(1);
        llist.append(2);
        llist.append(3);
        llist.append(4);
        llist.append(5);
        llist.append(6);
        llist.append(7);
        System.out.println("-------");
        System.out.println("Final Exam Q1a:");
        System.out.println("My linkedlist data");
        llist.print();
        System.out.println("-------");
        
        System.out.println("My linkedlist data");
        int kthnode = 4;
        System.out.println("kthnode is : "+ kthnode);
        //llist.deleteMax();
        //llist.deleteNode(1);
        llist.head = llist.deleteNodeRec(llist.head, kthnode);
        llist.print();
        
        
        
        DoublyLinkedList dllist = new DoublyLinkedList(); //oluşturduğumuz classdan yeni bir nesne ürettik
        dllist.append(1);
        dllist.append(2);
        dllist.append(3);
        dllist.append(4);
        dllist.append(4);
        dllist.append(4);
        dllist.append(6);
        
        
        System.out.println("-------");
        System.out.println("Final Exam Q1b:");
        //System.out.println("-------");
        System.out.println("My Doublylinkedlist data");
        dllist.print();
        //System.out.println("My Doublylinkedlist data");
        //dllist.deleteDivisible(dllist.head, 99999);
        int controlnumber = 3;
        int[] results = dllist.intNumberOccurs(controlnumber);
        System.out.println(controlnumber +" Occurs :" +results[0]+ " times");
        System.out.println("The total number of nodes of the DLL :" +results[1]);
        //dllist.print();
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
    
    public int[] intNumberOccurs(int number){
        Node current = head;
        int intOccur = 0;
        int totalNumber = 0;
        int[] results = new int[2];
        while (current != null){
            totalNumber++;
            if(current.data == number){
                intOccur++;
            }
            current = current.next;
        }
        results[0]= intOccur;
        results[1] = totalNumber;
        return results;
       
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
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
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


//deleteNode => Verilen dataya ait Nodu siliyor
//deleteNodePosition => Verilen sıralamada olan Nodu siliyor. Yani 2. 3. gibi. saymaya 0 indexiyle başlıyor.
//printListFrom => Belli bir sıradan sonraki nodu yazdırıyor
class LinkedList 
{
    Node head;  // head of list
    /* Node Class */
    class Node
    {
        int data;
        Node next;
        // Constructor to create a new node
        Node(int d) {data = d; next = null; }
    }
    
    public Node deleteNodeRec(Node head, int position) {
         if (head == null)
             return null;
         if (position == 1)
         {
             Node res = head.next;
             return res; 
         }
        head.next = deleteNodeRec(head.next, position-1);
        return head;
    }

    public void addFirst(int new_data)
    {
        /* 1 & 2: Allocate the Node & Put in the data*/
        Node new_node = new Node(new_data);
        /* 3. Make head as the next of the new node */
        new_node.next = head;
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
    
    public void append(int new_data)
    {
        /* 1. Allocate the Node &
         2. Put in the data
         3. Set next as null */
        Node new_node = new Node(new_data);
        /* 4. If the Linked List is empty, then make the
        new node as head */
        if (head == null)
        {
            head = new Node(new_data);
            return; 
        }
        /* 4. This new node is going to be the last node, so
        make next of it as null */
        new_node.next = null;
        /* 5. Else traverse till the last node */
        Node last = head;
        while (last.next != null)
        last = last.next;
        /* 6. Change the next of last node */
        last.next = new_node;
        return;
    }

    public void print()
    {
        Node current = head;
        
        while(current != null)
        {
            System.out.print(current.data +" ");
            current = current.next;
        }
        System.out.println();
    }
 
}