
package libraray.book.add;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author m.ixax khan
 */
public class AddBook {

    
    public void bookData() throws Exception {
      
         Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAdd.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    
    
    }
    
}
