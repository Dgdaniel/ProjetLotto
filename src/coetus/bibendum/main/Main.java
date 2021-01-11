
package coetus.bibendum.main;

import animatefx.animation.FadeIn;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

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
        Image image = new Image("/coetus/bibendum/icon/broken-zoneT.png");
        primaryStage.getIcons().add(image);
        primaryStage.setMaxWidth(Double.MAX_VALUE);
        primaryStage.initStyle(StageStyle.DECORATED);
        
        new  FadeIn(parent).setDelay(Duration.seconds(1)).play();
        primaryStage.centerOnScreen();
        
        
      
     
       // primaryStage.setResizable(false);
        primaryStage.show();
        
        parent.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
      
       parent.setOnMouseDragged((MouseEvent event) -> {
           primaryStage.setX(event.getScreenX()- xOffset);
           primaryStage.setY(event.getScreenY()- yOffset);
        });
    }
    
    public static void main(String[] args) {

         launch(args);
    }
    
    
}
