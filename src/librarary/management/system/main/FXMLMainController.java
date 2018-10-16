/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarary.management.system.main;

import librarary.asstent.list.*;
import librarary.mangement.system.*;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;


import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import librarary.database.DatabaseHandler;


public class FXMLMainController implements Initializable {

    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       
    }    

    @FXML
    private void loadMember(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/librarary/asstent/addmember/FXMLAddMember.fxml"));    
        Scene scene = new Scene(root);

        Stage stage = new Stage();            
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void loadBook(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/libraray/book/add/FXMLAdd.fxml"));    
        Scene scene = new Scene(root);

        Stage stage = new Stage();            
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void loadMemberTable(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/librarary/asstent/membertableView/memberTableView.fxml"));    
        Scene scene = new Scene(root);

        Stage stage = new Stage();            
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void loadBookTable(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("/librarary/asstent/list/bookList.fxml"));    
        Scene scene = new Scene(root);

        Stage stage = new Stage();            
        stage.setScene(scene);
        stage.show();
    }
    
}
