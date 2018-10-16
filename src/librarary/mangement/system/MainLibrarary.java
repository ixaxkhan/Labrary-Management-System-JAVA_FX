
package librarary.mangement.system;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//import librarary.asstent.list.LoaderTabel;
import librarary.database.DatabaseHandler;

public class MainLibrarary extends Application {
     public static void main(String[] args) throws ClassNotFoundException {
      
      
  Application.launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
         Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        
        Scene scene = new Scene(root);
        
       primaryStage.setScene(scene);
      primaryStage.setTitle("");
      
      // primaryStage.initStyle(StageStyle.UTILITY);
     primaryStage.show();
     
    }
}
