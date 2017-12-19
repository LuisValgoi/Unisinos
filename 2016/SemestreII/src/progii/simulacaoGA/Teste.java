package progii.simulacaoGA;

import java.util.ArrayList;
import java.util.List;

public class Teste {

	public static void main(String[] args) {

		List<Integer> list =  new ArrayList<Integer>();
		
		int[][] matrix = {{1,2,3}, 
						  {4,5,6}, 
						  {7,8,9}};
		
		buildListFromMatrix(list, matrix);
		
		System.out.println(list.toString());
		
	}		

	public static void buildListFromMatrix(List<Integer> list, int matrix[][]){	
		int firstIdxInserted = 0;
		int lastIdxInserted = list.size() + firstIdxInserted;
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				int v = matrix[i][j];
				if(v % 2 == 0)
					list.add(firstIdxInserted++, v);
				else
					list.add(lastIdxInserted++, v);				
			}		
		}
	}
	
}
