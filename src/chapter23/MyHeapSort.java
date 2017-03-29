package chapter23;

import java.util.ArrayList;

public class MyHeapSort {
	public static void main(String[] args) {
		Integer[] list = {10, 9, 8, 7, 6, 4, 5 ,63, 124, 346};
		
		sort(list);
		for (int i = 0; i < list.length; i++)
			System.out.println(list[i]);
	}
	
	public static <E extends Comparable<E>> void sort(E[] list) {
		MyHeap<E> heap = new MyHeap<>();
		heap.add(list);
		
		for (int i = list.length - 1; i >= 0; i--) {
			list[i] = heap.remove();
		}
	}
}

class MyHeap <E extends Comparable<E>> {
	private java.util.ArrayList<E> list = new java.util.ArrayList<>();

	public MyHeap() {
	}
	
	public MyHeap(E[] arrays) {
		add(arrays);
	}

	public void add(E[] arrays) {
		for (int i = 0; i < arrays.length; i++) {
			add(arrays[i]);
		}
	}
	
	public void add(E e) {
		list.add(e);
		int currentIndex = list.size() - 1;
		
		while (currentIndex > 0) {
			int parentIndex = (currentIndex-1) / 2;
			if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
				swap(currentIndex, parentIndex);
			}
			else break;
			currentIndex = parentIndex;
		}
	}

	public E remove() {
		if (list.size() == 0) return null;
		
		E returnObject = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		
		int currentIndex = 0;
		while (currentIndex < list.size()) {
			int leftChildIndex = currentIndex*2 + 1;
			int rightChildIndex = currentIndex*2 + 2;
			// 判断左子数 是否出界
			if (leftChildIndex >= list.size())
				break;
			// 找到最大的子孩子
			int maxIndex = leftChildIndex;
			if (rightChildIndex < list.size()) {
				if (list.get(rightChildIndex).compareTo(list.get(leftChildIndex)) > 0) {
					maxIndex = rightChildIndex;
				}
			}
			// compare currentIndex object with maxIndex Object
			if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
				swap(currentIndex, maxIndex);
			}
			else
				break;
			currentIndex = maxIndex;
		}
		
		return returnObject; 
	}
	
	public int getSize() {
		return list.size();
	}
	
	// swap fir object with sec object
	private void swap(int firstIndex, int secondIndex) {
		// TODO Auto-generated method stub
		E temp = list.get(firstIndex);
		list.set(firstIndex, list.get(secondIndex));
		list.set(secondIndex, temp);
	}
}