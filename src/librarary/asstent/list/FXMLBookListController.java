/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarary.asstent.list;

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


public class FXMLBookListController implements Initializable {

    
    ObservableList <book> list= FXCollections.observableArrayList();
    @FXML
    private AnchorPane RootPane;
    @FXML
    private TableView<book> TabelView;
    @FXML
    private TableColumn<book, String> TitleCol;
    @FXML
    private TableColumn<book, String> BookIDCol;
    @FXML
    private TableColumn<book, String> AuthorCol;
    @FXML
    private TableColumn<book, String> PublisherCol;
    @FXML
    private TableColumn<book, Boolean> AvilibilityCol;

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
            Logger.getLogger(FXMLBookListController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLBookListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    private void newAccount(ActionEvent event) throws IOException {
        
         Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLSignUp.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    private void intiCol() {
        
        TitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
         BookIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
          AuthorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
           PublisherCol.setCellValueFactory(new PropertyValueFactory<>("publisher"));
          AvilibilityCol.setCellValueFactory(new PropertyValueFactory<>("avili"));
        }

    private void loadeData() throws ClassNotFoundException, SQLException {
       try{
          
        DatabaseHandler handler= DatabaseHandler.getInstant();
       String sql="SELECT * FROM bookaddd";
       ResultSet rs=handler.excuteQuery(sql);
      while(rs.next()){
      String title=rs.getString("Title");
      String id=rs.getString("ID");
      String author=rs.getString("Author");
      String Publisher=rs.getString("Publisher");
      boolean isAvil=rs.getBoolean("isAvil");
      list.add(new book(title,id,author,Publisher,isAvil));
      }
      
       }catch(SQLException e){
       
       e.printStackTrace();
       }
       
       TabelView.getItems().setAll(list);
    }
public static class book{

private final SimpleStringProperty title;
private final SimpleStringProperty id;
private final SimpleStringProperty author;
private final SimpleStringProperty publisher;
private final SimpleBooleanProperty avili;
public book(String title,String id,String author,String publisher , boolean avili){
    
    this.title= new SimpleStringProperty(title);
    this.id= new SimpleStringProperty(id);
    this.author= new SimpleStringProperty(author);
    this.publisher= new SimpleStringProperty(publisher);
    this.avili= new SimpleBooleanProperty(avili);

}

        public String getTitle() {
            return title.get();
        }

        public String getId() {
            return id.get();
        }

        public String getAuthor() {
            return author.get();
        }

        public String getPublisher() {
            return publisher.get();
        }

        public boolean getAvili() {
            return avili.get();
        }


}
    
}
