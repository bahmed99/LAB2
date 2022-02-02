
package Activity1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed
 */
public class StartStopClock extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ClockPane clock1 = new ClockPane();
        HBox pane2 = new HBox(2);
        Button btnStart = new Button("Start");
        Button btnStop = new Button("Stop");
        
        
        btnStart.setOnAction(e->{
            clock1.start();   
        }); 
        btnStop.setOnAction(e->{
            clock1.stop();  
        });
        
        
        
        
        pane2.getChildren().addAll(btnStart,btnStop);
                
        BorderPane pane = new BorderPane();      
        pane2.setAlignment(Pos.CENTER);
        
        pane.setCenter(clock1);
        
        pane.setBottom(pane2);
        
        Scene scene = new Scene(pane, 600, 300);

        primaryStage.setTitle("DisplayClock"); // Set the stage title

        primaryStage.setScene(scene); // Place the scene in the stage
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
