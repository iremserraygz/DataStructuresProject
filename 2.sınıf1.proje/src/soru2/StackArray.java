/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soru2;

import java.util.NoSuchElementException;

/**
 *
 * @author İrem Serra
 */
public class StackArray {

 
    String data[];
    int top;
    StackArray reverse;

    public StackArray(int N) {
        data = new String[N];
        top = -1;
    }

    public void push(String element) {

        if (isFull()) {
            resize(2 * data.length);
        }
        top++;
        data[top] = element;
    }

    public String pop() throws NoSuchElementException {

        if (isEmpty()) {
            throw new NoSuchElementException("The stack is empty!!");
        }
        else if(top==-1){//2 elemet kaldığında 0. indexi en üst değer sandığı için burda bir else if yaptık.
                return data[top];     
                    }
        else {
            top--;
            return data[top + 1];
        }

    }

    public boolean isFull() {

        if (top == data.length - 1) {
            return true;
        }

        return false;

    }

    public boolean isEmpty() {

        if (top == -1) {
            return true;
        }
        return false;
    }
    
    
    // stağin alabileceği eleman sayısını arttırıyo
    public void resize(int extention) {

        String[] extended = new String[extention];
        for (int i = 0; i <= top; i++) {
            extended[i] = data[i];
        }
        data = extended;

    }

    public String toPrint() {
        String str ="";
        if (isEmpty()) {
            System.out.println("The Stack is empty");
        } 
            
            for (int i = 0; i < this.top+1; i++) {

                if (i == this.top&&data[i]!=null) {
                   str+= data[i];
                } else if(data[i]!=null) {
                   str+= data[i] + "->";
                }
            }
        return str;
    }

}
