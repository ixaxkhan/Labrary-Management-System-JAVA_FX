/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarary.asstent.membertableView;

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
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import librarary.database.DatabaseHandler;


public class FXMLMemberTableViewController implements Initializable {

    
    ObservableList <member> list= FXCollections.observableArrayList();
    @FXML
    private AnchorPane RootPane;
    @FXML
    private TableView<member> TabelView;
    @FXML
    private TableColumn<member, String> namecol;
        @FXML
    private TableColumn<member, String> mobilecol;
        @FXML
    private TableColumn<member, String> emailcol;
        @FXML
    private TableColumn<member, String> memberid;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        intiCol();
        try {
            loadeData();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLMemberTableViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMemberTableViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

   

    private void intiCol() {
        
        memberid.setCellValueFactory(new PropertyValueFactory<>("MemberID"));
         namecol.setCellValueFactory(new PropertyValueFactory<>("Name"));
          mobilecol.setCellValueFactory(new PropertyValueFactory<>("Mobile"));
           emailcol.setCellValueFactory(new PropertyValueFactory<>("Email"));
        
        }

    private void loadeData() throws ClassNotFoundException, SQLException {
       try{
          
        DatabaseHandler handler= DatabaseHandler.getInstant();
       String sql="SELECT * FROM member";
       ResultSet rs=handler.excuteQuery(sql);
      while(rs.next()){
      String hid=rs.getString("memberid");
      String hname=rs.getString("name");
      String hmobile=rs.getString("mobile");
      String hemail=rs.getString("email");
  
      list.add(new member(hid,hname,hmobile,hemail));
      }
      
       }catch(SQLException e){
       
       e.printStackTrace();
       }
       
       TabelView.getItems().setAll(list);
    }
public static class member{

private final SimpleStringProperty MemberID;
private final SimpleStringProperty Name;
private final SimpleStringProperty Mobile;
private final SimpleStringProperty Email;

public member(String memberid,String name,String mobile,String email ){
    
    this.MemberID= new SimpleStringProperty(memberid);
    this.Name= new SimpleStringProperty(name);
    this.Mobile= new SimpleStringProperty(mobile);
    this.Email= new SimpleStringProperty(email);
    

}

        public String getMemberId() {
            return MemberID.get();
        }

        public String getName() {
            return Name.get();
        }

        public String getMobile() {
            return Mobile.get();
        }

        public String getEmail() {
            return Email.get();
        }

        


}
    
}
