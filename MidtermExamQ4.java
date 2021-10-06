/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbook
 */
public class MidtermExamQ4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-------");
        System.out.println("Midterm Exam Q4");
        QueueLinkedList queue = new QueueLinkedList();
        
        queue.push(10);
        queue.push(9);
        queue.push(8);
        queue.push(7);
        queue.push(6);
        queue.push(5);
        System.out.println("My Queue is");
        queue.printlist(queue.head);
        Reverse_k_elements_queue(queue,4);
        queue.printlist(queue.head);
        System.out.println("-------");
        
    }
    
    public static void Reverse_k_elements_queue(QueueLinkedList que ,int k){
         StackLinkedlist s1 = new StackLinkedlist();//O(1) because of a single operator
         QueueLinkedList q1 = new QueueLinkedList();//O(1) because of a single operator
         int elements = k;//O(1) because of a single operator
         int quelength = que.length();//O(1) because of a single operator
         int non_k_element = quelength -elements;//O(2) because of two operators
         if(que.length()>=k){//O(1) because of a single operator
             //1rst while
             while(k!=0){//while run for k time so O(k)
                 s1.push(que.pop());//time complexity of push() => O(N) because we find the end of the list and 
                 //tie complexity of pop() sunction is O(1) because we know head of the list
                 k--;//O(1) because of a single operator
             }
             //2rst while
             while(que.length()>0){//O(N) because while runs numbers of elemnts
                 q1.push(que.pop());//time complexity of push() => O(N) because we find the end of the list and 
                 //time complexity of pop() sunction is O(1) because we know head of the list
                 
             }
             //3rst while
             while(elements!=0){//while run for (element==k)k time so O(k)
                 que.push(s1.pop());//time complexity of push() => O(N) because we find the end of the list and 
                 //time complexity of pop() sunction is O(1) because we know head of the list
                 elements--;//O(1) because of a single operator
             }
             //4rst while
             while(non_k_element!= 0){//while run for quelength -elements times so we can say O(que.length-k)
                 que.push(q1.pop());//time complexity of push() => O(N) because we find the end of the list and 
                 //time complexity of pop() sunction is O(1) because we know head of the list
                 non_k_element--;//O(1) because of a single operator
             }
             
         }
         /*
         Midterm Exam Q3b
         //1rst while:O(k)*O(N) => O(k*N)
         //2rst while:O(N)*O(N) => O(N**2)
         //3rst while:O(k)*O(N) => O(k*N)
         //4rst while:O(que.lenght-k)*O(N) => O(N*que.length - k*N)
         All of the function time complexity is:
         k*N + N**2 + k*N + N*que.length - k*N => N**2 + k*N +  N*que.length
         
        */
    }
    
}class QueueLinkedList {
    //int len; // Kuyruğun boyutu
    int fore; // Dizinin öndeki imleci
    int back; // Dizinin arka imleci
    Node head;//int dizi[]; // Elemanların eklendiği dizi
     
    public QueueLinkedList(){
        //this.len = N;
        //this.dizi = new int[this.len];
        this.fore = -1;
        this.back = 0;
         
    }
    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
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
    public void push(int new_data){ // Kuyruğa ekleme
        Node new_node = new Node(new_data);//O(1) because of a single operator
        if (head == null)//O(1) because of a single operator
        {
            head = new Node(new_data);//O(1) because of a single operator
            return; //O(1) because of a single operator
        }
        new_node.next = null;//O(1) because of a single operator
        Node last = head;//O(1) because of a single operator
        //kuyruğun sonunu bulana kadar ilerliyor bulunca çıkıyor
        while (last.next != null)//O(N) because we check all elemnts of list
            last = last.next;//O(1) because of a single operator
        //bulunan kuyruk sonuna yeni nodu ekliyor
        last.next = new_node;//O(1) because of a single operator
        return;//O(1) because of a single operator
    }
     
    public int pop(){ // Kuyruktan çıkarma
        //kuyruk boş değilse kuyruğun başından eleman çıkaracağız
        Node temp = head;
        if(!bosmu()){
            //kuyruğun başındaki datayı da gei döndüreceğiz 
            int temp_data = head.data;//int temp = this.dizi[this.back];
            //Kuyruğun başını sildik
            head= temp.next;//this.back = (this.back+1)%this.len;
            //elemanSayisi--;
            return temp_data;
             
        }else{
            System.out.println("Kuyruk boş");
            return -1;
        }
    }
    
     
    public boolean bosmu(){
        if(head==null){
            return true;
        }else{
            return false;
        }
    }
     
    public int dolumu(){
        return ((head)!= null)?1:0;
    }
}class StackLinkedlist { 
    // A linked list node 
    class Node { 
        int data; // integer data 
        Node next; // reference variable Node type 
        Node(int d){
            data=d;
            next=null;
        }
    } 
    // create global top reference variable global 
    Node top; 
    // Constructor 
    StackLinkedlist() { 
        this.top = null; 
    }
    public boolean bosmu(){
        if(top==null){
            return true;
        }else{
            return false;
        }
    }
    int length()
    {
        // Store head node
        Node temp = top, prev = null;
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
    // Utility function to add an element x in the stack 
    public void push(int x) // insert at the beginning 
    { 
        // create new node temp and allocate memory 
        Node temp = new Node(x); 
        // check if stack (heap) is full. Then inserting an 
        //  element would lead to stack overflow 
        if (temp == null) { 
            System.out.print("\nHeap Overflow"); 
            return; 
        } 
        // initialize data into temp data field 
        temp.data = x; 
        // put top reference into temp link 
        temp.next = top; 
        // update top reference 
        top = temp; 
    } 
    // Utility function to check if the stack is empty or not 
    public boolean isEmpty() { 
        return top == null; 
    } 
    // Utility function to return top element in a stack 
    public int peek() { 
        // check for empty stack 
        if (!isEmpty()) { 
            return top.data; 
        } 
        else { 
            System.out.println("Stack is empty"); 
            return -1; 
        } 
    } 
    
    // Utility function to pop top element from the stack 
    public int pop() // remove at the beginning 
    { 
        // check for stack underflow 
        if (top == null) { 
            System.out.print("\nStack Underflow"); 
            return -1; 
        }else{
            int temp_data = top.data;
            // update the top pointer to point to the next node 
            top = (top).next;
            return temp_data;
        }
  
        
    } 
    public void display() 
    { 
        // check for stack underflow 
        if (top == null) { 
            System.out.printf("\nStack Underflow"); 
        } 
        else { 
            Node temp = top; 
            while (temp != null) { 
                // print node data 
                System.out.printf("%d->", temp.data); 
                // assign temp link to temp 
                temp = temp.next; 
            } 
        } 
    } 
} 
