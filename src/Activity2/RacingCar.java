
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
       
        CarPane car= new CarPane(0,120);
        
        car.setOnMousePressed(e->{
            car.pause();
            
        });
        car.setOnMouseReleased(e->{
            car.play();
            
        });
        car.setOnKeyPressed(e -> {
            if(e.getCode()==KeyCode.UP){
                car.Increase();
            }
            else if (e.getCode() == KeyCode.DOWN) {
                car.Decrease();
            }
            else if (e.getCode() == KeyCode.SPACE) {
                car.Jump();
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
