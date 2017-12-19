package labii.exe02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio02 {

	/**
	 * Main da aplica��o
	 * @param args
	 */
	public static void main(String[] args) {

		// Matriz
		int[][] matriz = new int[4][4];

		// La�os
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {

				// Flag
				boolean seguir = false;

				// Valor pego do teclado
				int valor = 0;

				// La�o de repeti��o caso der erro
				do {
					try {
						Scanner t = new Scanner(System.in);
						System.out.println("Forneca o " + (j + 1) + "� valor de " + matriz[i].length + " colunas da " + (i + 1) + "� linha");
						valor = t.nextInt();
						seguir = true;
					} catch (NumberFormatException e) {
						System.out.println("**N�mero digitado errado, digite novamente!**");
						seguir = false;
					} catch (InputMismatchException e) {
						System.out.println("**N�mero digitado errado, digite novamente!**");
						seguir = false;
					} catch (Exception e) {
						System.out.println("**N�mero digitado errado, digite novamente!**");
						seguir = false;
					}	
				} while (!seguir);

				// Atribui��o
				matriz[i][j] = valor;				
			}
		}
		/////////////////////////////////////////////////////////////////
		
		// Impress�o 2
		exibeMatriz(matriz);		
		/////////////////////////////////////////////////////////////////
		
		//Impress�o 2.A
		int[] somaLinhas = somaLinhas(matriz);
		int[] somaColunas = somaColunas(matriz);
		
		System.out.println("\nA soma dos valores de cada linha � dado por: ");
		for (int i = 0; i < somaLinhas.length; i++) {
			System.out.print("Linha: " + (i + 1));
			System.out.print(" | Valor: " + somaLinhas[i]);
			System.out.println();
		}
		
		System.out.println("\nA soma dos valores de cada coluna � dado por: ");
		for (int i = 0; i < somaColunas.length; i++) {
			System.out.print("Coluna: " + (i + 1));
			System.out.print(" | Valor: " + somaColunas[i]);
			System.out.println();
		}		
		/////////////////////////////////////////////////////////////////		
		
		// Rotina 2.B
		int[][] matrizClone = new int[matriz.length][matriz[0].length];		
		System.arraycopy(matriz, 0, matrizClone, 0, matriz.length);
		
		int aux = 0;
		int j = matrizClone[0].length - 1;
		
		for(int i = 0; i < matrizClone[0].length;i++){
		    aux = matrizClone[i][i];
		    matrizClone[i][i] = matrizClone[i][j];
		    matrizClone[i][j] = aux;
		    j--;
		}		

		exibeMatriz(matriz);
		/////////////////////////////////////////////////////////////////		
		
		// Impress�o 2.C		
		int[] somaLinhasClone = somaLinhas(matrizClone);
		int[] somaColunasClone = somaColunas(matrizClone);
		
		System.out.println("\nA soma dos valores de cada linha � dado por: ");
		for (int i = 0; i < somaLinhasClone.length; i++) {
			System.out.print("Linha: " + (i + 1));
			System.out.print(" | Valor: " + somaLinhasClone[i]);
			System.out.println();
		}
		
		System.out.println("\nA soma dos valores de cada coluna � dado por: ");
		for (int i = 0; i < somaColunasClone.length; i++) {
			System.out.print("Coluna: " + (i + 1));
			System.out.print(" | Valor: " + somaColunasClone[i]);
			System.out.println();
		}		
		/////////////////////////////////////////////////////////////////
	}

	/**
	 * M�todo que exibe a matriz passada por parametro
	 * @param matriz
	 */
	public static void exibeMatriz(int matriz[][]){
		System.out.println("\nOs valores da matriz s�o: ");		
		for (int i = 0; i < matriz.length; i++){
			for (int j = 0; j < matriz[i].length; j++){
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * M�todo que retorna a soma de cada coluna da linha current da matriz passado como parametro
	 * @param matriz
	 * @return 
	 */
	public static int[] somaLinhas(int[][] matriz){
		int r[] = new int[matriz.length];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				r[i] += matriz[i][j];
			}
		}
		return r;
	}

	/**
	 * M�todo que retorna a soma de cada linha da coluna current da matriz passado como parametro
	 * @param matriz
	 * @return 
	 */
	public static int[] somaColunas(int[][] matriz){
		int r[] = new int[matriz[0].length];
		
		for (int j = 0; j < matriz[0].length; j++) {
			for (int i = 0; i < matriz.length; i++) {
				r[j] += matriz[i][j];
			}
		}
		return r;
	}
}
