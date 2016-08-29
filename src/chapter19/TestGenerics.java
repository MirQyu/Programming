package chapter19;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		
		System.out.println(list instanceof ArrayList);
		Hello(new ArrayList<>());
	}
	
	public static <E> void Hello(List<E> o) {
		System.out.println("hello");
	}
	
}
