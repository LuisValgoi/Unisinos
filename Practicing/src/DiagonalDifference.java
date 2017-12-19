/*
 * Complexity: O(n�)
 */

public class DiagonalDifference {
	public static void main(String[] args) {
		int[][] matrix = {{11,12,13}, 
						  {21,22,23}, 
						  {39,38,37}};
		int response = getDiagonalsDifferences(matrix);
		System.out.println(response);
	}
	
	private static int getDiagonalsDifferences(int matrix[][]){
		int sumNormalDiagonal = 0;
		int sumInvertedDiagonal = 0;
		
		for(int row = 0; row < matrix.length; row++){			
			for(int col = 0; col < matrix[row].length; col++){
				if(row == col){
					sumNormalDiagonal += matrix[row][col];
				}
				
				if((row + col) == (matrix[row].length - 1)){
					sumInvertedDiagonal += matrix[row][col];
				}
			}
		}
		
		if(sumNormalDiagonal > sumNormalDiagonal){
			return sumNormalDiagonal - sumInvertedDiagonal;
		}else{
			return sumInvertedDiagonal - sumNormalDiagonal;	
		}		
	}
}