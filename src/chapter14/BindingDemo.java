package chapter14;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class BindingDemo {
	public static void main(String[] args) {
		DoubleProperty d1 = new SimpleDoubleProperty(1);
		DoubleProperty d2 = new SimpleDoubleProperty(2);
		d1.bind(d2);
		System.out.println("d1 is " + d1.getValue()
		+ " and d2 is " + d2.getValue());
		d1.set(80);
		System.out.println("d1 is " + d1.getValue()
		+ " and d2 is " + d2.getValue());
	}
}
