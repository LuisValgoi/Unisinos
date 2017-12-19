package labii.exe10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		// pego do arquivo
		ArrayIndexList<Terreno> terrenos = retornaTerrenosDoArquivo();

		// gravo no arquivo
		gravaTerrenosEmArquivo(terrenos);

		// mostra na tela
		tributos(terrenos);
	}

	private static ArrayIndexList<Terreno> retornaTerrenosDoArquivo(){
		File file = new File("terrenos.txt");

		ArrayList<Terreno> aux = new ArrayList<Terreno>();		
		try {
			FileReader fr = new FileReader("terrenos.txt");
			BufferedReader in = new BufferedReader(fr);

			String line = in.readLine();
			line = in.readLine();
			while (line != null)
			{		
				String[] linha = buscaDadosDaLinha(line, "#");
				aux.add(new Terreno(linha[0], linha[1], linha[2], linha[3], Double.parseDouble(linha[4]), Double.parseDouble(linha[5])));
				line = in.readLine();
			}

			in.close ();
		} catch (IOException e) {
			Util.wr("Erro na leitura do arquivo "+ file);
		}		

		ArrayIndexList<Terreno> response = new ArrayIndexList<Terreno>(aux.size());
		int i = 0;
		for (Terreno terreno : aux)
			response.add(i++, terreno);

		return response;		
	}

	private static void gravaTerrenosEmArquivo(ArrayIndexList<Terreno> terrenos){
		try {

			File file = new File("AreaTerrenos.txt.txt");
			FileWriter fr = new FileWriter(file);
			PrintWriter out = new PrintWriter(fr);	

			out.write("Área – bairro – quadra – lote – rua\n");
			for (int i = 0; i < terrenos.size(); i++) {				
				double area = terrenos.get(i).calculaArea();
				String bairro = terrenos.get(i).getBairro();
				String quadra = terrenos.get(i).getQuadra();
				String lote = terrenos.get(i).getLote();
				String rua = terrenos.get(i).getRua();

				out.write(area + " - " + bairro + " - " + quadra + " - " + lote + " - " + rua + "\n");
			}

			out.close();

		} catch (FileNotFoundException e) {
			Util.wr("Arquivo não encontado: " + e.toString());	
		} catch (Exception e) {
			Util.wr("Ocorreu um erro: " + e.toString());
		}		
	}

	private static void tributos(ArrayIndexList<Terreno> terrenos){
		Queue<String> fila = new ArrayQueue<String>(10);
		Stack<String> pilha = new ArrayStack<String>(7);		

		int contOverflowFila = 0;
		int contOverflowPilha = 0;
		for (int i = 0; i < terrenos.size(); i++) {			
			double area = terrenos.get(i).calculaArea();

			if (area < 1000.00){
				try {
					fila.enqueue(terrenos.get(i).getLote());
				} catch (FullQueueException e) {
					contOverflowFila++;
				} catch (Exception e) {
					contOverflowFila++;
				}
			}
			else if (area >= 1000.00 && area <= 3000.00){
				try {
					pilha.push(terrenos.get(i).getLote());
				} catch (FullStackException e) {
					contOverflowPilha++;
				} catch (Exception e) {
					contOverflowPilha++;
				}
			}
		}

		if(contOverflowFila > 0)
			Util.wr("Ocorreram " + contOverflowFila + " overflows de fila");		
		
		if(contOverflowPilha > 0)
			Util.wr("Ocorreram " + contOverflowPilha + " overflows de pilha");		
		
		Util.wr("\nEstes são os Lotes de terrenos não tributáveis:");
		Util.wr(fila.toString());
		
		Util.wr("Estes são os Lotes de terrenos estão sujeitos à tributação:");
		Util.wr(pilha.toString());
	}

	private static String[] buscaDadosDaLinha (String line, String pattern) {
		return line.split(pattern);
	}

}
