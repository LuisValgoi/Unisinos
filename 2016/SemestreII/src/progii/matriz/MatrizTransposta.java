package progii.matriz;
public class MatrizTransposta {
	
	/**
	 * Método que retorna a matriz transposta da matriz passada por parametro
	 * @param matriz
	 * @return
	 */
	public static int[][] matrizTransposta(int[][] matriz){
		int[][] transposta = new int[matriz[0].length][matriz.length];

		for(int l = 0; l < matriz.length; l++){
			for(int c = 0; c < matriz[l].length; c++){			
				if(c > l){
					transposta[c][l] = matriz[l][c];
				}else if(c == l){
					transposta[l][c] = matriz[l][c];
				}else if(c < l){
					transposta[c][l] = matriz[l][c];
				}
			}
		}
		return transposta;
	}
}