/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;



/**
 *
 * @author Manouher
 */
public class database {
    private Connection connect;

    
    public Connection connectDb(){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/malakad","root","Mo24685791?2");
            if(connect == null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("mon alerte");
                 alert.setContentText("échoué!");
                 alert.showAndWait();
            }else{
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("mon alerte");
                 alert.setContentText("réussite!");
                 alert.showAndWait();
            }
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
            return connect;

            
        }
    }
    
