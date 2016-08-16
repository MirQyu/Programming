package chapter10;

public class StackOfIntegers {
	private int[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY = 16;
	
	/**
	 * Construct a stack with the default capacity 16
	 */
	public StackOfIntegers() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Construct a stack with the specified maximum capacity
	 * @param capacity specified
	 */
	public StackOfIntegers(int capacity) {
		elements = new int[capacity];
	}
	
	/**
	 * Push a new integer to the top of the stack
	 * @param value
	 */
	public void push(int value) {
		if (size >= elements.length) {
			int[] temp = new int[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}
		
		elements[size++] = value;
	}
	
	/**
	 * @return Return and remove the top element from the stack 
	 */
	public int pop() {
		return elements[--size];
	}
	
	public int peek() {
		return elements[size-1];
	}
	
	public boolean empty() {
		return size == 0;
	}
	
	public int getSize() {
		return size;
	}
}
