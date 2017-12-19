package labii.exe05;

import java.io.*;

public class Main {
	
	static String filePath = "E:\\All\\Workspace\\Projects\\Java\\Semestre02\\Exercicio05\\files\\";
	static int qtdPilotos = 22;
	
	public static void main(String[] args){	
		try {
			
			// Abre e configura o arquivo			
			FileReader fr = new FileReader(filePath + "F1Italia2016.txt");
			BufferedReader in = new BufferedReader(fr);
			
			ProvaItalia prova = new ProvaItalia(qtdPilotos);
			boolean isCabecalho = true;
			String line = in.readLine();			
			while (line != null) {
				
				// Verifica se a linha é cabecalho
				if(isCabecalho){
					isCabecalho = false;
					line = in.readLine();
					continue;
				}

				// Operações								
				String[] dadosLinhaAtual = buscaPalavrasEmUmaLinha(line, "#");				
				prova.inserePilotos(new Piloto(dadosLinhaAtual[0], dadosLinhaAtual[1], dadosLinhaAtual[2], dadosLinhaAtual[3], dadosLinhaAtual[4], Integer.parseInt(dadosLinhaAtual[5])));			
				
				// No fim, segue a próxima linha
				line = in.readLine();				
			}			
			// Fecha a abertura do arquivo
			in.close();	
			
			
			// Exibicao
			wr("Ordem Original");
			prova.exibePilotos();
			escreverNoArquivo(prova, "F1Italia2016OrdemOriginal.txt");
			
			wr("\nOrdem Alfabética");
			prova.ordenaPorOrdemAlfabetica();			
			prova.exibePilotos();
			escreverNoArquivo(prova, "F1Italia2016OrdemAlfabetica.txt");
			
			wr("\nOrdem Pontuação");
			prova.ordenaPorPontos();			
			prova.exibePilotos();
			escreverNoArquivo(prova, "F1Italia2016OrdemPontuacao.txt");

			wr("------------------------------------------------------");
			wr("Se chegou até aqui bombou!!");
			wr("Arquivos gerados com sucesso!!!");
			wr("Segue o caminho: " + filePath);
			wr("------------------------------------------------------");
			
		} catch (FileNotFoundException e) {
			wr("Ops. Arquivo \"" + filePath + "\" não existe.");
		} catch (IOException e) {
			wr("Ops. Erro na leitura do arquivo " + filePath + ".");
		} catch (Exception e) {			
			wr("Ops. Ocorreu o seguinte erro: " +e.toString() + ".");
		}		
	}	
	
	public static void escreverNoArquivo(ProvaItalia prova, String fileName){
		try {

			// Abre e configura arquivo
			File f = new File (filePath + fileName);
			FileWriter fr = new FileWriter (f);
			PrintWriter out = new PrintWriter (fr);			
			
			// Operacoes
			for (Piloto p: prova.getPilotos()) {
				if(p != null){
					String lineCustom = p.getNomePiloto() + " - " + p.getNomeEquipe() +" - " + p.getPontosObtidos();
					out.println(lineCustom);
				}
			}
			
			// Fecha abertura do arquivo
			out.close();			
			
		} catch (IOException e) {
			System.out.println ("Erro ao escrever arquivo.");
		} catch (Exception e) {			
			wr("Ops. Ocorreu o seguinte erro: " +e.toString() + ".");
		}	
	}
		
	public static void wr(String v){
		System.out.println(v);
	}

	public static String[] buscaPalavrasEmUmaLinha (String line, String pattern) {
		return line.split(pattern);
	} 
}
