/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.sınıf1.proje;

import java.util.Scanner;


/**
 *
 * @author İrem Serra
 */
public class test1 {

    static MyLinkedList poly1 = new MyLinkedList(); // FirstPolynomial
    static MyLinkedList poly2 = new MyLinkedList(); // SecondPolynomial

    public static void main(String[] args) throws NullPointerException {

        Scanner scn = new Scanner(System.in);
        int control;

        System.out.println("Please enter the coefficient and power of the first polynomial. Type 0 at the end:");
        int coef1 = 1; //Coefficients of first polynomial
        int pow1;  //Powers of first polynomial

        while (coef1 != 0) {
            coef1 = scn.nextInt();
            if (coef1 == 0) {
                break;
            }
            pow1 = scn.nextInt();

            poly1.insertSorted(coef1, pow1);
        }

        System.out.println("Please enter the coefficient and power of the second polynomial. Type 0 at the end:");
        int coef2 = 1; //Coefficients of second polynomial
        int pow2; //Powers of second polynomial

        while (coef2 != 0) {
            coef2 = scn.nextInt();
            if (coef2 == 0) {
                break;
            }
            pow2 = scn.nextInt();

            poly2.insertSorted(coef2, pow2);
        }

        System.out.println("The entered polynomials are: ");
        poly1.printList();
        System.out.println("");
        poly2.printList();
        System.out.println("");

        System.out.println("Which task do you want to do?");
        System.out.println("1- Add");
        System.out.println("2- Multiply");
        System.out.println("3- Print");
        System.out.println("4- Delete");
        System.out.println("5- Exit");

        control = scn.nextInt();

        while (control != 5) {

            switch (control) {

                case 1:
                    MyLinkedList added = new MyLinkedList();
                    Node fnp1,
                     fnp2;
                    fnp1 = poly1.first;
                    fnp2 = poly2.first;
                    added = added.add(fnp1, fnp2);
                    added.printList();
                    break;

                case 2:
                    fnp1 = poly1.first;
                    fnp2 = poly2.first;
                    MyLinkedList multiplied = multiply(fnp1, fnp2);
                    multiplied.printList();
                    break;

                case 3:
                    System.out.println("The polynomials are: ");
                    poly1.printList();
                    System.out.println("");
                    poly2.printList();
                    System.out.println("");

                    break;

                case 4:
                    System.out.println("Enter the power which you want to delete from polynomials: ");
                    int power_deletion = scn.nextInt();
                    poly1 = delete(poly1, power_deletion);
                    poly2 = delete(poly2, power_deletion);
                    break;

            }
            System.out.println("Which task do you want to do?");
            System.out.println("1- Add");
            System.out.println("2- Multiply");
            System.out.println("3- Print");
            System.out.println("4- Delete");
            System.out.println("5- Exit");
            control = scn.nextInt();
        }

        if (control == 5) {
            System.out.println("Existing the program...");
        }

    }

           

    public static MyLinkedList delete(MyLinkedList poly1, int power) {

        Node temp_poly = poly1.first;
        MyLinkedList deletedPoly = new MyLinkedList();
        if (temp_poly.power == power) {
            deletedPoly.first = temp_poly.next;
        } else {

            while (temp_poly.next != null) {

                if (temp_poly.power == power) {
                    temp_poly = temp_poly.next;
                }

                if (temp_poly.next != null) {
                    deletedPoly.insertSorted(temp_poly.coef, temp_poly.power);
                }
                temp_poly = temp_poly.next;
            }
        }
        if (temp_poly.power != power) {
            deletedPoly.insertSorted(temp_poly.coef, temp_poly.power);
        }
        return deletedPoly;
    }

    public static MyLinkedList multiply(Node fnp1, Node fnp2) {
        Node tp1, tp2;
        tp1 = fnp1;  //ilk nodeler
        tp2 = fnp2;

        MyLinkedList multiplied = new MyLinkedList();

        while (tp1 != null) {
            while (tp2 != null) {
                int coef = tp1.coef * tp2.coef;
                int power = tp1.power + tp2.power;
                multiplied.insertSorted(coef, power);
                tp2 = tp2.next;
            }
            tp1 = tp1.next;
            tp2 = fnp2;
        }
        return multiplied;
    }
}
