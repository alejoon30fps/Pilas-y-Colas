import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class ArrayStack<T>{
    private Object[] a;
    private int n;

    public ArrayStack() {
        int tamano = 100;
        a = new Object[tamano];
        n = 0; 
    }
    public void push(T x) {
        if (n == a.length) resize(); 
        a[n++] = x;
    }

    public T pop() {
        if (n == 0) throw new NoSuchElementException("Stack underflow");
        T val = (T) a[--n];
        a[n] = null;
        return val;
    }

    public T peek() {
        if (n == 0) throw new NoSuchElementException("Stack empty");
        return (T) a[n - 1];
    }

    public boolean isEmpty() {
        return n == 0; 
    }
    public int size() {
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

class QueueWithStacks<T> {
    private ArrayStack<T> entrada;
    private ArrayStack<T> salida;

    public QueueWithStacks() {
        entrada = new ArrayStack<>();
        salida = new ArrayStack<>();
    }

    public void enqueue(T value) {
        entrada.push(value);
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        moverSiNecesario();
        return salida.pop();
    }

    public T front() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        moverSiNecesario();
        return salida.peek();
    }

    public boolean isEmpty() {
        return entrada.isEmpty() && salida.isEmpty();
    }

    private void moverSiNecesario() {
        if (salida.isEmpty()) {
            while (!entrada.isEmpty()) {
                salida.push(entrada.pop());
            }
        }
    }
}

public class ColaConPilas {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Start();
    }
    public static void Start(){
        Scanner sc= new Scanner(System.in);
        int ciclo= sc.nextInt();
        sc.nextLine();
        String entry;
        String[] options;
        QueueWithStacks<String> cola=new QueueWithStacks<>();
        for(int i=0; i<ciclo;i++){
            entry=sc.nextLine();
            options=entry.split(" ");
            switch(options[0]){
                case "1":
                    cola.enqueue(options[1]);
                    break;
                case "2":
                    cola.dequeue();
                    break;
                case "3":
                    System.out.println(cola.front());
                    break;
            }
        }
    }
    
    
}
