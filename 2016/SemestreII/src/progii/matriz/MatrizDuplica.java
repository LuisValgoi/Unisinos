package progii.matriz;
public class MatrizDuplica {	
	
	/**
	 * Este metodo recebe uma matriz e retorna outra matriz com as mesmas dimensoes da matriz
	 * de entrada e com o conteœdo duplicado.
	 *  
	 * @param matriz - matriz de entrada
	 * @return
	 */	
	public static double[][] duplicaMatriz(double matriz[][]){

		double matrizRetorno[][] = new double[matriz.length][];		
		
		for(int i = 0; i < matriz.length; i++){			
			matrizRetorno[i] = new double[matriz[i].length];
			
			for(int j = 0; j < matriz[i].length; j++){				
				matrizRetorno[i][j] = matriz[i][j] * 2.0;
			}
		}
		
		return matrizRetorno;
	}
}
