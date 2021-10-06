/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbook
 */
public class MidtermExamQ5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
