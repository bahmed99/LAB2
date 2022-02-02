
package Activity2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class RacingCar extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        CarPane car= new CarPane();
        car.setOnMousePressed(e->{
            car.Pause();
            
        });
        car.setOnMouseReleased(e->{
            car.Start();
            
        });
        car.setOnKeyPressed(e -> {
            if(e.getCode()==KeyCode.UP){
                car.Increase();
            }
            else if (e.getCode() == KeyCode.DOWN) {
                car.Decrease();
            }
			
	});
        Scene scene = new Scene(car, 500, 120);
        primaryStage.setTitle("CarLab2");
        primaryStage.setScene(scene);
        primaryStage.show();
        car.requestFocus();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
