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
        String[] foodTypes = {"Burger", "Pizza", "Fries", "Sandwich", "Hotdog"};   // the only foods allowed

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

            // try and catches to handle errors and avoid the crashes on user mistakes
            try {

                int choice = myKB.nextInt();
                myKB.nextLine();   // skips the enter left by nextInt

                switch (choice) {
                    
                    case 1:   // add/puush with the option required by the assignment
                        
                        // checks before asking what user wants to add, so he doesn't add al the details and the storage space chekc is done after
                        if (storage.isFull()) {
                            
                            System.out.println("The storage is full. Free some space before adding a new item.");
                            break;
                            
                        }
                        
                        System.out.println("1. Burger");
                        System.out.println("2. Pizzza");
                        System.out.println("3. Fries");
                        System.out.println("4. Sandwich");
                        System.out.println("5. Hotdog");
                        System.out.println("Choose an option (1 to 5).");
                        int foodChoice = myKB.nextInt();
                        
                    // creates a restriction for the user to select between only the availiable options
                        while (foodChoice < 1 || foodChoice > 5) {
                            
                        System.out.println("Invalid option. Please choose an option between the availiable ones.");
                            foodChoice = myKB.nextInt();
                            
                        }
                        
                        String name = foodTypes[foodChoice -1]; // option 1 on the array is on index 0

                        System.out.print("Weight (in grams): ");
                        int weight = myKB.nextInt();
                        
                        while (weight <= 0) {
                            
                            System.out.print("The weight must be bigger than 0g.\nWeight (in grams): ");
                            weight = myKB.nextInt();
                            
                        }
                        
                        myKB.nextLine();

                    System.out.print("Best before date (YYYY-MM-DD. Maximum of two weeks.: ");
                        LocalDate bestBefore = LocalDate.parse(myKB.nextLine());

                        storage.push(new FoodItem(name, weight, bestBefore));
                        
                        break;

                    case 2:   // remove/pop
                        
                        FoodItem removed = storage.pop();
                        System.out.println(removed.getDetails() + " has been removed from the storage");
                        
                        break;

                    case 3:   // show the top (peek)
                        
                        FoodItem topItem = storage.peek();
                        System.out.println("Food item at the top is " + topItem.getName());
                        
                        break;

                    case 4:   // show all (display)
                        
                        storage.display();
                        
                        break;

                    case 5:   // search
                        
                        // same check before getting what the user wants
                        if (storage.isEmpty()) {
                            
                            System.out.println("Storage is empty! There is nothing to search.");
                            break;
                            
                        }
                        
                        System.out.print("Which food you want to search? (1-5) ");
                        System.out.println("\n1. Burger  2. Pizza  3. Fries  4. Sandwich  5. Hotdog");
                        int searchFood = myKB.nextInt();
                        
                        while (searchFood < 1 || searchFood > 5) {
                            
                            System.out.print("Invalid option! Choose a number from 1 to 5: ");
                            searchFood = myKB.nextInt();
                            
                        }
                        
                        String searchName = foodTypes[searchFood - 1];
                        int index = storage.search(searchName);
                        
                        if (index != -1) {
                            
                            System.out.println(searchName + " is located at tray " + (index + 1));
                            
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

            } catch (FullStorageException e) {   // the storage is full
                
                System.out.println(e.getMessage());
                
            } catch (EmptyStorageException e) {   // the storage is empty
                
                System.out.println(e.getMessage());
                
            } 
        }        
    }
}
