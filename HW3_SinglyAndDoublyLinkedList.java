/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbook
 */
public class HW3_SinglyAndDoublyLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        DoublyLinkedList dllist = new DoublyLinkedList(); //oluşturduğumuz classdan yeni bir nesne ürettik
        llist.addFirst(0);
        llist.append(1);
        llist.append(3);
        llist.append(3);
        llist.append(4);
        llist.append(5);
        llist.append(6);
        llist.append(7);
        
        dllist.append(2);
        dllist.append(3);
        dllist.append(4);
        System.out.println("-------");
        System.out.println("My linkedlist data");
        llist.print();
        System.out.println("-------");
        System.out.println("HW3 Q2:");
        System.out.println("My linkedlist data");
        int listStartNode = 3;
        llist.printListFrom(0,listStartNode);//This function must take 0,and the node data 
        llist.print();
        System.out.println("-------");
        System.out.println("My Doublylinkedlist data");
        dllist.print();
        dllist.addBefore(dllist.head.next, 5);
        System.out.println("-------");
        System.out.println("HW3 Q3.1(addBefore):");
        System.out.println("My Doublylinkedlist data");
        dllist.print();
        System.out.println("-------");
        System.out.println("HW3 Q3.2(deleteDivisible):");
        System.out.println("My Doublylinkedlist data");
        dllist.deleteDivisible(dllist.head, 2);
        dllist.printlist(dllist.head);
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
    
   
    public boolean printListFrom(int count,int position){
        Node temp = head, prev = head;
        Node current = head;
        if(current == null){
            System.out.println("Aranan data bulunamadı");
            return false;}
        //if kes is presentin current node,return true
        if(current.data==position){
            prev.next = temp.next;
            System.out.println("Print List Nod position is: "+ current.data );
            return true;}
        //Recur for remaining list
        prev = temp;
        temp = temp.next;
        head = current.next;
        count++;
        return printListFrom(count,position);
    }
    //bu fonksiyon olmadı ya buna bak
    public boolean deleteNodePositionRecursive(int count,int position)
    {   
        Node temp = head, prev = head;
        Node current = head;
        if(current == null){
            System.out.println("Aranan data bulunamadı");
            return false;}
        //if kes is presentin current node,return true
        if(count==position){
            prev.next = temp.next;
            System.out.println("Deleted Nod position is: "+ current.data );
            return true;}
        //Recur for remaining list
        prev = temp;
        temp = temp.next;
        head = current.next;
        count++;
        return deleteNodePositionRecursive(count,position);
        
    }
    
    /* Checks whether the value x is present in linked list */
    //bu kısımdan emin değilim denemedim
    public boolean searchRecursive(int x){
        Node current = head;
        if(current == null){
            System.out.println("Aranan data bulunamadı");
            return false;}
        //if kes is presentin current node,return true
        if(current.data==x){
            System.out.println("Aranan data bulundu: "+ current.data );
            return true;}
        //Recur for remaining list
        head = current.next;
        return searchRecursive(x);
    }
    
    //Checks whether the value x is present in linked list
    //Linked List iterative solution
    public boolean searchIterative(Node head, int x)
    {
        Node current = head;//Initialize current
        while (current != null)
        {
            if (current.data == x)
                return true;//data found
            current = current.next;
        }
        return false;//data not found
    }
    
    
    /* This function is in LinkedList class. Inserts a new Node at front of the list.
    This method is
    defined inside LinkedList class shown before */
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
    
    /* This function is in LinkedList class.
    Inserts a new node after the given prev_node. This method is
    defined inside LinkedList class shown above */
    public void insertAfter(Node prev_node, int new_data)
    {
        /* 1. Check if the given Node is null */
        if (prev_node == null)
        {
            System.out.println("The given previous node cannot be null");
            return; 
        }
        
        /* 2. Allocate the Node &
        3. Put in the data*/
        Node new_node = new Node(new_data);
        
        /* 4. Make next of new Node as next of prev_node */
        new_node.next = prev_node.next;
        
        /* 5. make next of prev_node as new_node */
        prev_node.next = new_node;
        
    }
    
    /* Given a key, deletes the first occurrence of key in
    linked list */
    void deleteNode(int key)
    { 
        // Store head node
        Node temp = head, prev = null;
        
        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key)
        {
            head = temp.next;// Changed head
            return;
        }
        /* Search for the key to be deleted, keep track of
        the previous node as we need to change temp.next */
        while (temp != null && temp.data != key)
        {
            prev = temp;
            temp = temp.next;
        }
        // If key was not present in linked list
        if (temp == null) return;
        // Unlink the node from linked list
        prev.next = temp.next;
    }
    
    //Checks whether the value x is present in linked list
    public boolean search(Node head, int x)
    {
        Node current = head;//Initialize current
        while (current != null)
        {
            if (current.data == x)
                return true;//data found
            current = current.next;
        }
        return false; //data not found
    } 
    int length()
    {
        // Store head node
        Node temp = head, prev = null;
        int count = 0; //first node(head yani) sıralaması
        if (temp == null) return 0;
        /* Search for the key to be deleted, keep track of
        the previous node as we need to change temp.next */
        while (temp != null)
        {
            count++;
            prev = temp;
            temp = temp.next;
        }
        return count;
    }
    void deleteNodePosition(int position)
    { 
        // Store head node
        Node temp = head, prev = null;
        
        int count = 0; //first node(head yani) sıralaması
        // Eğer silinecek nod 1 ise head i sil
        if (temp != null && count == position)
        {
            head = temp.next;// Changed head
            return;
        }
        count++;
        /* Search for the key to be deleted, keep track of
        the previous node as we need to change temp.next */
        while (temp != null && count != position)
        {
            count++;
            prev = temp;
            temp = temp.next;
        }
        // If key was not present in linked list
        if (temp == null) return;
        // Unlink the node from linked list
        prev.next = temp.next;//öncekinin sonunu tempe değil tempi atlayarak tempten sonrakine bağlıyor
    }
    
    int intOccurs(int key)
    {
        // Store head node
        Node temp = head, prev = null;
        int occur = 0;
        /* Tüm linkedlisti dolaş */
        while (temp != null)
        {
            if(temp.data == key ) occur++;//aradığımız eşleşen eleman varsa sayacı bir arttır
            prev = temp;
            temp = temp.next;
        }
        return occur;
    }
    public void print()
    {
        Node current = head;
        
        while(current != null)
        {
            System.out.println(current.data);
            current = current.next;
        }
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
        Node temp = head, prev=null;
        int x;
        if(temp == null) return;
        while(temp != null){
            x = temp.data%K;
            if(x == 0){
                // If node to be deleted is head node
                if (head == temp) {
                    head = temp.next;
                }
                // Change next only if node to be deleted
                // is NOT the last node
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }

                // Change prev only if node to be deleted
                // is NOT the first node
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                }
            }
            temp = temp.next;
        }
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