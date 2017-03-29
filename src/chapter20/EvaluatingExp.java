package chapter20;

import java.util.Scanner;
import java.util.Stack;

public class EvaluatingExp {

	
	public static void main(String[] args) {
		Stack<Character> operatorStack = new Stack<>();
		Stack<Double> numberStack = new Stack<>();
		char nextOp = 0;
		
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		Scanner in = new Scanner(line);
		while (in.hasNext() || nextOp != 0) {
			String code = "";
			
			if (nextOp != 0) {
				code += nextOp;
				nextOp = 0;
			} else 
				code = in.next();
			
			try {
				double num = Double.valueOf(code);
				numberStack.push(num);
			} catch (NumberFormatException e) {
				char op = code.charAt(0);
				double result;
				switch(op) {
				case ')':
					if (operatorStack.peek() != '(') {
						double n1 = numberStack.pop();
						double n2 = numberStack.pop();
						char priorOp = operatorStack.pop();
						// delete (
						operatorStack.pop();
						result = calculate(n1, n2, priorOp);
						
						if (!operatorStack.isEmpty()) {
							if (operatorStack.peek().equals('*') || operatorStack.peek().equals('/')) {
								priorOp = operatorStack.pop();
								result = calculate(numberStack.pop(), result, priorOp);
							}
						}
						numberStack.push(result);
					}
					else {
						operatorStack.pop();
					}
					break;
				case '(':
				case '+':
				case '-':
					operatorStack.push(op);
					break;
				case '/':
				case '*':
					String next = in.next();
					// 当为 数字 时 
					if (next.charAt(0) >= 48 && next.charAt(0) <= 57) {
						double n = Double.valueOf(next);
						result = calculate(n, numberStack.pop(), op);
						numberStack.push(result);
					} else {
						nextOp = next.charAt(0);
						operatorStack.push(op);
					}
						
					break;
				}
			}
		}
		input.close();
		in.close();
		while (!operatorStack.isEmpty()) {
			char op = operatorStack.pop();
			double n1 = numberStack.pop();
			double n2 = numberStack.pop();
			numberStack.push(calculate(n2, n1, op));
		}
		System.out.println(numberStack.pop());
		
	}

	private static double calculate(double n1, double n2, char op) {
		double total = 0;
		switch (op) {
		case '+':
			total = n1 + n2;
			break;
		case '-':
			total = n1 - n2;
			break;
		case '*':
			total = n1 * n2;
			break;
		case '/':
			total = n1 / n2;
		}
		return total;
	}
	
}
