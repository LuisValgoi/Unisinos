package labii.exe08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Exercicio04 {

	public static void main(String[] args) {
		ArrayIndexList<Integer> valores = lerDadosArquivo();

		System.out.println("Lista antes");
		for (int i = 0; i < valores.size(); i++)
			System.out.print(" - " + valores.get(i) + " - ");
		
		int x = 0;
		for (int i = 0; i < valores.size() -1; i++) {
			if((valores.get(i) % 2) != 0){				
				valores.remove(i - (++x));
			}
		}
		
		if(valores.isEmpty())
			Util.wr("A lista esta vazia");
		else{
			System.out.println("\nLista dps");
			for (int i = 0; i < valores.size(); i++)
				System.out.print(" - " + valores.get(i) + " - ");
		}
	}
	
	private static void removeImpares(ArrayIndexList<Integer> ail) {
		ArrayIndexList<Integer> indicesImpares = new ArrayIndexList<Integer>();
		int aux=0;
		
		for(int i=0;i<ail.size();i++){
			if(ail.get(i)%2!=0){
				indicesImpares.add(aux++, i);
			}
		}
		
		aux=0;
		for(int i= 0;i<indicesImpares.size();i++){
			ail.remove(indicesImpares.get(i)-aux++);
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
