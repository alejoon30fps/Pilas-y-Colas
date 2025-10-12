/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;

import Interfaces.MyStack;
import java.util.NoSuchElementException;

public class LinkedStack<T> implements MyStack<T> {
    private static class Node<T> {
        //Atributos Nodo
        T value; 
        Node<T> next;
        Node(T value, Node<T> next){
            this.value = value;
            this.next = next;
        }
    }
    //Atributos LinkedStack
    private Node<T> head;
    private int n;

    //Metodos 
    @Override public void push(T x){
        head = new Node<>(x, head);
        n++; 
    }

    @Override public T pop(){
        if (head == null) throw new NoSuchElementException("Stack underflow");
        T value = head.value;
        head = head.next;
        n--; 
        return value;
    }

    @Override public T peek(){
        if (head == null) throw new NoSuchElementException("Stack empty");
        return head.value;
    }

    @Override 
    public boolean isEmpty(){
        return head == null; 
    }
    @Override
    public int size(){ 
        return n; 
    }
}

