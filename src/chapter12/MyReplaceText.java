package chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyReplaceText {
	public static void main(String[] args) throws FileNotFoundException {
		if (args.length != 3) {
			System.err.println("参数个数错误");
			System.exit(1);
		}
		
		File inputFile = new File(args[0]);
		if (!inputFile.exists()) {
			System.err.println("源文件不存在！");
			System.exit(2);
		}
		
		Scanner input = new Scanner(inputFile);
		
		File outputFile = new File("tempMyReplaceText.txt");
		PrintWriter output = new PrintWriter(outputFile);
		
		StringBuilder stringBuilder = null;
		
		while (input.hasNextLine()) {
			stringBuilder = new StringBuilder(input.nextLine());
			int start = 0;
			while ((start = stringBuilder.indexOf(args[1], start)) != -1) {
				int end = start + args[1].length();
				stringBuilder.replace(start, end, args[2]);
			}
			output.println(stringBuilder.toString());
		}
		input.close();
		output.close();
		if (inputFile.delete())
			if (outputFile.renameTo(inputFile))
				System.out.println("ok");
		
	}
}
