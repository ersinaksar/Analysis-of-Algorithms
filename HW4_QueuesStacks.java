/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbook
 */
public class HW4_QueuesStacks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //HW4 hw4 = new HW4();
        
        System.out.println("-------");
        System.out.println("HW4 Q2");
        QueueLinkedList queue = new QueueLinkedList();
        queue.push(10);
        queue.push(9);
        queue.push(8);
        queue.push(7);
        queue.push(6);
        queue.push(5);
        Reverse_k_elements_queue(queue,3);
        queue.printlist(queue.head);
        
        
        System.out.println("-------");
        System.out.println("HW4 Q1.c");
        System.out.println("QueueLinkedList.push time complexity is:O(N)");
        System.out.println("QueueArray.push time complexity is:O(1)");
        System.out.println("QueueLinkedList.pop time complexity is:O(1)");
        System.out.println("QueueArray.pop time complexity is:O(1)");
        
        
        
    }
    
    public static void Reverse_k_elements_queue(QueueLinkedList que ,int k){
         StackLinkedlist s1 = new StackLinkedlist();
         QueueLinkedList q1 = new QueueLinkedList();
         int elements = k;
         int quelength = que.length();
         int non_k_element = quelength -elements;
         if(que.length()>=k){
             while(k!=0){
                 s1.push(que.pop());
                 k--;
             }
             while(que.length()>0){
                 q1.push(que.pop());
             }
             while(elements!=0){
                 que.push(s1.pop());
                 elements--;
             }
             while(non_k_element!= 0){
                 que.push(q1.pop());
                 non_k_element--;
             }
             
         }  
    }
    
}


class QueueUsingTwoStacks{
    StackLinkedlist s1 = new StackLinkedlist();
    StackLinkedlist s2 = new StackLinkedlist();
    public void push(int new_data ){
        s1.push(new_data);
    }
    
    public int pop(){
        if(s2.length()==0){
            if(s1.length()==0){
                System.out.printf("\nStack Underflow"); 
                return -1;
            }
            while(s1.length()>0){
                int top = s1.pop();
                s2.push(top);
            }
        }
        return s2.pop();
    }
}
class StackUsingTwoQueues{
    //int top;
    /*public StackUsingTwoQueues(){
        QueueLinkedList q1 = new QueueLinkedList();
        QueueLinkedList q2 = new QueueLinkedList();
        this.top = 0;
    }*/
    QueueLinkedList q1 = new QueueLinkedList();
    QueueLinkedList q2 = new QueueLinkedList();
    public void push(int top){
        if(q1.bosmu()){
            q1.push(top);
        }else{
            int q1Size = q1.length();
            for(int i = 0; i<q1Size; i++){
                q2.push((q1.pop()));
            }
            q1.push(top);
            for(int j = 0; j<q1Size;j++){
                q1.push(q2.pop());
            }
            
        }
    }
    
    public int pop(){
        return q1.pop();
    }
    public void unpack() 
    { 
        // check for stack underflow 
        if (q1.bosmu()) { 
            System.out.printf("\nStack Underflow"); 
        } 
        else { 
             
            while (!q1.bosmu()) { 
                // print node data 
                System.out.printf("%d->", pop()); 
                
            } 
        } 
    }
    
}

class StackLinkedlist { 
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

/* Java program to implement basic stack
operations */
class StackArray {
    static final int MAX = 1000;
    int top;
    int a[] = new int[MAX]; // Maximum size of Stack
    boolean isEmpty(){
        return (top < 0);
    }
    StackArray(){
        top = -1;
    }
 
    boolean push(int x){
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        }
        else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }
 
    int pop(){
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int x = a[top--];
            return x;
        }
    }
 
    int peek(){
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int x = a[top];
            return x;
        }
    }
}

