/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aadp_ca1;

/**
 *
 * @author danilo
 */
public class FullStorageException extends Exception{ // error used when someone tries to add food when the storage is full    
    public FullStorageException(String message) {
        
        super(message);   // sends the message to the Exception class
        
    }
    
}
