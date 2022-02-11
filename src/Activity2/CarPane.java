
package Activity2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.util.Duration;


public class CarPane extends Pane{
    
    protected double x ;
    protected double y ;
    protected Timeline animation ; 
    
    
    public void setSpeed(double speed) {
	if (speed <= 100)
            animation.play();
           animation.setRate(speed);
	}
    
    

    public CarPane(){
       
        y=40;
          animation = new Timeline(
            new KeyFrame(Duration.millis(500),e->MoveCar())
        );
         
        animation.setCycleCount(Timeline.INDEFINITE);
	;

            paintCar();
        }
    
    
        public CarPane(int a ,int b){
       
        x=a;
        y=b;
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
       circle1.setFill(Paint.valueOf("#1f212d"));
       circle1.setStroke(Paint.valueOf("#2ea3dd"));
       Circle circle2 = new Circle(x+35, y-5,5);
       circle2.setFill(Paint.valueOf("#1f212d"));
       circle2.setStroke(Paint.valueOf("#2ea3dd"));
       //Dessiner rectangle
       Rectangle rectangle = new Rectangle(x,y-20,50,10);
        rectangle.setFill(Paint.valueOf("#1f212d"));
        rectangle.setStroke(Paint.valueOf("#2ea3dd"));
       //Dessiner polygon
       Polygon polygon = new Polygon();
       polygon.getPoints().addAll(new Double[]{x+10,y-20,x+20,y-30,x+30,y-30,x+40,y-20});
       getChildren().addAll(circle1,circle2,rectangle,polygon); 
  
    }
    
    private void MoveCar(){
     if (x <= getWidth())
     {
	x=x+8;
     }	
     else{
	x = 0;}
        paintCar();
    }
    
    public void pause(){
        animation.pause();
    }
    
    public void play(){
        animation.play();
    }
    
    public void Increase(){
        animation.setRate(animation.getRate() + 1);
    }
    
    public void Jump(){
        y=y-50;
           new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
              y=120;
            }
        }, 
       500
);
        
    }
    
    public void Decrease(){
        if(animation.getRate()!=0)
        animation.setRate(animation.getRate() - 1);
    }
    
}
