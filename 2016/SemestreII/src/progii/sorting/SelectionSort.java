package progii.sorting;

import java.util.Arrays;

public class SelectionSort {
	
	public static void selectionSort(int a[]) {
		int min = 0, ch;
		for (int i = 0; i < a.length - 1; i++) {
			min = i; // minimo inicial
			for (int j = i + 1; j < a.length; j++)
				if (a[j] < a[min])
					min = j; // acha o novo minimo
			ch = a[i];
			a[i] = a[min]; // coloca o novo minimo
			a[min] = ch; // na posicao correta
			System.out.println(Arrays.toString(a));
		}
	}
	
}
