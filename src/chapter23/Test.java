package chapter23;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Test {
	public static final int NUMBER = 100;
	public static void main(String[] args) throws IOException {
//		createBinaryFile();
		readBinaryFile();
		
//		createTextFile();
	}
	public static void createTextFile() throws FileNotFoundException {
		PrintWriter output = new PrintWriter("text/d1.txt");
		for (int i = 0; i < NUMBER; i++) {
			output.print((int)(Math.random()*1000 + 1));
		}
		output.close();
		System.out.println("ok");
	}
	public static void readBinaryFile() throws FileNotFoundException, IOException {
		DataInputStream input = new DataInputStream(
				new BufferedInputStream(new FileInputStream("binary/d1.dat")));
		int i = 0;
		while (input.available() != 0) {
			System.out.println(input.readInt());
			i++;
		}
		System.out.printf("i ---> %d\n", i);
		input.close();
	}
	public static void createBinaryFile() throws FileNotFoundException, IOException {
		DataOutputStream output = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("binary/d1.dat")));
		for (int i = 0; i < NUMBER; i++) {
			output.writeInt( (int)(Math.random()*1000 + 1) );
		}
		output.close();
		System.out.println("ok");
	}
	
	public static <E extends Comparable<E>> boolean ordered
		(E[] list, boolean ascending) {
		
		boolean flag = true;
		for (int i = 1; i < list.length; i++) {
			if (ascending) {
				if (list[i-1].compareTo(list[i]) > 0) {
					flag = false;
					break;
				}
			}
			else {
				if (list[i-1].compareTo(list[i]) < 0) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
}