class QueueLinkedList {
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
        Node new_node = new Node(new_data);
        if (head == null)
        {
            head = new Node(new_data);
            return; 
        }
        new_node.next = null;
        Node last = head;
        //kuyruğun sonunu bulana kadar ilerliyor bulunca çıkıyor
        while (last.next != null)
            last = last.next;
        //bulunan kuyruk sonuna yeni nodu ekliyor
        last.next = new_node;
        return;
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
}
class QueueArray {
    int len; // Kuyruğun boyutu
    int fore; // Dizinin öndeki imleci
    int back; // Dizinin arka imleci
    int dizi[]; // Elemanların eklendiği dizi
    int elemanSayisi;
     
    public QueueArray(int N){
        this.len = N;
        this.dizi = new int[this.len];
        this.fore = -1;
        this.back = 0;
         
    }
     
    public void push(int nesne){ // Kuyruğa ekleme
        if(!dolumu()){
            this.fore = (this.fore+1)%this.len;
            this.dizi[this.fore] = nesne;
            elemanSayisi++;
        }
        else{
            System.out.println("Kuyruk dolu");
        }
    }
     
    public int pop(){ // Kuyruktan çıkarma
        if(!bosmu()){
            int temp = this.dizi[this.back];
            this.back = (this.back+1)%this.len;
            elemanSayisi--;
            return temp;
             
        }else{
            System.out.println("Kuyruk boş");
            return -1;
        }
    }
     
    public boolean bosmu(){
        if(elemanSayisi == 0){
            return true;
        }else{
            return false;
        }
    }
     
    public boolean dolumu(){
        if(elemanSayisi == this.len){
            return true;
        }else{
            return false;
        }
    }
}

class HW4{
    public HW4(){
        HW4Part1Prints();
    }
    
    public void HW4Part1Prints(){
        System.out.println("-------");
        System.out.println("HW4 Q1.b");
        QueueArray kuyruk = new QueueArray(3);
        System.out.println("QueueArray is empty ? " + kuyruk.bosmu());
        kuyruk.push(5);
        kuyruk.push(4);
        kuyruk.push(5);
        kuyruk.pop();
        System.out.println("QueueArray is empty ? " + kuyruk.bosmu());
        kuyruk.pop();
        kuyruk.pop();
        System.out.println("QueueArray is empty ? " + kuyruk.bosmu());
        kuyruk.push(8);
        kuyruk.push(8);
        kuyruk.push(8);
        // Bundan sonra eklenecek elemanlar için Kuyruk dolu diyecektir
        kuyruk.push(8);
        
        QueueLinkedList kuyrukll = new QueueLinkedList();
        System.out.println("-------");
        System.out.println("HW4 Q1.a");
        System.out.println("QueueLinkedList is empty "+kuyrukll.bosmu());
        kuyrukll.push(56);
        System.out.println("QueueLinkedList is empty "+kuyrukll.bosmu());
        kuyrukll.pop();
        System.out.println("QueueLinkedList is empty "+kuyrukll.bosmu());
        kuyrukll.push(56);
        kuyrukll.push(56);
        kuyrukll.push(56);
        kuyrukll.push(56);
        System.out.println("QueueLinkedList is empty "+kuyrukll.bosmu());
        
        System.out.println("-------");
        System.out.println("HW4 Q3");
        StackUsingTwoQueues sq = new StackUsingTwoQueues();
        sq.push(23);
        sq.push(24);
        sq.push(25);
        sq.push(26);
        sq.push(27);
        sq.push(28);
        sq.unpack();
        sq.push(23);
        sq.push(24);
        System.out.println();
        System.out.println(sq.pop());


        System.out.println("-------");
        System.out.println("HW4 Q4");
        QueueUsingTwoStacks qs = new QueueUsingTwoStacks();
        qs.push(23);
        qs.push(24);
        qs.push(25);
        qs.push(26);    
        System.out.println();
        System.out.println(qs.pop());
        System.out.println();
        System.out.println(qs.pop());
        System.out.println();
        System.out.println(qs.pop());
        
    }
}



