/*
Name: Brian Spencer
Date: Feb. 13, 2019
Purpose: Evaluates arithmetic expression.
 */
package evalexp;

import java.util.Scanner;

public class EvalExp {

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

    public static boolean evalExp(int x, int y, char op) { //comparing left side
        if (op == '≤') //of expression with right side (result) based on the 
            return y <= x; //operant inputted
        else if (op == '≥')
            return y >= x;
        else if (op == '>')
            return y > x;
        else if (op == '<')
            return y < x;
        else
            return y == x;
    }
    
    static public boolean result(String x) { 
        Stack s = new Stack(0);
        Stack c = new Stack(0);
        boolean flag = false;
        int i = 0;
        while (x.charAt(i) != '$') { //run algorithm until '$' is reached
            if (x.charAt(i) - '0' >= 0 && x.charAt(i) - '0' <= 9) {
                s.push(x.charAt(i) - '0'); //push numbers into stack s
            }
            else { //push operators into stack c
                c.push(x.charAt(i));
            }
            if (x.charAt(i) == '*' || x.charAt(i) == '/') { //evaluate higher
                i++; //precedent operator with next number and push onto stack s
                s.push(x.charAt(i) - '0');
                int d = doOp(s.pop(),s.pop(),(char)c.pop());
                s.push(d);
                if (c.top() - '0' < 0) //if operators like '*', '+', '-', and '/'
                    flag = true; //are at top of c stack, set flag to true
            }
            if (flag) { //if flag is true, perform an operation
                int d = doOp(s.pop(),s.pop(),(char)c.pop());
                s.push(d);
                flag = false;
            }
            i++;
        }
        while (!s.isEmpty()) { //evaluate rest of numbers in stack s
            if (c.top() != '+' && c.top() != '-') { //once operant is left,
                int z = s.pop(); //get result and display result
                int y = s.pop();
                return (evalExp(z, y, (char)c.pop()));
            }
            else { //otherwise, perform operations
                int d = doOp(s.pop(), s.pop(), (char)c.pop());
                s.push(d);
            }
        }
        return false;
    } 
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String x = "";
        System.out.println("Input an arithmetic expression: ");
        x = in.nextLine();
        System.out.println(result(x));
        
    } //end of main
    
}
