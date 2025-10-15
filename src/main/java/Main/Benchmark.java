package Main;

import Array.ArrayStack;
import Array.ArrayQueue;
import LinkedList.LinkedStack;
import LinkedList.LinkedQueue;
import Interfaces.MyStack;
import Interfaces.MyQueue;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class Benchmark {

    private static final int[] SIZES = {10, 100, 10_000, 100_000, 1_000_000};

    public static void main(String[] args) throws Exception {
        System.out.println("🚀 Iniciando benchmark...");
        PrintWriter out = new PrintWriter(new FileWriter("results.csv"));
        out.println("structure,operation,N,time_ns");

        // Pilas
        runStackBench(new ArrayStack<Integer>(), "ArrayStack", out);
        runStackBench(new LinkedStack<Integer>(), "LinkedStack", out);

        // Colas
        runQueueBench(new ArrayQueue<Integer>(), "ArrayQueue", out);
        runQueueBench(new LinkedQueue<Integer>(), "LinkedQueue", out);

        out.close();
        System.out.println("✅ Benchmark completado. Resultados guardados en results.csv");
    }

    // -------------------- PILAS --------------------
    private static void runStackBench(MyStack<Integer> stack, String name, PrintWriter out) {
        System.out.println("\n📦 Probando " + name);
        for (int N : SIZES) {
            System.out.println("   → N = " + N);
            simplePushPop(stack, 1000); // warm-up
            int runs = 5;
            long[] times = new long[runs];
            for (int r = 0; r < runs; r++) {
                times[r] = timePushPop(stack, N);
            }
            long median = median(times);
            out.printf("%s,pushpop,%d,%d%n", name, N, median);
        }
    }

    // -------------------- COLAS --------------------
    private static void runQueueBench(MyQueue<Integer> queue, String name, PrintWriter out) {
        System.out.println("\n📬 Probando " + name);
        for (int N : SIZES) {
            System.out.println("   → N = " + N);
            simpleEnqueueDequeue(queue, 1000);
            int runs = 5;
            long[] times = new long[runs];
            for (int r = 0; r < runs; r++) {
                times[r] = timeEnqueueDequeue(queue, N);
            }
            long median = median(times);
            out.printf("%s,enqueuedequeue,%d,%d%n", name, N, median);
        }
    }

    // -------------------- FUNCIONES AUXILIARES --------------------
    private static long timePushPop(MyStack<Integer> stack, int N) {
        stack = stack.getClass() == ArrayStack.class ? new ArrayStack<>() : new LinkedStack<>();
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) stack.push(i);
        for (int i = 0; i < N; i++) stack.pop();
        long end = System.nanoTime();
        return end - start;
    }

    private static long timeEnqueueDequeue(MyQueue<Integer> queue, int N) {
        queue = queue.getClass() == ArrayQueue.class ? new ArrayQueue<>() : new LinkedQueue<>();
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) queue.enqueue(i);
        for (int i = 0; i < N; i++) queue.dequeue();
        long end = System.nanoTime();
        return end - start;
    }

    private static void simplePushPop(MyStack<Integer> stack, int n) {
        for (int i = 0; i < n; i++) stack.push(i);
        for (int i = 0; i < n; i++) stack.pop();
    }

    private static void simpleEnqueueDequeue(MyQueue<Integer> queue, int n) {
        for (int i = 0; i < n; i++) queue.enqueue(i);
        for (int i = 0; i < n; i++) queue.dequeue();
    }

    private static long median(long[] arr) {
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }
}
