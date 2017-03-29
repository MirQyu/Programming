package chapter20;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MultipleBounceBall extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		MultipleBallPane ballPane = new MultipleBallPane();
		Button btAdd = new Button("+");
		Button btSub = new Button("-");
		btAdd.setOnAction(e -> ballPane.add());
		btSub.setOnAction(e -> ballPane.substract());
		ballPane.setOnMousePressed(e -> ballPane.pause());
		ballPane.setOnMouseReleased(e -> ballPane.play());
		ballPane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.UP) {
				ballPane.increaseSpeed();
			}
			else if (e.getCode() == KeyCode.DOWN) {
				ballPane.decreaseSpeed();
			}
		});
		
		
		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(btAdd, btSub);
		hbox.setAlignment(Pos.CENTER);
		
		ScrollBar sbSpeed = new ScrollBar();
		sbSpeed.setMax(20);
		sbSpeed.setValue(10);
		ballPane.rateProperty().bind(sbSpeed.valueProperty());
		
		BorderPane pane = new BorderPane();
		pane.setTop(sbSpeed);
		pane.setCenter(ballPane);
		pane.setBottom(hbox);
		
		//Create a scene 
		Scene scene = new Scene(pane, 250, 150);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private class MultipleBallPane extends Pane {
		private Timeline animation;
		
		public MultipleBallPane() {
			
			animation = new Timeline(
				new KeyFrame(Duration.millis(50), e -> {
					moveBall();
				}));
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play();
		}
		
		public void add() {
			Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
			getChildren().add(new Ball(30,30,20,color));
		}
		
		public void substract() {
			if (getChildren().size() > 0) {
				getChildren().remove(getChildren().size() - 1);
			}
		}
		
		public void play() {
			animation.play();
		}
		
		public void pause() {
			animation.pause();
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

		private void moveBall() {
			// TODO Auto-generated method stub
			for (Node node : getChildren()) {
				Ball ball = (Ball)node;
				boolean isChangeColor = false;
				if (ball.getCenterX() < ball.getRadius() ||
						ball.getCenterX() > getWidth() - ball.getRadius()) {
					// 为什么能访问？
					// 好像是因为 内部类的原因哦
					ball.dx *= -1;
					isChangeColor = true;
				}
				if (ball.getCenterY() < ball.getRadius() ||
						ball.getCenterY() > getHeight() - ball.getRadius()) {
					ball.dy *= -1;
					isChangeColor = true;
				}
				
//				if (isChangeColor) {
//					ball.setFill(Color.color(Math.random(), Math.random(), Math.random(), 0.5));
//				}
				
				// Adjust ball position
				ball.setCenterX(ball.dx + ball.getCenterX());
				ball.setCenterY(ball.dy + ball.getCenterY());
			}
		}
	}
	
	class Ball extends Circle {
		private double dx = 1, dy = 1;
		
		public Ball(double x, double y, double radius, Color color) {
			super(x, y, radius);
			this.setFill(color);
		}
	}
	
}


