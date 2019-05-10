/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5prob1;

/**
 *
 * @author Brian
 */
public class Hw5Prob1 {

    static void Hanoi(int n, String a, String b, String c) {
        if (n > 0) {
            Hanoi(n-1, a, c, b);
            System.out.println("Move disk " + n + " from peg " + a + " to peg " + c);
            Hanoi(n-1, b, a, c);
        }
    }
    
    public static void main(String[] args) {
        Hanoi(2, "A", "B", "C");
    }
}