
package LinkedList;

import Interfaces.MyQueue;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements MyQueue<T> {
    
    private static class Node<T>{
        //Atributos Nodo
        T value;
        Node<T> next;
        Node(T value){
            this.value=value; 
        } 
    }
    //Atributos LinkedQueue
    private Node<T> head, tail;
    private int n;

    //Metodos
    @Override public void enqueue(T num){
        Node<T> node = new Node<>(num);
        if (tail == null){
            head = tail = node; 
        }else {
            tail.next = node;
            tail = node;
        }
        n++;
    }

    @Override public T dequeue(){
        if (head == null) throw new NoSuchElementException("Queue underflow");
        T value = head.value;
        head = head.next;
        if (head == null) tail = null;
        n--;
        return value;
    }

    @Override public T front(){
        if (head == null) throw new NoSuchElementException("Queue empty");
        return head.value;
    }

    @Override public boolean isEmpty(){
        return head == null; 
    }
    @Override public int size(){
        return n; 
    }
}