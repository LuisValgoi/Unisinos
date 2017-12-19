package progii.sorting;

public class ManualSort {

	public static void manualSort(int m[]){
		int temp = 0;
		
		for (int i = 0; i < m.length; i++) {
			for (int j = i+1; j < m.length; j++) {
				if(m[i] > m[j]){
					temp = m[i];
					m[i] = m[j];
					m[j] = temp;
				}
			}
		}
	}

}
