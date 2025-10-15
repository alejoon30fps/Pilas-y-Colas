
package Array;

import Interfaces.MyStack;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayStack<T> implements MyStack<T> {
    private Object[] a;
    private int n;

    public ArrayStack() {
        
        
        //Se coloca un size del arreglo 
        int tamano = 2;
        a = new Object[tamano];
        
        n = 0; 
}
  @Override
    public void push(T x) {
        if (n == a.length) resize(); /*a = Arrays.copyOf(a, a.length * 2); // redimensionamiento*/
        a[n++] = x;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if (n == 0) throw new NoSuchElementException("Stack underflow");
        T val = (T) a[--n];
        a[n] = null; // evitar memory leak
        return val;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if (n == 0) throw new NoSuchElementException("Stack empty");
        return (T) a[n - 1];
    }

    @Override public boolean isEmpty() {
        return n == 0; 
    }
    @Override public int size() {
        return n; 
    }
    
    private void resize() {
        Object[] b = new Object[a.length * 2];
        for (int i = 0; i < n; i++){
            b[i] = a[i];
        }
        a = b; 
    }
}