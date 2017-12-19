package progii.sorting;

import java.util.Arrays;

public class InsertionSort {
	
	public static void insertionSort(int a[]) {
		for (int i = 1; i < a.length; i++) {
			int j = i; // pos do 1o elemento no seg. nao ord.
			int B = a[i]; // 1o elemento no seg. nao ord.
			while ((j > 0) && (a[j - 1] > B)) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = B;
			System.out.println(Arrays.toString(a));
		}
	} // do metodo
}
