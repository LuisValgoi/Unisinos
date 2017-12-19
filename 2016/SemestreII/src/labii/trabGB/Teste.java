package labii.trabGB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

import labii.trabGB.estruturas.ArrayQueue;

public class Teste {

	// main
	public static void main(String[] args) {
		Relatorio[] relatorioMensal = new Relatorio[22];

		// lop mes
		for (int i = 0; i < 22; i++) {

			// configs
			relatorioMensal[i] = new Relatorio(i + 1);
			ArrayQueue<Ficha> filaGeral = geraFila();
			Cadeiras filasEspecificas = new Cadeiras();

			// laco que vai atender at� as filas geral esvaziar (vai sobrar um pouco nas especificas)
			do {
				// preencher cadeiras at� alguma cadeira estiver lotada
				filasEspecificas.preencheCadeiras(filaGeral);

				// vai atender paralelamente
				filasEspecificas.atende(filaGeral, relatorioMensal[i]);					

			} while (!filaGeral.isEmpty());

			// finalizo aqui os que sobraram
			while (!filasEspecificas.isCadeirasVazias()) {
				filasEspecificas.atende(filaGeral, relatorioMensal[i]);
			}
		}

		geraArquivo(relatorioMensal);
	}

	// m publicos
	public static ArrayQueue<Ficha> geraFila(){
		// config	
		int tamanhoFila = 600 + (int)(Math.random() * (801 - 600));

		// criacao da fila com as pessoas para retorno
		ArrayQueue<Ficha> filaPessoas = new ArrayQueue<Ficha>(tamanhoFila);

		// loop
		int numero = 1;
		while(filaPessoas.size() < tamanhoFila){
			Ficha ficha = geraFichaPessoa(numero++);
			filaPessoas.enqueue(ficha);
		}

		return filaPessoas;
	}

