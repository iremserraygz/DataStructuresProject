/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soru2;

import java.util.NoSuchElementException;
import java.util.Scanner;

 public class Problem_2 {

   static StackArray newStack = new StackArray(100);
    static StackArray reverse = new StackArray(100);

    public static void main(String args[]) throws NoSuchElementException {

        Scanner scn = new Scanner(System.in);
        System.out.println("1- Push");
        System.out.println("2- Pop");
        System.out.println("3- Print");
        System.out.println("4- Delete Middle ");
        System.out.println("5- isPalindrome");
        System.out.println("6- Exit");

        System.out.println("Please enter a digit(1-6):");
        int control = scn.nextInt();

        while (control != 6) {

            switch (control) {

                case 1:
                    System.out.println("How many pushes you want to do?");
                    int num_push = scn.nextInt();

                    for (int i = 0; i < num_push; i++) {
                        String push_element = scn.next();
                        newStack.push(push_element);
                    }
                    System.out.println(newStack.toPrint());

                    break;

                case 2:
                    newStack.pop();

                    break;

                case 3:

                    System.out.println(newStack.toPrint());

                    break;

                case 4:
                    deleteMiddle(newStack);

                    break;

                case 5:
                    boolean isPalindrome = isPalindrome();
                    if (isPalindrome) {
                        System.out.println("The stack is palindrome");
                    } else {
                        System.out.println("The stack is not palindrome");
                    }

                    break;

            }
            
            System.out.println("Please enter a digit(1-6):");
            control = scn.nextInt();
            if (control == 6) {
            System.out.println("Exiting...");
            }
        }

    }

    public static void deleteMiddle(StackArray newStack) throws NoSuchElementException {
        StackArray tmp = new StackArray(newStack.data.length + 1);
        int size = newStack.top;

        if ((size + 1) % 2 != 0) {

            for (int i = 0; i < (size / 2); i++) {

                tmp.push(newStack.pop());

            }

            newStack.pop();

            for (int i = 0; i < (size / 2); i++) {
                newStack.push(tmp.pop());
            }

        } else {
            System.out.println("Stack is even,there is no removed element");
        }

    }

    public static boolean isPalindrome() { 
        StackArray tmp = new StackArray(newStack.data.length + 1);
        StackArray tmp1 = new StackArray(newStack.data.length + 1);
        String peek, peek1;
        int size = newStack.top + 1;
        boolean isPalindrome = false;

        if ((size) % 2 != 0) {

            for (int i = 0; i < (size / 2); i++) {
                peek = newStack.pop();
                tmp.push(peek);
                tmp1.push(peek);
            }

            peek = newStack.pop();
            tmp1.push(peek);

            while (!newStack.isEmpty() && !tmp.isEmpty()) {

                peek = newStack.pop();
                if (peek.equals(tmp.pop())) {
                    isPalindrome = true;
                } else {
                    isPalindrome = false;
                }
                tmp1.push(peek);
            }

            while (!tmp1.isEmpty()) {
                peek1 = tmp1.pop();
                newStack.push(peek1);
            }

        } else {

            for (int i = 0; i < (size / 2); i++) {
                peek = newStack.pop();
                tmp.push(peek);
                tmp1.push(peek);
            }

            while (!newStack.isEmpty() && !tmp.isEmpty()) {
                peek = newStack.pop();
                if (peek.equals(tmp.pop())) {
                    isPalindrome = true;
                } else {
                    isPalindrome = false;
                }
                tmp1.push(peek);
            }
            while (!tmp1.isEmpty()) {
                peek1 = tmp1.pop();
                newStack.push(peek1);
            }

        }

        return isPalindrome;
    }
}
