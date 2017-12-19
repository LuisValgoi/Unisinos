package labii.exe08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Exercicio01 {
	
	public static void main(String[] args) {
		ArrayIndexList<Integer> vinteNumeros = lerDadosArquivo();
		
		int maxPosition = 0;
		int maxValue = vinteNumeros.get(0);		
		for (int i = 0; i < vinteNumeros.size(); i++) {
			for (int j = i + 1; j < vinteNumeros.size(); j++) {
				if(vinteNumeros.get(i) < vinteNumeros.get(j) && vinteNumeros.get(j) > maxValue){
					maxValue = vinteNumeros.get(j);
					maxPosition = j;
				}					
			}
		}		

		int minPosition = 0;
		int minValue = vinteNumeros.get(0);
		for (int i = 0; i < vinteNumeros.size(); i++) {
			for (int j = i + 1; j < vinteNumeros.size(); j++) {
				int vi = vinteNumeros.get(i);
				int vj = vinteNumeros.get(j);
				if(vi < vj && vi < minValue){
					minValue = vi;
					minPosition = i;
				}					
			}
		}
		
		System.out.println("O menor valor é: " + minValue + " e sua posicao é: " + minPosition);
		System.out.println("O maior valor é: " + maxValue + " e sua posicao é: " + maxPosition);		
	}
	
	private static ArrayIndexList<Integer> lerDadosArquivo(){
		ArrayIndexList<Integer> numeros = new ArrayIndexList<Integer>();

		boolean prosseguir = true;
		do {			
			try {			
				Scanner teclado = new Scanner(System.in);

				System.out.println("Digite o nome do arquivo");
				String nomeArquivo = teclado.nextLine();			

				File file = new File(nomeArquivo);			
				FileReader fr = new FileReader(file);
				BufferedReader in = new BufferedReader(fr);			

				String line = ""; 
				for (int i = 0; i < 20; i++) {
					line = in.readLine();
					numeros.add(i, Integer.parseInt(line));			
				}

				in.close();
				prosseguir = true;

			} catch (FileNotFoundException e) {
				prosseguir = false;
				System.out.println("Não foi encontrado o arquivo com este nome: " + e.toString());
			} catch (Exception e) {
				prosseguir = false;
				System.out.println("Ocorreu algum erro: " + e.toString());
			}			
		} while (!prosseguir);	

		return numeros;
	}

}