	public static void geraArquivo(Relatorio[] relatorioMensal){
		System.out.println("\nRegistrando...");

		try {
			File file = new File("volumeAtd_Mes.txt");
			FileWriter fr = new FileWriter(file);
			PrintWriter out = new PrintWriter(fr);

			int totalAtendimentos = 0;

			int totalAtendimentoServicoA = 0;
			int totalAtendimentoServicoB = 0;
			int totalAtendimentoServicoC = 0;

			int totalAtendimentoPRServicoA = 0;
			int totalAtendimentoPRServicoB = 0;
			int totalAtendimentoPRServicoC = 0;


			int diaMaiorDemandaServicoA = 0;
			int maiorDemandaServicoA = 0;

			int diaMaiorDemandaServicoB = 0;
			int maiorDemandaServicoB = 0;

			int diaMaiorDemandaServicoC = 0;
			int maiorDemandaServicoC = 0;

			for (Relatorio r : relatorioMensal) {
				totalAtendimentos += r.getTotalAntedimentos();

				totalAtendimentoServicoA += r.getTotalAtendimentoServicoA();
				totalAtendimentoServicoB += r.getTotalAtendimentoServicoB();
				totalAtendimentoServicoC += r.getTotalAtendimentoServicoC();

				totalAtendimentoPRServicoA += r.getTotalAtendimentoPRServicoA();
				totalAtendimentoPRServicoB += r.getTotalAtendimentoPRServicoB();
				totalAtendimentoPRServicoC += r.getTotalAtendimentoPRServicoC();

				if(maiorDemandaServicoA < r.getTotalAtendimentoServicoA()){
					maiorDemandaServicoA = r.getTotalAtendimentoServicoA();
					diaMaiorDemandaServicoA = r.getDia();				
				}
				if(maiorDemandaServicoB < r.getTotalAtendimentoServicoB()){
					maiorDemandaServicoB = r.getTotalAtendimentoServicoB();
					diaMaiorDemandaServicoB = r.getDia();					
				}
				if(maiorDemandaServicoC < r.getTotalAtendimentoServicoC()){
					maiorDemandaServicoC = r.getTotalAtendimentoServicoC();
					diaMaiorDemandaServicoC = r.getDia();					
				}
			}

			out.write("Relat�rio Mensal de fluxo de atendimentos");

			out.write("\r\n\r\nTotal de atendimentos: " + totalAtendimentos);

			out.write("\r\n\r\nQuantidade de atendimentos por servi�o::" + "\r\n");
			out.write("Servi�o: IPTU, Total: " + totalAtendimentoServicoA + "\r\n");
			out.write("Servi�o: Protocolo, Total: " + totalAtendimentoServicoB + "\r\n");
			out.write("Servi�o: Sa�de, Total: " + totalAtendimentoServicoC);			

			out.write("\r\n\r\nQuantidade de atendimentos priorit�rios por servi�o::" + "\r\n");
			out.write("Servi�o: IPTU, Total: " + totalAtendimentoPRServicoA + "\r\n");
			out.write("Servi�o: Protocolo, Total: " + totalAtendimentoPRServicoB + "\r\n");
			out.write("Servi�o: Sa�de, Total: " + totalAtendimentoPRServicoC);

			out.write("\r\n\r\nDias com maior demanda de cada servi�o::" + "\r\n");
			out.write("Servi�o: IPTU, Dia: " + diaMaiorDemandaServicoA + ". Qtd: " + maiorDemandaServicoA + "\r\n");
			out.write("Servi�o: Protocolo, Dia: " + diaMaiorDemandaServicoB + ". Qtd: " + maiorDemandaServicoB + "\r\n");
			out.write("Servi�o: Sa�de, Dia: " + diaMaiorDemandaServicoC + ". Qtd: " + maiorDemandaServicoC);

			if(totalAtendimentoServicoA > totalAtendimentoServicoB && totalAtendimentoServicoA > totalAtendimentoServicoC){
				out.write("\r\n\r\nServi�o com maior demanda: IPTU");
				out.write("\r\nQtd atendimentos: " + totalAtendimentoServicoA);	
			}
			else if(totalAtendimentoServicoB > totalAtendimentoServicoA && totalAtendimentoServicoB > totalAtendimentoServicoC){
				out.write("\r\n\r\nServi�o com maior demanda: Protocolo");
				out.write("\r\nQtd atendimentos: " + totalAtendimentoServicoB);
			}
			else if(totalAtendimentoServicoC > totalAtendimentoServicoA && totalAtendimentoServicoC > totalAtendimentoServicoB){
				out.write("\r\n\r\nServi�o com maior demanda: Sa�de");
				out.write("\r\nQtd atendimentos: " + totalAtendimentoServicoC);
			}
			
			if(totalAtendimentoServicoA < totalAtendimentoServicoB && totalAtendimentoServicoA < totalAtendimentoServicoC){
				out.write("\r\n\r\nServi�o com menor demanda: IPTU");
				out.write("\r\nQtd atendimentos: " + totalAtendimentoServicoA);	
			}
			else if(totalAtendimentoServicoB < totalAtendimentoServicoA && totalAtendimentoServicoB < totalAtendimentoServicoC){
				out.write("\r\n\r\nServi�o com menor demanda: Protocolo");
				out.write("\r\nQtd atendimentos: " + totalAtendimentoServicoB);
			}
			else if(totalAtendimentoServicoC < totalAtendimentoServicoA && totalAtendimentoServicoC < totalAtendimentoServicoB){
				out.write("\r\n\r\nServi�o com menor demanda: Sa�de");
				out.write("\r\nQtd atendimentos: " + totalAtendimentoServicoC);
			}
			
			out.close();

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo n�o encontado: " + e.toString());	
		} catch (Exception e) {
			System.out.println("Ocorreu um erro: " + e.toString());
		}

		System.out.println("Gerado com sucesso");
	}

	// m privados
	private static Ficha geraFichaPessoa(int numero){
		// geracao da variavel que indica se ele � prioritario ou nao
		Boolean isPrioritario = ((int)(Math.random() * (5)) + 1) == 1 ? true : false;

		// geracao do servico
		String designacao = geraDesignacao();

		// criacao da ficha para a pessoa
		Ficha pessoa = new Ficha(numero, isPrioritario, designacao); 

		return pessoa;
	}

	private static String geraDesignacao(){
		// geracao do numero de 1 a 3
		int numeroServico = 1 + (int)(Math.random() * (4-1));		

		// criacao e instanciacao do servi�o para retorno
		String designacao;		
		if (numeroServico == 1)
			designacao = "A";
		else if (numeroServico == 2)
			designacao = "B";
		else
			designacao = "C";

		return designacao;
	}

}
