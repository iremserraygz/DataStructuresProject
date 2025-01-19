/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.sınıf1.proje;

/**
 *
 * @author İrem Serra
 */
public class MyLinkedList {

   Node first, last;
    int size;
    
    public MyLinkedList() {
        this.first = null;
        this.last = null;
        size = 0;
    }
    
     public void printList() throws NullPointerException {

        Node temp = this.first;
        int sum = 0; // summition of coefs of nodes which powers are 0
        if(first == null) {
            throw new NullPointerException("Polynomial is zero");
        } else if (temp.power == 1) {
            System.out.print(temp.coef + "x");
        } else if (first == last && first.power == 1) {
            System.out.print(temp.coef + "x");
            return;
        } else if (first == last) {
            System.out.print(temp.coef + "x^" + temp.power);
        } else {
            System.out.print(temp.coef + "x^" + temp.power);
            temp = temp.next;

            while (temp.next != null) {

                if (temp.power == 0) {
                    sum += temp.coef;
                } else if (temp.coef < 0) {
                    System.out.print(temp.coef + "x^" + temp.power);
                } else if (temp.power == 1 && temp.coef > 0) {
                    System.out.print("+" + temp.coef + "x");
                } else if (temp.power == 1 && temp.coef < 0) {
                    System.out.print(temp.coef + "x");
                } else {
                    System.out.print("+" + temp.coef + "x^" + temp.power);
                }
                temp = temp.next;
            }

            
            
            if (temp.power == 0) {
                sum += temp.coef;
            } else if (temp.coef < 0) {
                System.out.print(temp.coef + "x^" + temp.power);
            } else if (temp.power == 1 && temp.coef > 0) {
                System.out.print("+" + temp.coef + "x");
            } else if (temp.power == 1 && temp.coef < 0) {
                System.out.print(temp.coef + "x");
            } else {
                System.out.print("+" + temp.coef + "x^" + temp.power);
            }

            if (sum != 0 && sum > 0) {
                System.out.print("+" + sum);
            } else if (sum != 0 && sum < 0) {
                System.out.print(sum);
            }
            System.out.println("");

        }
    }

    public void insertFirst(int coef, int power) {
        Node newNode = new Node(coef, power);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }
    
    public void insertLast(int coef, int power) {
        Node newNode = new Node(coef, power);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
            
        }
        size++;
    }
    
    public void insertAfter(Node temp, int coef, int power) {
        Node newNode = new Node(coef, power);
        Node prevNode = search(temp.power);
        if (prevNode != null) {
            Node old_prev_next = prevNode.next;
            prevNode.next = newNode;
            newNode.next = old_prev_next;
            size++;
        }
    }
    
    public Node search(int power) {
        Node tmp = first;
        while (tmp != null) {
            if (tmp.power == power) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }
    
    public void insertSorted(int coef, int power) { // aynı üsslü değeri iki kere yazdırıyor coefleri toplamıyor
        if (first == null) { //size = 0
            Node newNode = new Node(coef, power);
            if (first == null) {
                first = newNode;
                last = newNode;
            } else {
                newNode.next = first;
                first = newNode;
            }
            size++;
            return;
        }
        
        if (first.next == null) { // size = 1
            if (first.power < power) {
                insertFirst(coef, power);
            } else if (first.power == power) {
                first.coef += coef;
            } else {
                insertLast(coef, power);
            }
            return;
        }
        
        Node tmp = first;
        
        if (tmp.power < power) {
            insertFirst(coef, power);
            return;
        }
        
        boolean isThere = false;
        
        while (tmp != null) {
            if (tmp.power == power) {
                isThere = true;
                tmp.coef += coef;
                return;
            }
            tmp = tmp.next;
        }
        
        tmp = first;
        if (isThere == false) {
            while (tmp.next != null) {
                if (tmp.next.power < power) {
                    insertAfter(tmp, coef, power);
                    return;
                }
                tmp = tmp.next;
            }
            
        }
        insertLast(coef, power);
        
    }
    
    public MyLinkedList add(Node p1fe, Node p2fe) { // aynı üslülerin coeflerini topla
        Node a = p1fe; // first element of first polynomial
        Node b = p2fe; // first element of second polynomial
        MyLinkedList sorted = new MyLinkedList();
        while (a != null || b != null) {
            if (a == null) {
                sorted.insertSorted(b.coef, b.power);
                break;
            } else if (b == null) {
                sorted.insertSorted(a.coef, a.power);
                break;
            } else if (a.power == b.power) {
                sorted.insertSorted(a.coef + b.coef, a.power);
                a = a.next;
                b = b.next;
            } else if (a.power > b.power) {
                sorted.insertSorted(a.coef, a.power);
                a = a.next;
            } else if ((a.power < b.power)) {
                sorted.insertSorted(b.coef, b.power);
                b = b.next;
            }
        }
        return sorted;
    }
}
