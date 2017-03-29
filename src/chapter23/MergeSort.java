package chapter23;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MergeSort {
	
	
	
	/** The method for sorting the numbers
	 */
	@SuppressWarnings("unchecked")
	public static <E extends Comparable<E>> void mergeSort(E[] list) {
		if (list.length > 1) {
			// Merge sort the first half
			int firstHalfLength = list.length / 2;
			E[] firstHalf = (E[])new Comparable[firstHalfLength];
			System.arraycopy(list, 0, firstHalf, 0, firstHalfLength);
			mergeSort(firstHalf);
			
			// Merge sort the second half
			int secondHalfLength = list.length - firstHalfLength;
			E[] secondHalf = (E[])new Comparable[secondHalfLength];
			System.arraycopy(list, firstHalfLength, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);
			
			// Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list);
			
		}
	}
	
	private static <E extends Comparable<E>> void merge(E[] firstHalf, E[] secondHalf, E[] temp) {
		int current1 = 0;	// Current index in firstHalf
		int current2 = 0;
		int current3 = 0;	// Current index in temp
		
		while (current1 < firstHalf.length && current2 < secondHalf.length) {
			if (firstHalf[current1].compareTo(secondHalf[current2]) < 0) {
				temp[current3++] = firstHalf[current1++];
			} else {
				temp[current3++] = secondHalf[current2++];
			}
		}
		
		while (current1 < firstHalf.length) {
			temp[current3++] = firstHalf[current1++];
		}
		
		while (current2 < secondHalf.length) {
			temp[current3++] = secondHalf[current2++];
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		
		Integer[] list = new Integer[random.nextInt(1000)];
		for (int i = 0; i < list.length; i++) {
			list[i] = random.nextInt(10000);
		}
		
//		int[] list = {2, 3, -14, -12};
		mergeSort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}
	
}
