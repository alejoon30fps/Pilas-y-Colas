/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
public interface MyStack<T> {
    //metodos 
    void push(T x);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
