
package librarary.mangement.system;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import librarary.database.DatabaseHandler;

public class FXMLSignUpController implements Initializable {

    @FXML
    private JFXTextField userName;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField email;
      @FXML
    private JFXTextField phone ;
  
    private DatabaseHandler handler;
    @FXML
    private void CreateAccount(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
    
          
          String uname=userName.getText();
        String pass=password.getText();
        String emai=email.getText();
        String phon=phone.getText();
        
        String sql="INSERT INTO login (userName, password, mobile, email) VALUES("
                +"'"+uname+"',"
               +"'"+pass+"',"
               +"'"+emai+"',"
                +"'"+phon+"'"+" )";
        
        if(uname.isEmpty()||pass.isEmpty()||emai.isEmpty()||phon.isEmpty()){
        
            JOptionPane.showMessageDialog(null,"fill the field!");
        
        
        }else{
        
       
        if(handler.excuteAction(sql)){
            
            
        JOptionPane.showMessageDialog(null,"Account has been Created!");
         final Node source = (Node) event.getSource();
           
        final Stage stag = (Stage) source.getScene().getWindow();
            
        stag.close();
        
        
        }else{
        
        JOptionPane.showMessageDialog(null,"Error ");
        }
        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
       }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handler=DatabaseHandler.getInstant();
    }    

   
   

    
    
}
