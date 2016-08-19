package chapter15;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BallPane extends Pane{

	public final double radius = 25;
	private double x = radius, y = radius;
	private double dx = 1, dy = 1;
	private Circle circle = new Circle(x, y, radius);
	private Timeline animation;
	private FadeTransition ft;
	
	public BallPane() {
		circle.setFill(Color.GREEN);
		getChildren().add(circle);
		
		// Create an Fade
		ft = new FadeTransition(Duration.millis(1000), circle);
		ft.setFromValue(0.7);
		ft.setToValue(0.4);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		// Create an animation for moving the ball
		animation = new Timeline(
		new KeyFrame(Duration.millis(50), e -> {
			System.err.println(animation.getRate());
			moveBall();
		}));
		animation.setCycleCount(Timeline.INDEFINITE);
		
		animation.play();
		ft.play();
	}
	
	public void play() {
		animation.play();
		ft.play();
	}
	
	public void pause() {
		animation.pause();
		ft.pause();
	}
	
	public void increaseSpeed() {
		animation.setRate(animation.getRate() + 0.1);
	}
	
	public void decreaseSpeed() {
		animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
	}
	
	public DoubleProperty rateProperty() {
		return animation.rateProperty();
	}
	

	protected void moveBall() {
		// TODO Auto-generated method stub
		boolean isChangeColor = false;
		if (x < radius || x > getWidth() - radius) {
			dx *= -1;
			isChangeColor = true;
		}
		if (y < radius || y > getHeight() - radius) {
			dy *= -1;
			isChangeColor = true;
		}
		
		if (isChangeColor)
			circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		
		// Adjust ball position
		x += dx;
		y += dy;
		circle.setCenterX(x);
		circle.setCenterY(y);
	}
	
}
