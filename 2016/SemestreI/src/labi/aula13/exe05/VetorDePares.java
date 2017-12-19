package labi.aula13.exe05;

import labi.aula13.exe02.Helpers;

public class VetorDePares {
	private int[] array;
	
	public VetorDePares(){
		this.array = new int[10];
	}
	
	public VetorDePares(int tamanhoArray){
		this.array = new int[tamanhoArray];
	}
	
	public void geraVetor(){
		int count = 0;		
		
		for (int i = 2; count < getVetor().length; i = i + 2){			
			this.array[count] = i;
			count++;
		}
	}
	
	public void exibeVetor(){
		for (int i : getVetor()) {
			Helpers.wr("O valor é: " + i);
		}
	}

	public int[] getVetor(){
		return this.array;
	}	
}
