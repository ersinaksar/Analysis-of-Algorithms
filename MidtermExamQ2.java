/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbook
 */
public class MidtermExamQ2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        
        llist.addFirst(0);
        llist.append(1);
        llist.append(2);
        llist.append(3);
        llist.append(4);
        llist.append(5);
        llist.append(6);
        llist.append(7);
        System.out.println("-------");
        System.out.println("My linkedlist data");
        llist.print();
        System.out.println("-------");
        System.out.println("Midterm Exam Q2:");
        System.out.println("My linkedlist data");
        llist.deleteMax();
        llist.print();
        
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
    public int deleteMax(){
        //llist
        int max = 0; //O(1) because of a single operator
        boolean maxs = true;//if it is true we have more than one max number in llist //O(1) because of a single operator
        Node current = head;//O(1) because of a single operator
        Node current2 = head;//O(1) because of a single operator
        if (head == null){   //O(1) because of a single operator
            System.out.println("List is empty");
            return -1;//O(1) because of a single operator
        }
        //1th while
        while(current != null){//llist.length => O(N) beacause we check all elements
            if(current.data > max){ //O(1) because of a single operator
                max = current.data;    //O(1) because of a single operator
            }
            current = current.next;//O(1) because of a single operator
            
            /*
            All of the 1th while time complexity is:O(N)
            */
        }
        //2th while
        while(maxs){//how many max number we have in llist so for here tc is number of max numbers (let say nummax) 
            /*All numbers cant be max in our list because if it happen non-appearence max so
            nummax could be maximum N-1 and  Time complexity for auther loop is=>O(N-1)
            */
            while (current2 != null)//llist.length => O(N) beacause we check all elements
            {
                if (current2.data == max)//O(1) because of a single operator
                    deleteNode(max);//For this function => Time Complexity is = O(N)
                current2 = current2.next;//O(1) because of a single operator
            }
            maxs = false;//O(1) because of a single operator
            
            /*
            All of the 2th while time complexity is:O(N-1)*O(N)*O(N)
            => O(N^3 -N^2)
            */
        }
        return max;//O(1) because of a single operator
        /*
        Midterm Exam Q2b
        All of the function time complexity is: O(1)+O(N)+O(N^3 -N^2) => O(N^3)
        */
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
        Node temp = head, prev = null;//O(1) + O(1) because of two operator
        if (temp != null && temp.data == key)//O(1) + O(1) + O(1)because of three operator
        {
            head = temp.next;//O(1) because of a single operator
            return;//O(1) because of a single operator
        }
        /*
        For above analysis in this function 
        Time Complexity is = O(7)
        */
        while (temp != null && temp.data != key)//llist.length O(N) + llist.length O(N) +llist.length O(N)
        {
            prev = temp;//O(1) because of a single operator
            temp = temp.next;//O(1) because of a single operator
        }
        /*
        For above analysis(while loop) in this function 
        Time Complexity is = O(N) +O(N) +O(N) +O(1)+O(1) => O(3N) + O(2) => O(N)
        */
        if (temp == null) {//O(1) because of a single operator
            return;}//O(1) because of a single operator
        /*
        For above (if tsatement) analysis in this function 
        Time Complexity is = O(7)
        */
        prev.next = temp.next;//O(1) because of a single operator
        
        /*
        For above (all function) analysis
        Time Complexity is = O(N)
        */
        
      
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