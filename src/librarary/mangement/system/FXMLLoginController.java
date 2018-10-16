/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarary.mangement.system;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import librarary.database.DatabaseHandler;


public class FXMLLoginController implements Initializable {

    @FXML
    private JFXTextField userName;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXCheckBox rememberME;
    private DatabaseHandler handler;
    private Connection conn;
    private ResultSet rs;
      private Statement stm;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handler=DatabaseHandler.getInstant();
    }    

    @FXML
    private void newAccount(ActionEvent event) throws IOException {
         
        
        final Node source = (Node) event.getSource();

        final Stage stag = (Stage) source.getScene().getWindow();

        stag.close();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLSignUp.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void checkLogin(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
       
        String uName = userName.getText();
        String upassword = password.getText();

        if (uName.isEmpty() || upassword.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText(" Fill the field");
            alert.showAndWait();
        } else {

            String sql = "SELECT userName  password FROM login WHERE userName =" + "'" + uName + "'" + "AND password =" + "'" + upassword + "'";

            rs = handler.excuteQuery(sql);
            int count = 0;
            while (rs.next()) {
                count = count + 1;
            }
            if (count == 1) {
                final Node source = (Node) event.getSource();
                final Stage stag = (Stage) source.getScene().getWindow();
                stag.close();
                Parent root = FXMLLoader.load(getClass().getResource("/librarary/management/system/main/FXMLmain.fxml"));
                Scene scene = new Scene(root);

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } else if (count > 1) {
                JOptionPane.showMessageDialog(null, "Duplicate User, Access Denied!");
            } else {
                JOptionPane.showMessageDialog(null, "user doesn't exsist. ");
            }

        }
        
    }

    @FXML
    private void forgetPassword(ActionEvent event) {
    }
    
}
