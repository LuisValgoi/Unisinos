package progii.recursividade;

import java.util.Arrays;

public class PesquisaBinaria {

	public static void main(String[] args) {
		int[] a = new int[5000];

		for (int i = 0; i < a.length; i++) {
			int numeroRandomico = 1 + (int)(Math.random() * 100);
			a[i] = numeroRandomico;
		}
		System.out.println(Arrays.toString(a));
		int passos = passosEncontrarValor(a, 10);
		int passosR = passosEncontrarValorRecursivamente(a, 10);
		System.out.println(passosR + "e" + passos);
	}

	// Método de Busca Binária de valor
	public static int passosEncontrarValor(int[] arrayOrdenado, int valor){
		int sup = arrayOrdenado.length -1;
		int min = 0;
		int med = 0;
		int passos = 1;

		while (min <= sup) {
			med = (sup + min) / 2;

			if(valor == arrayOrdenado[med]){
				return passos;
			}
			else if(valor > arrayOrdenado[med]){
				min = med + 1;
				passos++;
			}
			else if(valor < arrayOrdenado[med]){
				sup = med - 1;
				passos++;
			}
		}

		return passos;
	}	

	// Método de Busca Binária Recursiva de valor
	public static int passosEncontrarValorRecursivamente(int[] arrayOrdenado, int valor){
		int min = 0;
		int sup = arrayOrdenado.length -1;

		return passosEncontrarValorRecursivamente(arrayOrdenado, valor, min, sup);
	}

	private static int passosEncontrarValorRecursivamente(int[] arrayOrdenado, int valor, int min, int sup){
		if (min > sup){
			return -1;
		}
		
		int med = (min + sup) / 2;		
		if (valor == arrayOrdenado[med])
			return med;
		else if (valor < arrayOrdenado[med])
			return passosEncontrarValorRecursivamente(arrayOrdenado, valor, min, med - 1);
		else
			return passosEncontrarValorRecursivamente(arrayOrdenado, valor, med + 1, sup);		
	}

}
