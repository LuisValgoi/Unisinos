package progii.matriz;
public class MatrizSomaColunas {
	
	/**
	 * Método que retorna a soma de cada coluna da linha current da matriz passado como parametro
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
}
