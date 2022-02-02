
package Activity1;

import Activity1.ClockPane2;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed
 */
public class TwoClock extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ClockPane2 clock1 = new ClockPane2(4,20,45);
        ClockPane2 clock2 = new ClockPane2(22,46,15);
       
  
        
        HBox pane = new HBox(10);        
        
        pane.getChildren().addAll(clock1,clock2);
        
        pane.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(pane, 800, 300);

        primaryStage.setTitle("DisplayClock"); // Set the stage title

        primaryStage.setScene(scene); // Place the scene in the stage

        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
