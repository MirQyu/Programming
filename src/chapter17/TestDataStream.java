package chapter17;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class TestDataStream {
	
	public static void main(String[] args) {
		try (
				DataOutputStream output = new DataOutputStream(
												new BufferedOutputStream(
														new FileOutputStream("binary/t.dat")));
				){
			output.writeDouble(2);
			output.writeChar('1');
			output.writeChars("BC");
			
			output.writeUTF("DEF中");
//			output.writeUTF("ABCDEF");
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try (
				BufferedInputStream bufferInput = new BufferedInputStream(new FileInputStream("binary/t.dat"));
				
				
				) {
			
			//System.out.println(bufferInput.read());
			byte[] b = new byte[20];
			int size = bufferInput.read(b);
			for (int i = 0; i < size; i++)
				System.out.printf("%x ", b[i]);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
