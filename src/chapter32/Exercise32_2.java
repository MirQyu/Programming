package chapter32;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise32_2 extends Application{
	public static final int RADIUSX = 100;
	public static final double RADIUSY = 100;
	public static final int CENTERY = 150;
	public static final int CENTERX = 150;
	
	private Connection connection;
	private Statement statement;
	private ResultSet rs;
	private static String QUERYSTR;
	
	Map<String, Integer> map = new TreeMap<>();
	List<Color> colors = new ArrayList<>();

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		initDB();
		
		Pane pie = drawPie();
		Pane bar = drawBar();
		HBox hBox = new HBox(20);
		hBox.getChildren().add(pie);
		hBox.getChildren().add(bar);
		
		Scene scene = new Scene(hBox, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		connection.close();
	}


	private Pane drawBar() {
		// TODO Auto-generated method stub
		Pane pane = new Pane();
		Line line = new Line(50, 250, 50 + 200, 250);
		pane.getChildren().add(line);
		
		int length = 30;
		int width = 40;
		int i = 0;
		for (String key : map.keySet()) {
			int factor = map.get(key);
			int x = 50 + i * (width + 15);
			int y = 250 - factor * length;
			Rectangle rtg = new Rectangle(x, y, width, factor * length);
			Text text = new Text(x+3, y-5, key);
			rtg.setFill(colors.get(i));
			pane.getChildren().addAll(rtg, text);
			i++;
		}
		
		return pane;
	}

	private Pane drawPie() throws SQLException {
		// TODO Auto-generated method stub
		Pane pane = new Pane();
		double total = 0;
		while (rs.next()) {
			String deptId = rs.getString(1);
			int count = rs.getInt(2);
			total += count;
			map.put(deptId, count);
		}
		
		System.err.println(map.keySet());
		//Set<String> id =  map.keySet();
		double start = 0;
		for (String key : map.keySet()) {
			double length = map.get(key) / total * 360;
			Arc arc = new Arc(CENTERX, CENTERY, RADIUSX, RADIUSY, start, length);
			arc.setType(ArcType.ROUND);
			arc.setStroke(Color.WHITE);
			colors.add( Color.color(Math.random(), Math.random(), Math.random()) );
			arc.setFill(colors.get(colors.size()-1));
			double x = arc.getCenterX() + arc.getRadiusX() * Math.cos((start + length/2) * Math.PI/180);
			double y = arc.getCenterY() - arc.getRadiusY() * Math.sin((start + length/2) * Math.PI/180);
			Text id = new Text(x, y, key);
			pane.getChildren().addAll(arc, id);
			//System.err.println(key + " " + start + " " + length + " " + id.getX() + "  " + id.getY());
			start += length;
		}
		return pane;
	}


	private void initDB() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
			
			statement = connection.createStatement();
			
			QUERYSTR = "select deptId, count(*) from Student where deptId is not null group by deptId";
			
			rs = statement.executeQuery(QUERYSTR);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
