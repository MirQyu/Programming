package chapter17;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TestPrintWriter {
	
	public static void main(String[] args) {
		try (
				PrintWriter pw = new PrintWriter("text/t.txt");) {
			pw.write("BC");
//			pw.write("DEF中");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
