/*
Name: Brian Spencer
Date: Feb. 13, 2019
Purpose: To evaluate an expression in postfix notation.
 */
package postfix;

import java.util.Scanner;

public class PostFix {

    static class Stack {
        
        int maxsize;
        int currsize;
        int[] a;

        public Stack(int maxsize) { //construct stack of inputted size
            this.maxsize = maxsize;
            this.currsize = 0;  
            a = new int[maxsize];
        }

        public void push(int x) {
            if (this.currsize < this.maxsize) { //if we don't have to resize
                a[this.currsize++] = x;         //we can push new element
            } else {
                resize();                       //resize due to stack(array) 
                a[this.currsize++] = x;         //being full and then push
            }                                   //new element
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
                return pop;
            } else { //else will say size is 0 -- since int return type is req
                System.out.print("Size = ");
            }
            return 0;
        }

        boolean isEmpty() { //return bool of currsize == 0
            return (this.currsize == 0);
        }
        
        int len() { //will return currsize, the number of elements in stack
            return this.currsize; //or, length of stack
        }

    } //end of intStack class
    
    
    public static int doOp(int x, int y, char op) { //will return value based
        if (op == '+')                              //on two popped values and
            return y+x;                             //popped operator
        else if (op == '-')
            return y-x;
        else if (op == '*')
            return y*x;
        else
            return y/x;
    }
    
    public static int evalExp(String x) { //pushing contents of string into
        Stack s = new Stack(0);           //two stacks
        Stack c = new Stack(0);
        
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i)-'0' >= 0 && x.charAt(i)-'0' <= 9) {
                s.push(x.charAt(i)-'0'); //push numbers in one stack
            }
            else  {
                c.push(x.charAt(i)); //push operators in another
            }
            if (s.len() > 1 && c.len() > 0) { //push result of a chunk of expression
                int d = doOp(s.pop(), s.pop(), (char)c.pop()); //two numbers in
                s.push(d); //stack and an operator, then push result onto stack
            }
        }
        return s.top(); //return top of stack with final result
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String x = ""; //prompt user for input
        System.out.println("Input a postfix expression: ");
        x = in.nextLine();
        System.out.println(evalExp(x));
        
    } //end of main

}