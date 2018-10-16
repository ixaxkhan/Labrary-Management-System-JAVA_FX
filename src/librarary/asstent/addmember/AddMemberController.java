/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarary.asstent.addmember;

import libraray.book.add.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import librarary.database.DatabaseHandler;


public class AddMemberController implements Initializable {
   
           
     DatabaseHandler dbh;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField memberid;
    @FXML
    private JFXTextField mobile;
    @FXML
    private JFXTextField email;
   

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      dbh=  DatabaseHandler.getInstant();
    }    

    @FXML
    private void saveMember(ActionEvent event) throws ClassNotFoundException, SQLException {
        String dname=name.getText();
        String dmemberid=memberid.getText();
        String dmobile=mobile.getText();
        String demail=email.getText();
        
        if(dname.isEmpty()||dmemberid.isEmpty()||dmobile.isEmpty()||demail.isEmpty()){
        
         Alert alert =new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText(null);
      alert.setContentText(" Fill the field");
      alert.showAndWait();
        return;
        }
        String sql="INSERT INTO member VALUES("
                +"'"+ dmemberid+"',"
                +"'"+ dname+"',"
                +"'"+dmobile+"',"
                +"'"+demail+"'"+")";
       if( dbh.excuteAction(sql)){
       
              Alert alert =new Alert(Alert.AlertType.INFORMATION);
      alert.setHeaderText(null);
      alert.setContentText(" Add");
      alert.showAndWait();
       }else{
       
       Alert alert =new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText(null);
      alert.setContentText(" Fields");
      alert.showAndWait();
       }
    }

    @FXML
    private void cancel(ActionEvent event) {
    }
    
}
