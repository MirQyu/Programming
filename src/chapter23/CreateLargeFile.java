package chapter23;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateLargeFile {
	public static void main(String[] args) throws IOException {
		DataOutputStream output = new DataOutputStream(
				new BufferedOutputStream(
				new FileOutputStream("binary/largedata.dat")));
		
		for (int i = 0; i < 800004; i++) {
			output.writeInt((int)(Math.random() * 1000000));
		}
		
		output.close();
		
		// Display first 100 numbers
		DataInputStream input = new DataInputStream(
				new BufferedInputStream(
				new FileInputStream("binary/largedata.dat")));
		for (int i = 0; i < 100; i++)
			System.out.print(input.readInt() + " ");
	}
	
}
