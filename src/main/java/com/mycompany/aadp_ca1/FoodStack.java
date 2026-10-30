/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.aadp_ca1;

/**
 *
 * @author danilo
 */
public interface FoodStack {

    // adds a food item to the top of the storage list + exception
    void push(FoodItem item) throws FullStorageException;

    // removes and returns the food item at the top of the storage + exception
    FoodItem pop() throws EmptyStorageException;
    
    // returns the food item at the top without removing it + exception
    FoodItem peek() throws EmptyStorageException;

    // shows all the food items in the storage, from top to bottom
    void display();

    // looks for a food item by name and returns its position (-1 if not found)
    int search(String name);

    // returns true if the storage is empty
    boolean isEmpty();

    // returns true if the storage is full
    boolean isFull();
}    
