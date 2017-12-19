package progii.matriz;
public class MatrizExibe {
	
	/**
	 * Método que exibe a matriz passada por parametro
	 * @param matriz
	 */
	public static void exibeMatriz(double matriz[][]){
		for (int i = 0; i < matriz.length; i++){
			for (int j=0; j < matriz[i].length; j++){
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
}
