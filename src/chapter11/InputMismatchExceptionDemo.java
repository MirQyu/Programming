package chapter11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatchExceptionDemo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		boolean continueInput = true;
		
		do {
			try {
				System.out.print("Enter an integer: ");
				int number = input.nextInt();
				
				// Display
				System.out.println("The number entered is " + number);
				
				continueInput = false;
			} catch (InputMismatchException e) {
				e.printStackTrace();
				System.out.println("\n" + input.nextLine());
				
			}
		} while (continueInput);
	}
}
