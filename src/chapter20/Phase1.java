package chapter20;

import java.util.Scanner;
import java.util.Stack;

public class Phase1 {

	public static void main(String[] args) {
		// 算子
		Stack<Character> operatorStack = new Stack<>();
		// 操作数
		Stack<Double> operandStack = new Stack<>();
		
		
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		Scanner in = new Scanner(line);
		String nextValue = "";
		
		while (in.hasNext() || !nextValue.equals("")) {
			String value = "";
			if (nextValue.equals(""))
				value = in.next();
			else {
				value = nextValue;
				nextValue = "";
			}
			// 是一个 数值
			if (value.length() > 1 || value.charAt(0) >= 48 && value.charAt(0) <= 57) {
				operandStack.push(Double.valueOf(value));
			} 
			else {
				switch (value.charAt(0)) {
				case '+':
				case '-':
					if (!operatorStack.empty() && !operatorStack.peek().equals('(')) {
						pop1operator2operand(operatorStack, operandStack);
					}
					operatorStack.push(value.charAt(0));
					break;
				case '*':
				case '/':
					if (!operatorStack.empty() && 
							(operatorStack.peek().equals('*') || operatorStack.peek().equals('/')) ) {
						pop1operator2operand(operatorStack, operandStack);
					}
					operatorStack.push(value.charAt(0));
					break;
				case '(':
					operatorStack.push(value.charAt(0));
					break;
				case ')':
					
					while (operatorStack.peek() != '(') {
						pop1operator2operand(operatorStack, operandStack);
					}
					// (4)  
//					do {
//						
//					} while (!operatorStack.peek().equals('('));
					//!!! 去掉 （
					operatorStack.pop();
					break;
				default:
					throw new IllegalArgumentException("1 算子错误： " + value);
				}
			}
			
		}
		in.close();
		input.close();
		while (!operatorStack.empty()) {
			pop1operator2operand(operatorStack, operandStack);
		}
		System.out.println(operandStack.pop());
	}

	public static void pop1operator2operand(Stack<Character> operatorStack, Stack<Double> operandStack) {
		char op = operatorStack.pop();
		double n1 = operandStack.pop();
		double n2 = operandStack.pop();
		double result = calculate(n2, n1, op);
		operandStack.push(result);
	}

	private static double calculate(double n1, double n2, char op) {
		// TODO Auto-generated method stub
		switch (op) {
		case '+':
			return n1 + n2;
		case '-':
			return n1 - n2;
		case '*':
			return n1 * n2;
		case '/':
			return n1 / n2;
		default:
			throw new IllegalArgumentException("2 算子错误： " + op);
		}
	}
}
