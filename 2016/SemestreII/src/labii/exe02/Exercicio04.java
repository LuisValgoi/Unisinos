/*

Fazendo uso da matriz resultante do exercício 3, faça uma clonagem da 2ª linha
da matriz para um array de inteiros. Altere o valor do 3º elemento do array para
um novo valor e mostre as duas estruturas, o array e a matriz, demonstrando que
a alteração do valor do vetor não interferiu na matriz.

*/

package labii.exe02;

public class Exercicio04 {
	
	/**
	 * Main da aplicação
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Matriz Original
		int[][] matriz = {{1,2,3,4},{5,6,7,8},{9,9,0,0,1,1}};			
		exibeMatriz(matriz, "Os valores da matiz original s�o:");
		
		// Vetor Linha
		int[] vetorLinhaAlterada = new int[matriz[1].length];		
		for(int i = 1; i < 2; i++){
			for(int j = 0; j < matriz[i].length; j++){
				if(j == 2){
					vetorLinhaAlterada[j] = 99;					
				}else{
					vetorLinhaAlterada[j] = matriz[i][j];					
				}				
			}	
		}		
		System.out.println();
		exibeVetor(vetorLinhaAlterada, "Os valores do vetor com as altera��es:");
		
		// Matriz copiada
		int[][] matrizClone = new int[matriz.length][matriz[0].length];
		for (int i = 0; i < matriz.length; i++) {
			matrizClone[i] = new int[matriz[i].length];			
			for (int j = 0; j < matriz[i].length; j++) {
				if(j == 2 && i == 1){
					matrizClone[i][j] = 99;
				}else{
					matrizClone[i][j] = matriz[i][j];					
				}
			}
		}
		System.out.println("\n");
		exibeMatriz(matrizClone, "Os valores da matiz alterada s�o:");
	}
	
	/**
	 * Método que exibe a matriz passada por parametro
	 * @param matriz
	 */
	public static void exibeMatriz(int matriz[][], String texto){
		System.out.println(texto);		
		for (int i = 0; i < matriz.length; i++){
			for (int j = 0; j < matriz[i].length; j++){
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Método que exibe o array passado por parametro
	 * @param vetor
	 */
	public static void exibeVetor(int vetor[], String texto){
		System.out.println(texto);		
		for (int i = 0; i < vetor.length; i++){			
			System.out.print(vetor[i] + " ");
		}		
	}

}