/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

public interface MyQueue<T>{
    //metoodos
    void enqueue(T x);
    T dequeue();      
    T front();        
    boolean isEmpty();
    int size();
    
}
