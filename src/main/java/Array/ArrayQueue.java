/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Array;

/**
 *
 * @author josue
 */
import Interfaces.MyQueue;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayQueue<T> implements MyQueue<T> {
    private Object[] a;
    private int head, tail, size;

    public ArrayQueue() {
        Scanner sc = new Scanner(System.in);
        //Se coloca un size del arreglo 
        int tamano = sc.nextInt();
        a = new Object[tamano];
    }

    @Override
    //circular
    public void enqueue(T x) {
        if (size == a.length) resize();
        a[tail] = x;
        tail = (tail + 1) % a.length;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T dequeue() {
        if (size == 0) throw new NoSuchElementException("Queue underflow");
        T val = (T) a[head];
        a[head] = null;
        head = (head + 1) % a.length;
        size--;
        return val;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T front() {
        if (size == 0) throw new NoSuchElementException("Queue empty");
        return (T) a[head];
    }

    @Override public boolean isEmpty() {
        return size == 0; 
    
    }
    @Override public int size() {
        return size; 
    }

    private void resize() {
        Object[] b = new Object[a.length * 2];
        for (int i = 0; i < size; i++){
            b[i] = a[(head + i) % a.length];
        }
        a = b; head = 0; tail = size;
    }
}
