import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class LinkedStack<T> {
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
    public void push(T x){
        head = new Node<>(x, head);
        n++; 
    }

    public T pop(){
        if (head == null) throw new NoSuchElementException("Stack underflow");
        T value = head.value;
        head = head.next;
        n--; 
        return value;
    }

    public T peek(){
        if (head == null) throw new NoSuchElementException("Stack empty");
        return head.value;
    }

    public boolean isEmpty(){
        return head == null; 
    }
    public int size(){ 
        return n; 
    }
}
class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
    // Write your code here
        Stack<Character> pila= new Stack<>();
        char popeado;
        for(char i : s.toCharArray()){
            if(i=='{' || i=='(' || i=='[') pila.push(i);
            else{
                if(pila.isEmpty()) return "NO";
                popeado=pila.pop();
                if(i==')' && popeado!='(') return "NO";       
                if (i == '}' && popeado != '{') return "NO";
                if (i == ']' && popeado != '[') return "NO";
            }
        }
        return pila.isEmpty() ? "YES" : "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String s = bufferedReader.readLine();

            String result = Result.isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
