package progii.matriz;

import java.util.Arrays;

public class MatrizSomaLinhas {
	
	public static void main(String[] args) {
		int[][] abc = {{1,2,3},{4,5,6}};
		int[] soma = somaColunas(abc);
		
		System.out.println(Arrays.toString(soma));
	}
	
	/**
	 * Método que retorna a soma de cada linha da coluna current da matriz passado como parametro
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
