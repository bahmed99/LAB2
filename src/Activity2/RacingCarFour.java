package Activity2;

import Activity2.CarPane;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;

public class RacingCarFour extends Application {
	HBox Speed = new HBox(10);
	VBox Cars = new VBox(4);
        
	protected ObservableList<Node> texts = Speed.getChildren();
	protected ObservableList<Node> cars = Cars.getChildren();

	@Override 
	public void start(Stage primaryStage) {
		
		Speed.setAlignment(Pos.CENTER);

		for (int i = 0; i < 4; i++) {
			Speed.getChildren().addAll(
				new Label("Car " + (i + 1) + ":"), new TextField());
		}

		for (int i = 1; i < 8; i+= 2) {
			((TextField)texts.get(i)).setPrefColumnCount(2);
		}

	
		for (int i = 0; i < 4; i++) {
                        CarPane car =  new CarPane();
                        car.setStyle("-fx-border-color: black");
			Cars.getChildren().add(car);
		}

		
		for (int i = 1; i < 8; i += 2) {
			((TextField)texts.get(i)).setOnKeyPressed(e -> {
				if (e.getCode() == KeyCode.ENTER) {
					setSpeed();
				}
			});

		}
		
		BorderPane pane = new BorderPane();
		pane.setTop(Speed);
		pane.setCenter(Cars);

		Scene scene = new Scene(pane, 400, 200);
		primaryStage.setTitle("4 cars"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}

	private void setSpeed() {
		for (int j = 0; j < 4; j++) {
                    
			if (((TextField)texts.get(2*j+1)).getText().length() > 0) {
				((CarPane)cars.get(j)).setSpeed(Double.parseDouble(((TextField)texts.get(2*j+1)).getText()));
				((CarPane)cars.get(j)).play();
			}
			else {
				((CarPane)cars.get(j)).pause();
			}
		}
	}
        
        public static void main(String[] args) {
        launch(args);
    }
}