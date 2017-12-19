package labii.trabGA;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		
		// Variaveis auxiliares
		final String DIR_ARQUIVOS = "C:\\Users\\Luis\\Desktop\\LuisValgoiTrabGA\\F1Temporada2013\\";
		final int QTD_PILOTOS = 22;
		final int QTD_ARQUIVOS = 19;
		int lastIdx = 0;

		// Variaveis necessarias
		File diretorio = new File(DIR_ARQUIVOS);				
		if(diretorio.isDirectory()){
			
			String[] files = diretorio.list();			
			Temporada2013 temporada = new Temporada2013(30);
			Prova[] provas = new Prova[QTD_ARQUIVOS];
			
			for (String file : files) {
				// Cria o arquivo de acordo com o nome
				File arquivoAtual = new File(DIR_ARQUIVOS + file);				

				// Cria a prova para cada arquivo lido
				Prova provaAtual = new Prova(QTD_PILOTOS);
				
				// Insere os pilotos na prova
				inserePilotosNaProvaAtual(arquivoAtual, provaAtual);
				
				// Insere os pilotos que pontuaram na temporada 2013
				inserePilotosQuePontuaramNaTemporada(arquivoAtual, temporada);
				
				// Incrementa o array que guarda todas as provas
				provas[lastIdx++] = provaAtual;				
			}
			
			Util.wr("Dados da classificação final\n");
			mostrarTelaClassificacaoFinalPorPontos(temporada);

			Util.wr("\nGerando o arquivo...");
			geracaoDoArquivo(temporada);
			
			Util.wr("\nGerando com sucesso!");
		}	
	}
	
	public static void inserePilotosNaProvaAtual(File arquivoAtual, Prova provaCurrente){
		try {

			FileReader fr = new FileReader(arquivoAtual);
			BufferedReader in = new BufferedReader(fr);
			
			String line = in.readLine();
			line = in.readLine();			
			while (line != null) {				
				String[] dados = buscaDadosDaLinha(line, ";");				
				provaCurrente.inserePilotos(new Piloto(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], Integer.parseInt(dados[6])));
				line = in.readLine();				
			}
			
			in.close();
			
		} catch (FileNotFoundException e) {
			Util.wr("Não foi encontrado o arquivo: " + e.toString());
		} catch (Exception e) {
			Util.wr("Ocorreu algum erro: " + e.toString());
		}
	}

	public static void inserePilotosQuePontuaramNaTemporada(File arquivoAtual, Temporada2013 temporada){
		try {
			
			FileReader fr = new FileReader(arquivoAtual);
			BufferedReader in = new BufferedReader(fr);
			
			String line = in.readLine();
			line = in.readLine();			
			while (line != null) {				
				String[] dados = buscaDadosDaLinha(line, ";");							
				temporada.inserePilotosQuePontuaram(dados[1], dados[2], Integer.parseInt(dados[6]));			
				line = in.readLine();
			}
			
			in.close();
			
		} catch (FileNotFoundException e) {
			Util.wr("Não foi encontrado o arquivo: " + e.toString());
		} catch (Exception e) {
			Util.wr("Ocorreu algum erro: " + e.toString());
		}
	}
	
	public static void mostrarTelaClassificacaoFinalPorPontos(Temporada2013 temporada){		
		temporada.classificaPorPonto(temporada.getPilotosQuePontuaram());
		for (Piloto p : temporada.getPilotosQuePontuaram()) {
			if(p != null)
				Util.wr(p.toStringClassificacao());
		}
	}
	
	public static void geracaoDoArquivo(Temporada2013 temporada){
		boolean continuar = false;
		do {
			try {
				Scanner teclado = new Scanner(System.in);
				
				Util.wr("\nATENÇÃO!! Por qual ordem você deseja ter seu arquivo: 'Nome' ou 'Pontos' ?");
				String escolha = teclado.nextLine();
				
				if(!escolha.equalsIgnoreCase("Nome") && !escolha.equalsIgnoreCase("Pontos"))
					throw new EscolhaOrdemResultadoFinalException();				
				
				if(escolha.equalsIgnoreCase("Nome"))
					temporada.classificaPorNome(temporada.getPilotosQuePontuaram());
				
				else if(escolha.equalsIgnoreCase("Pontos"))
					temporada.classificaPorPonto(temporada.getPilotosQuePontuaram());			
				
				temporada.registrarPilotosEmArquivo(temporada.getPilotosQuePontuaram());
				continuar = false;
				
			} catch (EscolhaOrdemResultadoFinalException e) {
				Util.wr("Ocorreu algum erro: "+ e.toString());
				continuar = true;
			} catch (InputMismatchException e) {
				Util.wr("Ocorreu algum erro: "+ e.toString());
				continuar = true;
			} catch (Exception e) {
				Util.wr("Ocorreu algum erro: "+ e.toString());
				continuar = true;
			}
		} while (continuar);
	}
	
	private static String[] buscaDadosDaLinha (String line, String pattern) {
		return line.split(pattern);
	} 

}
