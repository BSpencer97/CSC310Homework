/*
Name: Brian Spencer
Date: Feb. 24, 2019
Purpose: To create a circular double-ended queue.
 */
package hw4prob1;

public class Hw4Prob1 {

    static class MyCircularDeque {
            
        int[] a;
        int frontindex;
        int rearindex;
        int size;
        
         //constructor for array-based circular queue at inputted size
        MyCircularDeque(int qsize) {
            a = new int[qsize];
            this.frontindex = 0;
            this.rearindex = qsize - 1;
            this.size = qsize;
        }
        
        //method that returns true if front insertion is successful
        boolean insertFront(int x) {
            //won't insert if queue is full
            if (this.isFull()) {
                return false;
            }
            else {
                //indexes input with post increment
                a[this.frontindex++] = x;
            }
            return true;
        }
        
        //method that returns true if rear insertion is successful
        boolean insertLast(int x) {
            //won't insert if queue is full
            if (this.isFull()) {
                return false;
            }
            else {
                //indexes input with post decrement
                a[this.rearindex--] = x;
            }
            return true;
        }
        
        //method that returns true if front deletion is successful
        boolean deleteFront() {
            //won't delete if queue is empty
            if (this.isEmpty()) {
                return false;
            }
            else {
                //resets index with post increment
                a[this.frontindex++] = 0;
            }
            return true;
        }
        
        //method that returns true if rear deletion is successful
        boolean deleteLast() {
            //won't delete if queue is empty
            if (this.isEmpty()) {
                return false;
            }
            else {
                //resets index with post decrement
                a[this.rearindex+1] = 0;
                this.rearindex--;
            }
            return true;
        }
           
        //method to get front element in queue
        int getFront() {
            //returns -1 if queue is empty
            if (this.isEmpty()) {
                return -1;
            }
            else {
                //modifying frontindex to always be relative to size and wrappable
                this.frontindex = this.frontindex%this.size;
                return a[this.frontindex-1];
            }
        }
        
        //method to get rear element in queue
        int getRear() {
            //returns -1 if queue is empty
            if (this.isEmpty()) {
                return -1;
            }
            else {
                //modifying rearindex to always be relative to size and wrappable
                this.rearindex = Math.abs((this.rearindex + this.size)%this.size);
                return a[this.rearindex+1];
            }
        }
            
        //returns true if queue is empty
        boolean isEmpty() {
            return this.frontindex == 0 && this.rearindex == this.size - 1;
        }
        
        //returns true if queue is full
        boolean isFull() {
            return this.frontindex == this.rearindex + 1;
        }
        
        //method to print out contents of queue
        void print() {
            for (int i = 0; i < this.size; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
        }
        
    } //end of class

    public static void main(String[] args) {
        
        MyCircularDeque c = new MyCircularDeque(6);
        System.out.println(c.isEmpty());
        System.out.println(c.insertLast(1));
        System.out.println("rear: "+c.getRear());
        c.print();
        System.out.println(c.insertLast(2));
        c.print();
        System.out.println(c.insertFront(3));
        c.print();
        System.out.println(c.insertFront(4));
        c.print();
        System.out.println("rear: "+c.getRear());
        System.out.println(c.isFull());
        System.out.println(c.deleteLast());
        c.print();
        System.out.println(c.insertFront(4));
        c.print();
        System.out.println("front: "+c.getFront());
        
        System.out.println("______________________");

        MyCircularDeque q = new MyCircularDeque(3);
        System.out.println(q.isEmpty());
        System.out.println(q.insertLast(6));
        System.out.println(q.isFull());
        q.print();
        System.out.println(q.insertFront(1));
        q.print();
        System.out.println(q.isFull());
        System.out.println(q.insertFront(4));
        q.print();
        System.out.println("front: "+q.getFront());
        System.out.println("rear: "+q.getRear());
        System.out.println(q.isFull());
        System.out.println(q.deleteLast());
        System.out.println(q.isEmpty());
        
    } //end of main
}
