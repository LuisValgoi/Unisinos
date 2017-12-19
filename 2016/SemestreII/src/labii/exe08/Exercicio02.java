package labii.exe08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercicio02 {
	
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
		
		System.out.println("Lista antes");
		for (int i = 0; i < vinteNumeros.size(); i++)
			System.out.print(" - " + vinteNumeros.get(i) + " - ");
		
		vinteNumeros.add(maxPosition, minValue);
		vinteNumeros.add(minPosition, maxValue);
		
		System.out.println("\nLista antes");
		for (int i = 0; i < vinteNumeros.size(); i++)
			System.out.print(" - " + vinteNumeros.get(i) + " - ");	
		
		gravarEmArquivo(vinteNumeros);
		Util.wr("gravado os 20 registros com sucesso");
	}

	private static ArrayIndexList<Integer> lerDadosArquivo(){
		ArrayIndexList<Integer> numeros = new ArrayIndexList<Integer>();

		boolean prosseguir = true;
		do {			
			try {			
				Scanner teclado = new Scanner(System.in);

				Util.wr("Digite o nome do arquivo");
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
				Util.wr("Não foi encontrado o arquivo com este nome: " + e.toString());
			} catch (Exception e) {
				prosseguir = false;
				Util.wr("Ocorreu algum erro: " + e.toString());
			}			
		} while (!prosseguir);	

		return numeros;
	}

	public static void gravarEmArquivo(ArrayIndexList<Integer> vinteNumeros){
		try {

			File file = new File("novaLista.txt");
			FileWriter fr = new FileWriter(file);
			PrintWriter out = new PrintWriter(fr);	
			
			for (int i = 0; i < vinteNumeros.size(); i++) {
				out.write(vinteNumeros.get(i) + "\n");
			}
			
			out.close();
			
		} catch (FileNotFoundException e) {
			Util.wr("Arquivo não encontado: " + e.toString());	
		} catch (Exception e) {
			Util.wr("Ocorreu um erro: " + e.toString());
		}		
	}
	
}
