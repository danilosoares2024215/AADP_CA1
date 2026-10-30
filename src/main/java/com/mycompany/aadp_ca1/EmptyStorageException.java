/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aadp_ca1;

/**
 *
 * @author danilo
 */
public class EmptyStorageException extends Exception { // error used when someone tries to remove or search for food when the storage is empty
    
    public EmptyStorageException(String message) {
        
        super(message);   // sends the message to the Exception class
        
    }
    
}
