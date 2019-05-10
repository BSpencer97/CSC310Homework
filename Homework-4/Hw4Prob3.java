/*
Name: Brian Spencer
Date: Feb. 24, 2019
Purpose: To create a queue using linked lists with methods (enqueue(object),
         dequeue(), first(), len(), is_empty(), search()). 
 */
package hw4prob3;

//node class for queue
class QueueNode {

    int data;
    QueueNode next;

    //constructor for a new queuenode
    public QueueNode(int key) {
        this.data = key;
        this.next = null;
    }
}

//class to create linked list queue using queuenodes
class LLCoolQueue {

    QueueNode front, rear;
    int size;

    public LLCoolQueue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    //method to add an int to to the queue 
    void enqueueKey(int k) {

        //create a queue node to put input in
        QueueNode t = new QueueNode(k);

        //if the queue is empty, then new queuenode is front and rear both 
        if (this.is_Empty()) {
            this.front = this.rear = t;
            this.size++;
            return;
        }

        //add new queuenode at the end of queue and update rear
        this.rear.next = t;
        this.rear = t;
        this.size++;
    }

    //method to add a queuenode to to the queue 
    void enqueue(QueueNode k) {

        //if the queue is empty, then new queuenode is front and rear both  
        if (this.is_Empty()) {
            this.front = this.rear = k;
            this.size++;
            return;
        }

        //add new queuenode at the end of queue and update rear
        this.rear.next = k;
        this.rear = k;
        this.size++;
    }

    //method to remove head node   
    QueueNode dequeue() {
        //if the queue is empty, then return null 
        if (this.is_Empty()) {
            return null;
        }

        //put current front in t and advance queue
        QueueNode t = this.front;
        this.front = this.front.next;

        //if queue would become empty, make rear null too
        if (this.front == null) {
            this.rear = null;
        }
        //decrease size
        this.size--;
        //return dequeued node
        return t;
    }
    
    boolean search(QueueNode q, int key) {
        //setting currvalue to inputted queuenode
        QueueNode currvalue = q;
        //iterating through queue nodes, searching for .data == key
        while (currvalue != null) {
            if (currvalue.data == key) //return true on first match
            {
                return true;
            }
            currvalue = currvalue.next;
        }
        //return false if no matches found
        return false;
    }

    //method to return the front queuenode's data
    int first() {
        return this.front.data;
    }

    //method to return the linkedlist queue's length
    int len() {
        return this.size;
    }

    //method to return true if the linkedlist queue is empty
    boolean is_Empty() {
        return this.front == null;
    }

}

public class Hw4Prob3 {
    
    public static void main(String[] args) {
        QueueNode a = new QueueNode(2);
        QueueNode b = new QueueNode(12);
        QueueNode c = new QueueNode(7);
        QueueNode d = new QueueNode(0);
        QueueNode e = new QueueNode(89);

        LLCoolQueue q = new LLCoolQueue();
        System.out.println(q.is_Empty());
        q.enqueue(a);
        System.out.println(q.len());
        q.dequeue();
        System.out.println(q.dequeue());
        q.enqueue(b);
        QueueNode x = new QueueNode(25);
        q.enqueue(x);
        q.enqueue(c);
        System.out.println(q.len());
        q.enqueue(d);
        q.enqueue(e);
        q.dequeue();
        System.out.println(q.len());
        
        System.out.println(q.search(q.front, 1));

        System.out.println(q.first());
    }

}
