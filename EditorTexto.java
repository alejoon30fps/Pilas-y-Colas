import java.io.*;
import java.util.*;

class LinkedStack<T> {
    private static class Node<T> {
        T value; 
        Node<T> next;
        Node(T value, Node<T> next){
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> head;
    private int n;

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

    public boolean isEmpty(){
        return head == null; 
    }
}

public class EditorTexto {

    public static void main(String[] args) throws IOException {
        leer();
    }

    public static void leer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        LinkedStack<String> saveChanges = new LinkedStack<>();
        StringBuilder S = new StringBuilder(); 
        StringBuilder output = new StringBuilder(); 

        for (int i = 0; i < Q; i++) {
            String entry = br.readLine();
            String[] parts = entry.split(" ");
            char type = entry.charAt(0);

            if (type == '1') S = append(S, parts[1], saveChanges);
            else if (type == '2') S = delete(S, parts[1], saveChanges);
            else if (type == '3') print(S, parts[1], output);
            else if (type == '4') S = undo(saveChanges);
        }

        System.out.print(output);
    }

    public static StringBuilder append(StringBuilder S, String add, LinkedStack<String> saveChanges){
        saveChanges.push(S.toString());
        S.append(add);
        return S;
    }

    public static StringBuilder delete(StringBuilder S, String last, LinkedStack<String> saveChanges){
        saveChanges.push(S.toString());
        int limit = Integer.parseInt(last);
        S.delete(S.length() - limit, S.length());
        return S;
    }

    public static void print(StringBuilder S, String position, StringBuilder output){
        int pos = Integer.parseInt(position);
        output.append(S.charAt(pos - 1)).append('\n');
    }

    public static StringBuilder undo(LinkedStack<String> saveChanges){
        if (!saveChanges.isEmpty()) {
            return new StringBuilder(saveChanges.pop());
        }
        return new StringBuilder();
    }
}
