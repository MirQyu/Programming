package chapter22;

import java.util.Scanner;

public class SieveOfPrime {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Find all prime numbers <= n, enter n: ");
		int n = input.nextInt();
		
		boolean[] primes = new boolean[n+1];
		
		// initialize the primes
		for (int i = 0; i< primes.length; i++)
			primes[i] = true;
		
		for (int i = 2; i <= n/i; i++) {
			if (primes[i] == true) {
				for (int k = i; k <= n/i; k++) 
					primes[i * k] = false;
			}
		}
		
		int count = 0;
		final int NUMBER_PER_LINE = 10;
		for (int i = 2; i < primes.length; i++) {
			if (primes[i] == true) {
				count++;
				if (count % NUMBER_PER_LINE == 0) {
					System.out.printf("%7d\n", i);
				}
				else {
					System.out.printf("%7d", i);
				}
			}
		}
		System.out.printf("\ntotal primes number less than or equal to %d have %d\n", n, count);
		input.close();
	}
}
