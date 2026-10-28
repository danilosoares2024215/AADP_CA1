/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.aadp_ca1;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author danilo
 */
public class AADP_CA1 {

    public static void main(String[] args) {
        
        Scanner myKB = new Scanner(System.in);
        FoodStack storage = new FoodStorageStack(8);   // storage with a max of 8 trays

        // the menu keeps showing until the user chooses to exit
        while (true) {
            
            System.out.println("\n----- FOOD STORAGE -----");
            System.out.println("1. Add a new food item");
            System.out.println("2. Remove the top food item");
            System.out.println("3. Show the food item that is at the top");
            System.out.println("4. Show all the food items");
            System.out.println("5. Search for a specific food item");
            System.out.println("6. Exit");
            System.out.print("Choose an option from 1-6: ");

            int choice = myKB.nextInt();
            myKB.nextLine();   // skips the enter left by nextInt

            switch (choice) {
                
                case 1:   // add/puush
                    
                    System.out.print("Food name: ");
                    String name = myKB.nextLine();

                    System.out.print("Weight (in grams): ");
                    double weight = myKB.nextDouble();
                    myKB.nextLine();

                    System.out.print("Best before date (YYYY-MM-DD): ");
                    LocalDate bestBefore = LocalDate.parse(myKB.nextLine());

                    storage.push(new FoodItem(name, weight, bestBefore));
                    
                    break;

                case 2:   // remove/pop
                    
                    FoodItem removed = storage.pop();
                    
                    if (removed != null) {
                        
                        System.out.println(removed.getDetails() + " has been removed from the storage");
                        
                    }
                    
                    break;

                case 3:   // show the top (peek)
                    
                    FoodItem topItem = storage.peek();
                    
                    if (topItem != null) {
                        
                        System.out.println("Food item at the top is " + topItem.getName());
                        
                    }
                    
                    break;

                case 4:   // show all (display)
                    
                    storage.display();
                    
                    break;

                case 5:   // search
                    
                    System.out.print("Which food you want to search? ");
                    String searchName = myKB.nextLine();
                    int index = storage.search(searchName);
                    
                    if (index != -1) {
                        
                        System.out.println(searchName + " was found on tray " + (index + 1));
                        
                    } else {
                        
                        System.out.println(searchName + " couldn't be found in the storage");
                        
                    }
                    
                    break;

                case 6:   // exit
                    
                    System.out.println("Closed");
                    myKB.close();
                    
                    return;

                default:
                    
                    System.out.println("Invalid command. Please choose a number 1 to 6");
                    
            }
        }        
    }
}
