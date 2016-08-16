package chapter5;

import java.util.Scanner;

public class Exercise5_16 {

	public static void main(String[] args) {
		
//		final int NUMBER_OF_DIVISOR_PER_LINE = 5;
		
		Scanner input = new Scanner(System.in);
		
		int decimal = input.nextInt();
		
		int number = 2;
		
		while (true) {
			if (decimal == 1)
				break;
			if (decimal % number == 0) {
				System.out.print(number + " ");
				decimal = decimal / number;
			}
			else {
				number++;
			}
		}
	}

}
