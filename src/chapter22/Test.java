package chapter22;

public class Test {

	public static int sumTo(int n1, int n2) {
		int sum = (n2 - n1 + 1) / 2;
		sum *= (n1 + n2);
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(sumTo(1, 100));
	}
	
}
