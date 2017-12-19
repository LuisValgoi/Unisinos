package progii.matriz;
public class MatrizMaiorMenor {

	/**
	 * Método que retorna o maior e menor elemento de uma matriz recebida por parametro
	 * @param matriz
	 * @return
	 */
	public static int[] retornaMaiorMenor(int matriz[][]){
		int r[] = new int[2];
		int maior = matriz[0][0];
		int menor = matriz[0][0];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] > maior)					
					maior = matriz[i][j];
				
				if(matriz[i][j] < menor)
					menor = matriz[i][j];
			}
		}
		r[0] = menor;
		r[1] = maior;
		return r;
	}		
}
