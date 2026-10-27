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

    // returns the food item at the top without removing it
    public FoodItem peek() {
        if (top == -1) {
            System.out.println("Storage is empty! There is nothing at the top.");
            return null;
        }
        return storage[top];   // top doesn't change
    }

    // shows all the food items starting from the top
    public void display() {
        if (top == -1) {
            System.out.println("Storage is empty! There is nothing to display.");
            return;
        }
        System.out.println("Food items in the storage:");
        for (int i = top; i >= 0; i--) {
            System.out.println("\nTray " + (i + 1) + ":");
            System.out.println(storage[i].getDetails());
        }
    }

    // linear search to check each tray from the top until it finds the name
    // returns the index of the item or -1 if it isn't in the storage
    public int search(String name) {
        for (int i = top; i >= 0; i--) {
            if (storage[i].getName().equalsIgnoreCase(name)) {
                return i;   // if found
            }
        }
        return -1;   // if not found
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
