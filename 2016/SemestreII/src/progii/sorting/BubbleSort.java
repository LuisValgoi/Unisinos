package progii.sorting;

import java.util.Arrays;

public class BubbleSort {
	
	public static void bubbleSort(int a[]) {
		for (int i = a.length - 1; i > 0; i--) { // nro. de varreduras
			boolean flipped = false;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) { // troca par de posicao
					int T = a[j];
					a[j] = a[j + 1];
					a[j + 1] = T;
					flipped = true;
				} // if
				System.out.println(Arrays.toString(a));
			} // for
			if (!flipped) return;
			System.out.println();
		} // for
	} // do metodo
	
}
