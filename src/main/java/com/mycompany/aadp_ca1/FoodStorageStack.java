/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aadp_ca1;

/**
 *
 * @author danilo
 */
public class FoodStorageStack implements FoodStack {

    private FoodItem[] storage;   // array that holds all the food items
    private int top;              // index of the item at the top
    private int capacity;         // maximum number of trays

    // constructor to create the empty storage with the chosen size
    public FoodStorageStack(int size) {
        storage = new FoodItem[size];
        capacity = size;
        top = -1;   // -1 means taht there is nothing in the storage
    }

    // adds a food item to the top of the storage list
    public void push(FoodItem item) {
        if (top == capacity - 1) {
            System.out.println("The storage is full.\nMaximum of " + capacity + " trays.");
            return;
        }
        storage[++top] = item;   // move the top up and place the item there
        System.out.println(item.getName() + " added to the storage.");
    }

    // removes and returns the food item at the top of the storage
    public FoodItem pop() {
        if (top == -1) {
            System.out.println("Storage is empty! There is nothing to remove.");
            return null;
        }
        return storage[top--];   // return the top item and move old top down
    }

    // the storage is empty when top is -1
    public boolean isEmpty() {
        return top == -1;
    }

    // the storage is full when the top reaches the last index
    public boolean isFull() {
        return top == capacity - 1;
    }
}
