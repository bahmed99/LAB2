
package Activity2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;


public class CarPane extends Pane{
    
    protected double x ;
    protected double y ;
    protected Timeline animation ; 
    
    
    
    
    public CarPane(){
        x=0;
        y=120;
        
        
          animation = new Timeline(
            new KeyFrame(Duration.millis(500),e->MoveCar())
        );
         
        animation.setCycleCount(Timeline.INDEFINITE);
	animation.play();

            paintCar();
        }
    
    private void paintCar(){
        getChildren().clear();
       //Dessiner les roues
       Circle circle1 = new Circle(x+15, y-5,5);
       circle1.setFill(Color.BLACK);
       circle1.setStroke(Color.BLACK);
       Circle circle2 = new Circle(x+35, y-5,5);
       circle2.setFill(Color.BLACK);
       circle2.setStroke(Color.BLACK);
       //Dessiner rectangle
       Rectangle rectangle = new Rectangle(x,y-20,50,10);
        rectangle.setFill(Color.BLACK);
        rectangle.setStroke(Color.BLACK);
       //Dessiner polygon
       Polygon polygon = new Polygon();
       polygon.getPoints().addAll(new Double[]{x+10,y-20,x+20,y-30,x+30,y-30,x+40,y-20});
       getChildren().addAll(circle1,circle2,rectangle,polygon); 
  
    }
    
    private void MoveCar(){
     if (x <= getWidth())
     {
	x++;
     }	
     else{
	x = 0;}
        paintCar();
    }
    
    public void Pause(){
        animation.pause();
    }
    
    public void Start(){
        animation.play();
    }
    
    public void Increase(){
        animation.setRate(animation.getRate() + 1);
    }
    
    public void Decrease(){
        if(animation.getRate()!=0)
        animation.setRate(animation.getRate() - 1);
    }
    
}
