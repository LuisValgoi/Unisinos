package labii.exe08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Exercicio03 {

	public static void main(String[] args) {
		ArrayIndexList<Integer> valores = lerDadosArquivo();

		List<Integer> valoresPares = new ArrayList<Integer>();
		List<Integer> idxPares = new ArrayList<Integer>();
		for (int i = 0; i < valores.size(); i++) {
			if(valores.get(i) % 2 == 0){
				valoresPares.add(valores.get(i));
				idxPares.add(i);
			}
		}
		
		if(valoresPares.isEmpty())
			Util.wr("Nao contem nenhum valor par");
		else{
			System.out.println("\nLista valores pares");
			for (int i = 0; i < valoresPares.size(); i++)
				System.out.print(" - " + valoresPares.get(i) + " - ");	
		}			

	}

	private static ArrayIndexList<Integer> lerDadosArquivo(){
		ArrayIndexList<Integer> numeros = new ArrayIndexList<Integer>();

		boolean prosseguir = true;
		do {			
			try {
				String nomeArquivo = "novaLista.txt";			

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
}
