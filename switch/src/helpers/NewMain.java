/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;


import java.sql.Connection;

/**
 *
 * @author Manouher
 */
public class NewMain {
    
    private Connection Connect;
    
    public static void main(String[] args){
       Connection Con = database.getConnect();
    }
    
}
