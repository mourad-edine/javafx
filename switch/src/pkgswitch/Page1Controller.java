package pkgswitch;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Page1Controller {
    
    @FXML
    private Hyperlink lien2;
    
    @FXML
    private Button btn1;
    
    @FXML
    private TextField nom;

    @FXML
    private PasswordField passe;
    
    //base de donnée
    
    
    private Connection connect;
    private PreparedStatement statement;
    private ResultSet result;
    
    public Connection connectDb(){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/malakad","root","Mo24685791?2");
            return connect;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        }
    }
   

    public void handlelien2() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("fxlog.fxml"));
        
        Stage window = (Stage)lien2.getScene().getWindow();
        window.setScene(new Scene(root));
        System.out.println("vous avez bien changé de page !");
    }
    
    public void login(ActionEvent event){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = connectDb();
            
            String sql = "SELECT * FROM users WHERE nom = ? and passe = ?";
            statement  = connect.prepareStatement(sql);
            statement.setString(1,nom.getText());
            statement.setString(2,passe.getText());
            result = statement.executeQuery();
            
            if(result.next()){
                btn1.getScene().getWindow().hide();
                 Parent root = FXMLLoader.load(getClass().getResource("page2.fxml"));
                 Scene scene = new Scene(root);
                 Stage stage = new Stage();
                 stage.setScene(scene);
                 stage.show();
                 stage.setTitle("le vent du sud");
                
       
            }
            else{
                JOptionPane.showMessageDialog(null,"mauvais mot de passe");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"misy raha tsy manjary ao");
        }
          
    }

}
