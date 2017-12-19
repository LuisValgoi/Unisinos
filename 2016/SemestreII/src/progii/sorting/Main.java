package progii.sorting;

public class Main {

	public static void main(String[] args) {

		int v[] = { 10, 9, 7, 21, 22, 20, 45, 44, 19, 11, 2, 43 };
		System.out.println("Insertion Sort");
		InsertionSort.insertionSort(v);

		int v2[] = { 7, 10, 1, 2, 20, 13, 9, 17 };
		System.out.println("Selection Sort");
		SelectionSort.selectionSort(v2);

		int v3[] = {1, 8, 10, 7, 9, 12, 10};
		System.out.println("Bubble Sort");
		BubbleSort.bubbleSort(v3);		

		int v4[] = {1, 8, 10, 7, 9, 12, 10};
		System.out.println("Manual Sort");
		ManualSort.manualSort(v4);

	}

}
