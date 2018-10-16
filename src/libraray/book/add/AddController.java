/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraray.book.add;

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


public class AddController implements Initializable {
   @FXML
    JFXButton btnSave;
    JFXButton btncancel;
      @FXML 
      JFXTextField bookTitle;
      @FXML
       JFXTextField bookID;
      @FXML
      JFXTextField bookAuthor;
      @FXML
      JFXTextField bookPublisher;
      AnchorPane pane;       
      DatabaseHandler dbh;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private JFXButton btnCancel;
   

    @FXML
    public void saveBook(ActionEvent event) throws ClassNotFoundException, SQLException{
      String bokID= bookID.getText();
      String bokTitle=bookTitle.getText();
      String bokpub=bookPublisher.getText();
      String bokAuthor=bookAuthor.getText();
      if(bokID.isEmpty()||bokTitle.isEmpty()||bokpub.isEmpty()||bokAuthor.isEmpty()){
      
      Alert alert =new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText(null);
      alert.setContentText("please fill fields..........");
      alert.showAndWait();
      return;
      }
      
      String sql ="INSERT INTO bookaddd VALUES("
              +"'"+ bokID +"',"
               +"'"+ bokTitle +"',"
               +"'"+ bokpub +"',"
               +"'"+ bokAuthor +"',"
               +""+ true +""+")";
      
      if(dbh.excuteAction(sql)){
           Alert alert =new Alert(Alert.AlertType.INFORMATION);
      alert.setHeaderText(null);
      alert.setContentText("Data insert sucessfully..........");
      alert.showAndWait();
      
      }else{
           Alert alert =new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText(null);
      alert.setContentText("Field..........");
     alert.showAndWait();
      
      }
    }
    @FXML
     public void cancelBook(ActionEvent event){
     
         Stage stage=(Stage) pane.getScene().getWindow();
         stage.close();
         
     
     }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      dbh=  DatabaseHandler.getInstant();
    }    
    
}
