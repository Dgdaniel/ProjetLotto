
package coetus.bibendum.main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Daniel
 */
public class Main extends Application{
    
    public double xOffset;
    public double yOffset;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("../fxml/appMainMenu.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Aleam Lotto");
       
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setMaxWidth(Double.MAX_VALUE);
      
     
       primaryStage.setResizable(false);
        primaryStage.show();
        
        parent.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               xOffset = event.getSceneX();
               yOffset = event.getSceneY();
            }
        });
      
       parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
              
               primaryStage.setX(event.getScreenX()- xOffset);
               primaryStage.setY(event.getScreenY()- yOffset);
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
