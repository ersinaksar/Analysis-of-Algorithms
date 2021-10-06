/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbook
 */
public class FinalExamQ2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue q = new Queue(4); 
        System.out.println("Q2a)");
        q.queueDisplay(); 
        q.queueEnqueue(20); 
        q.queueEnqueue(30); 
        q.queueEnqueue(40); 
        q.queueEnqueue(50);  
        q.queueDisplay();  
        q.queueEnqueue(60); 
        q.queueDisplay(); 
        q.queueDequeue(); 
        q.queueDequeue(); 
        System.out.printf("\n\nafter two node deletion\n\n"); 
        q.queueDisplay(); 
        q.queueFront(); 
        
        System.out.println("Q2b)");
        System.out.println("This implementation is not dynamic because we use arrays and "
                + "arrays size can not be modifiable");
        
        System.out.println("Q2c)");
        System.out.println("The alternative is using linked lists of this implementation.");
    }   
}
class Queue { 
    private static int front, rear, capacity; 
    private static int queue[]; 
  
    Queue(int c) 
    { 
        front = rear = 0; 
        capacity = c; 
        queue = new int[capacity]; 
    } 
    static void queueEnqueue(int data) 
    { 
        if (capacity == rear) { 
            System.out.printf("\nQueue is full\n"); 
            return; 
        } 
        else { 
            queue[rear] = data; 
            rear++; 
        } 
        return; 
    } 
    static void queueDequeue() 
    { 
        if (front == rear) { 
            System.out.printf("\nQueue is empty\n"); 
            return; 
        } 
        else { 
            for (int i = 0; i < rear - 1; i++) { 
                queue[i] = queue[i + 1]; 
            } 
            if (rear < capacity) 
                queue[rear] = 0; 
            rear--; 
        } 
        return; 
    } 
    static void queueDisplay() 
    { 
        int i; 
        if (front == rear) { 
            System.out.printf("\nQueue is Empty\n"); 
            return; 
        } 
        for (i = front; i < rear; i++) { 
            System.out.printf(" %d <-- ", queue[i]); 
        } 
        return; 
    } 
    static void queueFront() 
    { 
        if (front == rear) { 
            System.out.printf("\nQueue is Empty\n"); 
            return; 
        } 
        System.out.printf("\nFront Element is: %d", queue[front]); 
        return; 
    } 
} 
  