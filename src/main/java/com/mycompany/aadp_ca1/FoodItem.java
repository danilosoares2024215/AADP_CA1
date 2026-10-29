/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aadp_ca1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author danilo
 */
public class FoodItem {
    
    private final String name;              // name of the food item
    private final int weight;            // weight in grams
    private final LocalDate bestBefore;     // best before date (without time)
    private final LocalDateTime dateTime;   // date and time the item was placed into storage
    private static final DateTimeFormatter datePolish = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // sets the date to a polished format on display
    private static final DateTimeFormatter timePolish = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); // sets the time to a polished format on display

    // constructor to get the product name, weight and best before. also gets the time it was stord
    public FoodItem(String name, int weight, LocalDate bestBefore) {

        this.name = name;
        this.weight = weight;
        this.bestBefore = bestBefore;
        this.dateTime = LocalDateTime.now();   // takes the current date and time to set as the stored time

    }

    // getters for the parameters
    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public LocalDateTime getTimeStored() {
        return dateTime;
    }
    
    // returns all the information about the food item
    public String getDetails() {
        return getName()
                + "\nWeight: " + getWeight() + "g"
                + "\nBest Before: " + bestBefore.format(datePolish)
                + "\nDate Stored: " + getTimeStored().format(timePolish);
    }
}