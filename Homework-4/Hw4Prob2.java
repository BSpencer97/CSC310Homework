/*
Name: Brian Spencer
Date: Feb. 24, 2019
Purpose: Program that will merge two sorted singly-linked lists and return it as
         as a new list.
 */
package hw4prob2;

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
        //iterating through nodes, searching for .data == key
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
    
    //method to print data at each queue node
    void printList(QueueNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

}

public class Hw4Prob2 {

    // Merges two sorted lists (they must be sorted or it will not work)
    static QueueNode splice(QueueNode q1, QueueNode q2) {
        //merge single node q1 to q2 if it's single
        if (q1.next == null) {
            q1.next = q2;
            return q1;
        }

        //swap queuenodes set up with current and next nodes of each list
        QueueNode currnode1 = q1;
        QueueNode nextnode1 = q1.next;
        
        QueueNode currnode2 = q2;
        QueueNode nextnode2 = q2.next;

        while (currnode1 != null && currnode2 != null) {
            //if current queue node of list 2 lies in between current queue node
            //of list 1 and next node of list 1, there will be a swap to push
            //queue nodes into longer list (list1)
            if ((currnode2.data >= currnode1.data) && (currnode2.data <= nextnode2.data)) {
                nextnode2 = currnode2.next;
                currnode1.next = currnode2;
                currnode2.next = nextnode2;
                //set queue nodes to point to next queuenode
                currnode1 = currnode2;
                currnode2 = nextnode2;
            } else {
                //if list 2 runs out before list 1 does, the next queue node of
                //list gets copied and current queue node of list 1 gets copied
                //so they can swap as if list 2 didn't run out of queue nodes
                if (nextnode2.next != null) {
                    nextnode2 = nextnode2.next;
                    currnode1 = currnode1.next;
                } 
                //otherwise, next queue node of list 2 will point to current
                //queue node of list 2 and return list 1
                else {
                    nextnode2.next = currnode2;
                    return q1;
                }
            }
        }
        return q1;
    }

    //method to splice two lists together
    static QueueNode merge(QueueNode q1, QueueNode q2) {
        //if first list is empty, return second list
        if (q1 == null) {
            return q2;
        }
        //if second list is empty, return first list
        if (q2 == null) {
            return q1;
        }

        //splice smaller list with larger list
        if (q1.data < q2.data) {
            return splice(q1, q2);
        } else {
            return splice(q2, q1);
        }
    }

    public static void main(String[] args) {
        LLCoolQueue q1 = new LLCoolQueue();
        LLCoolQueue q2 = new LLCoolQueue();

        q1.enqueueKey(1);
        q1.enqueueKey(1);
        q1.enqueueKey(7);

        q2.enqueueKey(0);
        q2.enqueueKey(3);
        q2.enqueueKey(4);
        q2.enqueueKey(5);

        QueueNode xd = merge(q1.front, q2.front);
        LLCoolQueue q3 = new LLCoolQueue();
        q3.enqueue(xd);
        q3.printList(q3.front);
    }

}
