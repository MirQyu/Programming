package chapter11;

public class Test {
	public static void main(String[] args) {
		double t = 2.0 / 0;
		System.out.println(t);
	}
}

class C {
	public static void print() {
		System.out.println("this is inside the base class");
	}
}

class B extends C{
	
}

class A extends B {
}

