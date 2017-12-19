package labii.exe03;

import java.util.Arrays;
import java.util.Date;

public class MetodosOrdenacao {

	public double tempoInsertionSort;
	public double tempoBubbleSort;
	public double tempoSelectionSort;

	public void insertionSort(int a[]) {
		Date inicio = new Date();
		long iniLong = inicio.getTime();

		for (int i = 1; i < a.length; i++) {
			int j = i;
			int B = a[i];
			while ((j > 0) && (a[j - 1] > B)) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = B;
		}

		//System.out.println(Arrays.toString(a));
		Date fim = new Date();
		long fimLong = fim.getTime();
		long tempo = fimLong - iniLong;

		tempoInsertionSort = tempo;
	}

	public void insertionSort(int a[], int numTipoClassificacao){
		Date inicio = new Date();
		long iniLong = inicio.getTime();		

		// Crescente
		if(numTipoClassificacao == 1){			
			insertionSort(a);
		}

		// Decrescente
		if(numTipoClassificacao == 2){
			for (int i = 1; i < a.length; i++) {
				int j = i;
				int B = a[i];
				while ((j > 0) && (a[j - 1] < B)) {
					a[j] = a[j - 1];
					j--;
				}
				a[j] = B;				
			}
		}
		//System.out.println(Arrays.toString(a));
		Date fim = new Date();
		long fimLong = fim.getTime();
		long tempo = fimLong - iniLong;

		tempoInsertionSort = tempo;
	}

	public void bubbleSort(int a[]) {

		Date inicio = new Date();
		long iniLong = inicio.getTime();

		for (int i = a.length - 1; i > 0; i--) {
			boolean flipped = false;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					int T = a[j];
					a[j] = a[j + 1];
					a[j + 1] = T;
					flipped = true;
				}				
			}
			if (!flipped){
				//System.out.println(Arrays.toString(a));
				Date fim = new Date();
				long fimLong = fim.getTime();
				long tempo = fimLong - iniLong;

				tempoBubbleSort = tempo;				
				return;
			}
		}

		//System.out.println(Arrays.toString(a));
		Date fim = new Date();
		long fimLong = fim.getTime();
		long tempo = fimLong - iniLong;

		tempoBubbleSort = tempo;
	}

	public void bubbleSort(int a[], int numTipoClassificacao) {
		Date inicio = new Date();
		long iniLong = inicio.getTime();		

		// Crescente
		if(numTipoClassificacao == 1){
			bubbleSort(a);
		}

		// Decrescente
		if(numTipoClassificacao == 2){
			for (int i = a.length - 1; i > 0; i--) {
				boolean flipped = false;
				for (int j = 0; j < i; j++) {
					if (a[j] < a[j + 1]) {
						int T = a[j];
						a[j] = a[j + 1];
						a[j + 1] = T;
						flipped = true;
					}					
				}
				if (!flipped){
					//System.out.println(Arrays.toString(a));					
					Date fim = new Date();
					long fimLong = fim.getTime();
					long tempo = fimLong - iniLong;

					tempoBubbleSort = tempo;				
					return;
				}				
			}			
		}

		//System.out.println(Arrays.toString(a));
		Date fim = new Date();
		long fimLong = fim.getTime();
		long tempo = fimLong - iniLong;

		tempoBubbleSort = tempo;
	}

	public void selectionSort(int a[]) {

		Date inicio = new Date();
		long iniLong = inicio.getTime();

		int min = 0, ch;
		for (int i = 0; i < a.length - 1; i++) {
			min = i; // minimo inicial
			for (int j = i + 1; j < a.length; j++)
				if (a[j] < a[min])
					min = j; // acha o novo minimo
			ch = a[i];
			a[i] = a[min]; // coloca o novo minimo
			a[min] = ch; // na posicao correta
		}

		//System.out.println(Arrays.toString(a));		
		Date fim = new Date();
		long fimLong = fim.getTime();
		long tempo = fimLong - iniLong;

		tempoSelectionSort = tempo;
	}

	public void selectionSort(int a[], int numTipoClassificacao) {
		Date inicio = new Date();
		long iniLong = inicio.getTime();

		// Crescente
		if(numTipoClassificacao == 1){
			selectionSort(a);
		}

		// Decrescente
		if(numTipoClassificacao == 2){
			int max = 0;
			int ch = 0;

			for (int i = 0; i < a.length - 1; i++) {
				max = i;				
				for (int j = i + 1; j < a.length; j++){					
					if (a[j] > a[max]){
						max = j;	
					}					
				}
				
				ch = a[i];
				a[i] = a[max];
				a[max] = ch;
			}
		}

		//System.out.println(Arrays.toString(a));
		Date fim = new Date();
		long fimLong = fim.getTime();
		long tempo = fimLong - iniLong;

		tempoSelectionSort = tempo;		
	}
}
