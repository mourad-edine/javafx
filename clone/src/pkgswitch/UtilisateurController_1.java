/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pkgswitch;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author Manouher
 */
public class UtilisateurController_1 implements Initializable {
    private Connection connect;
    private PreparedStatement statement;
    private ResultSet result;
    @FXML
    private TableColumn<?, ?> colonne1;
    
    
    @FXML
    private TableView<tableau> tablehierarche;

    @FXML
    private TableColumn<tableau,String> colonne2;

    @FXML
    private TableColumn<tableau,String> colonne3;

    @FXML
    private TableColumn<tableau,String> colonne4;

    @FXML
    private TableColumn<?, ?> colonne5;

    @FXML
    private TableColumn<?, ?> colonne6;
    
    
    @FXML
    private JFXButton ajouter;

    @FXML
    private AnchorPane root;
    private ObservableList<tableau> data = FXCollections.observableArrayList();
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    }    

    @FXML
    public void pageAjouter(ActionEvent event) {
        
       try {
            Parent fxml = FXMLLoader.load(getClass().getResource("register.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);

        }catch(IOException e){
            e.printStackTrace();
        
        }

    }
    public Connection connectDb(){
        colonne1.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colonne1.setCellValueFactory(new PropertyValueFactory<>("email"));
        colonne1.setCellValueFactory(new PropertyValueFactory<>("passe"));
        try {
            
            connect = DriverManager.getConnection("jdbc:mysql://localhost/malakad","root","Mo24685791?2");
            load();
            return connect;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        }
    }
    
   /* public void setCell(){
        colonne1.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colonne1.setCellValueFactory(new PropertyValueFactory<>("email"));
        colonne1.setCellValueFactory(new PropertyValueFactory<>("passe"));
        
    
    }*/
    public void load() throws SQLException{
        try{
         connect = connectDb();
         String sql = ("SELECT * FROM malakad");
         statement  = connect.prepareStatement(sql);
         result = statement.executeQuery();
         while(result.next()){
             data.add(new tableau (
                     result.getString("nom"),
                     result.getString("adresse"),
                     result.getString("passe")
             ));
         
         
         }
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,"echec !");
          
        
        }
        tablehierarche.setItems(data);
      
            
           
            
            
            
            
            
            
            
        
    
    }
    
    

    /**
     * Initializes the controller class.
     */
    
    
    
}
