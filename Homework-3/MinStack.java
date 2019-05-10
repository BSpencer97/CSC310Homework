/*
Name: Brian Spencer
Date: Feb. 13, 2019
Purpose: To create a Stack class that supports push, pop, top, and
         retrieving the minimum element, all in constant time. 
 */
package minstack;

public class MinStack {

    int[] a;
    int maxsize; //initializing a Min object whose purpose is to be a stack-like
    int currsize; //object containing any possible mins for this stack
    Min min = new Min(this.maxsize); 
                                      
    public MinStack(int maxsize) { //construct stack of inputted size
        if (maxsize < 1) //since we're keeping track of the min element,
            this.maxsize = 1; //we have to start the maxsize at 1 or greater
        else
            this.maxsize = maxsize;
        this.currsize = 0; //currsize is 0
        a = new int[this.maxsize]; //create array with length maxsize
    }

    public void push(int x) {
        if (this.isEmpty()) { //push element onto the stack and min
            a[this.currsize++] = x;
            min.push(x);
        } else if (this.currsize < this.maxsize) { //if stack isn't full, then
            a[this.currsize++] = x; //push element onto stack and if element is
            if (x <= min.top()) { //less than the current min, push that onto
                min.push(x); //the min 
            }
        } else { //otherwise, we resize the stack and then perform the same
            resize(); //stack push and min comparison
            if (x <= min.top()) {
                min.push(x);
            }
            a[this.currsize++] = x;
        }
    }
    
    void resize() {
        this.maxsize = this.maxsize*2 + 1; //2*maxsize + 1 in case of size 0
        int[] b = new int[this.maxsize]; //new array with new maxsize
        for (int i = 0; i < this.maxsize / 2; i++) { //put old elements in 
            b[i] = a[i];                             //new array
        }
        a = b; //a becomes b
    }

    int top() { //return last index (top) element in array
        return a[this.currsize - 1];
    }

    int pop() {
        if (!this.isEmpty()) { //if stack isn't empty, will remove last
            int pop = a[this.currsize - 1]; //index (top) element and 
            a[this.currsize - 1] = 0; //decrement currsize, then return
            this.currsize--; //popped value
            if (pop == min.top()) { //if popped value was equal to min,
                min.pop(); //pop the min, too
            }
            return pop;
        } else { //otherwise, print out that the min is empty
            System.out.print("Size = ");
        }
        return 0;
    }

    boolean isEmpty() { //return bool of currsize == 0
        return (this.currsize == 0);
    }

    int getMin() {
        if (!min.isEmpty()) { //if our min object isn't empty, print the top
            return(min.top()); //element from min
        } else { //otherwise, print out that the min is empty
            System.out.println("Size = ");
        }
        return 0;
    }
    
    int len() { //will return currsize, the number of elements in stack
        return this.currsize; //or, length of stack
    }

    void print() { //print contents of stack -- only for visualization
        for (int i = 0; i < this.currsize; i++) {
            if (this.currsize != 1) {
                if (i == 0) {
                    System.out.print("[" + a[i] + ", ");
                } else if (i < this.currsize - 1) {
                    System.out.print(a[i] + ", ");
                } else {
                    System.out.println(a[i] + "]");
                }
            } else {
                System.out.println("[" + a[i] + "]");
            }
        }
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack(0);
        
        minStack.push(1);
        minStack.push(3);
        minStack.push(-1);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-2);
        minStack.push(-4);
        minStack.print();
        System.out.print("Min: ");
        minStack.getMin();
        System.out.println("Popped: " + minStack.pop());
        minStack.print();
        System.out.print("Top: ");
        System.out.println(minStack.top());
        System.out.print("Min: ");
        minStack.getMin();

        System.out.println("Popped: " + minStack.pop());
        minStack.print();
        System.out.print("Min: ");
        minStack.getMin();
        System.out.println("Popped: " + minStack.pop());
        minStack.print();
        System.out.print("Min: ");
        minStack.getMin();

        System.out.println("Popped: " + minStack.pop());
        minStack.print();
        System.out.print("Min: ");
        minStack.getMin();

        System.out.println("Popped: " + minStack.pop());
        minStack.print();
        System.out.print("Min: ");
        minStack.getMin();

        System.out.println("Popped: " + minStack.pop());
        minStack.print();
        System.out.print("Min: ");
        minStack.getMin();

        System.out.println("Popped: " + minStack.pop());
        minStack.print();
        System.out.print("Min: ");
        minStack.getMin();

    }

    class Min {

        int[] a;
        int maxsize;
        int currsize;

        public Min(int maxsize) { //construct min of inputted size
            this.maxsize = maxsize;
            this.currsize = 0;
            a = new int[maxsize];
        }

        public void push(int x) { //push element onto min and resize if min is full
            if (this.currsize == this.maxsize) {
                resize();
                a[this.currsize++] = x;
            } else {
                a[this.currsize++] = x;
            }
        }
        
        int pop() {
            int pop = a[this.currsize - 1];
            this.currsize--;
            return pop;
        }

        void resize() {
            this.maxsize = this.maxsize*2 + 1; //2*maxsize + 1 in case of size 0
            int[] b = new int[this.maxsize]; //new array with new maxsize
            for (int i = 0; i < this.maxsize / 2; i++) { //put old elements in 
                b[i] = a[i];                             //new array
            }
            a = b; //a becomes b
        }

        int top() { //return last index (top) element in array
            return a[this.currsize - 1];
        }

        boolean isEmpty() {
            return (this.currsize == 0);
        }
    }
}