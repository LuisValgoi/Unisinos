package labii.exe02;

public class Exercicio03 {

	/**
	 * Main da aplicação
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matriz = {{1,2,3,4},{5,6,7,8},{9,9,0,0,1,1}};

		// Exibição da matriz original
		exibeMatriz(matriz);

		//////////////////////////////////////////////////////////
		System.out.println("\nDepois das operações do arraycopy...\n");
		//////////////////////////////////////////////////////////

		int[][] matrizClone = new int[matriz.length][matriz[0].length];
		for (int i = 0; i < matriz.length; i++) {
			if(i == (matriz.length - 1)){
				matrizClone[i] = new int[7];
			}else{
				matrizClone[i] = new int[matriz[i].length];	
			}			
		}
		
		for (int i = 0; i < matrizClone.length; i++) {
			if(i == 2) {
				System.arraycopy(matriz[i], 0, matrizClone[i], 0, 3);
				System.arraycopy(matriz[0], 0, matrizClone[i], 3, 4);	
			}else{
				System.arraycopy(matriz[i], 0, matrizClone[i], 0, matriz[i].length);
			}
		}

		// Exibição da matriz clone
		exibeMatriz(matrizClone);
	}

	/**
	 * Método que exibe a matriz passada por parametro
	 * @param matriz
	 */
	public static void exibeMatriz(int matriz[][]){
		System.out.println("Os valores da matriz são: ");		
		for (int i = 0; i < matriz.length; i++){
			for (int j = 0; j < matriz[i].length; j++){
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
}
