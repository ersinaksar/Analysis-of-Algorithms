/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbook
 */
public class HW2_LinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        //head = head.next;
        //head.next = head.next.next;
        //head.next.next.next.next = head;
        
        //Node1 = Node(5) // Create a node and put 5 in it
        //Node1.next = head // Make Node 2 the next element for Node 1
        //Head always point to the 1st element
        //Head = Node1
        
        
        llist.append(10);
        llist.append(9);
        llist.append(8);
        llist.append(7);
        llist.append(6);
        llist.append(5);
        llist.append(4);
        llist.append(3);
        llist.append(2);
        llist.append(1);
        llist.append(0);
        
        System.out.println("My linkedlist data");
        llist.print();
        System.out.println("-------");
        System.out.println("My deleted linkedlist data (2 element deleted 0 and 7 )");
        llist.deleteNodePosition(1);
        llist.deleteNodePosition(10); //ı use parameters like lists index !! so 0 is 1 st node of the ll
        llist.print();
        System.out.println("-------");
        System.out.println("My linkedlist length data");
        int nodelen;
        nodelen = llist.length();
        System.out.println(nodelen);
        System.out.println("-------");
        System.out.println("My linkedlist integer occurs data (for element 2)");
        int intoccurs;
        intoccurs = llist.intOccurs(2);
        System.out.println(intoccurs);
        

    }
}

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
    /*
    public int find(Node head, int x)
    {
        Node current = head;
        int count = 0; //bulunulan nodun kaçıncı node olduğunu söylüyor
        while(current != null)
        {
            count++;
            if(current.data == x)
                return count;
            else
            {
                current = current.next;
            }
        }
        return count;
    }*/
    
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
        
        int count = 1; //first node(head yani) sıralaması
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