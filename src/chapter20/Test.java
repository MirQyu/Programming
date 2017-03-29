package chapter20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		String str = "51 + 54 *  (  3 + 2  )  ";
		String[] tokens = str.split(" ");
		System.out.println(tokens.length + "-----" + Arrays.asList(tokens));
	}
}
