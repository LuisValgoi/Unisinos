package labii.provaGB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Guiches {
	private NodeQueue<Veiculo> guiche01;
	private int tempoAcumuladoGuiche01 = 0;

	private NodeQueue<Veiculo> guiche02;
	private int tempoAcumuladoGuiche02 = 0;

	private NodeQueue<Veiculo> guiche03;
	private int tempoAcumuladoGuiche03 = 0;

	private NodeQueue<Veiculo> guiche04;	
	private int tempoAcumuladoGuiche04 = 0;

	private Relatorio relatorio;

	public Guiches(){
		guiche01 = new NodeQueue<Veiculo>();
		guiche02 = new NodeQueue<Veiculo>();
		guiche03 = new NodeQueue<Veiculo>();
		guiche04 = new NodeQueue<Veiculo>();

		tempoAcumuladoGuiche01 = 0;
		tempoAcumuladoGuiche02 = 0;
		tempoAcumuladoGuiche03 = 0;
		tempoAcumuladoGuiche04 = 0;
	}

	private boolean jaPreenchiUmaVez = false;
	public void preenchimentoInicial(){
		if(!jaPreenchiUmaVez){
			jaPreenchiUmaVez = true;

			try {
				// guiche 01 = 4 automoveis		
				guiche01.enqueue(new Veiculo(1));
				guiche01.enqueue(new Veiculo(1));
				guiche01.enqueue(new Veiculo(1));
				guiche01.enqueue(new Veiculo(1));			
				tempoAcumuladoGuiche01 = 120;

				// guiche 02 = 2 caminhoes
				guiche02.enqueue(new Veiculo(2));
				guiche02.enqueue(new Veiculo(2));
				tempoAcumuladoGuiche02 = 120;

				// guiche 03 = 2 automoveis e 1 caminhao
				guiche03.enqueue(new Veiculo(1));
				guiche03.enqueue(new Veiculo(1));
				guiche03.enqueue(new Veiculo(2));
				tempoAcumuladoGuiche03 = 120;

				// guiche 04 = 1 caminhao e 2 automoveis
				guiche04.enqueue(new Veiculo(2));
				guiche04.enqueue(new Veiculo(1));
				guiche04.enqueue(new Veiculo(1));
				tempoAcumuladoGuiche04 = 120;	
			} catch (Exception e) {
				System.out.println(e);
			}			
		}
	}

	public void atende(ArrayQueue<Veiculo> rodovia){
		this.relatorio = new Relatorio();

		while(!guiche01.isEmpty() || !guiche02.isEmpty() || !guiche03.isEmpty() || !guiche04.isEmpty()){

			if(!guiche01.isEmpty()){
				Veiculo veiculoParaSerAtendido01 = guiche01.front();
				veiculoParaSerAtendido01.setTempo(veiculoParaSerAtendido01.getTempo() - 30);			
				if(veiculoParaSerAtendido01.getTempo() == 0){
					relatorio.conta(1, guiche01.dequeue());

					if(veiculoParaSerAtendido01.getTipo() == 1){
						tempoAcumuladoGuiche01 -= 30;
					}else{
						tempoAcumuladoGuiche01 -= 60;
					}
				}
			}


			if(!guiche02.isEmpty()){			
				Veiculo veiculoParaSerAtendido02 = guiche02.front();
				veiculoParaSerAtendido02.setTempo(veiculoParaSerAtendido02.getTempo() - 30);			
				if(veiculoParaSerAtendido02.getTempo() == 0){					
					relatorio.conta(2, guiche02.dequeue());

					if(veiculoParaSerAtendido02.getTipo() == 1){
						tempoAcumuladoGuiche02 -= 30;
					}else{
						tempoAcumuladoGuiche02 -= 60;
					}
				}
			}

			if(!guiche03.isEmpty()){
				Veiculo veiculoParaSerAtendido03 = guiche03.front();
				veiculoParaSerAtendido03.setTempo(veiculoParaSerAtendido03.getTempo() - 30);			
				if(veiculoParaSerAtendido03.getTempo() == 0){
					relatorio.conta(3, guiche03.dequeue());

					if(veiculoParaSerAtendido03.getTipo() == 1){
						tempoAcumuladoGuiche03 -= 30;
					}else{
						tempoAcumuladoGuiche03 -= 60;
					}
				}
			}

			if(!guiche04.isEmpty()){
				Veiculo veiculoParaSerAtendido04 = guiche04.front();
				veiculoParaSerAtendido04.setTempo(veiculoParaSerAtendido04.getTempo() - 30);			
				if(veiculoParaSerAtendido04.getTempo() == 0){
					relatorio.conta(4, guiche04.dequeue());

					if(veiculoParaSerAtendido04.getTipo() == 1){
						tempoAcumuladoGuiche04 -= 30;
					}else{
						tempoAcumuladoGuiche04 -= 60;
					}
				}
			}			

			if(!rodovia.isEmpty())
				enfileira(rodovia);
		}
	}

	private void enfileira(ArrayQueue<Veiculo> rodovia){
		// atendimento do guiche 01
		if(rodovia.size() > 0){		
			Veiculo veiculoGuiche01 = rodovia.front();
			if(tempoAcumuladoGuiche01 + veiculoGuiche01.getTempo() <= 120){
				tempoAcumuladoGuiche01 += veiculoGuiche01.getTempo();

				Veiculo atual = rodovia.dequeue();
				guiche01.enqueue(atual);
			}
		}


		// atendimento do guiche 02
		if(rodovia.size() > 0){
			Veiculo veiculoGuiche02 = rodovia.front();
			if(tempoAcumuladoGuiche02 + veiculoGuiche02.getTempo() <= 120){
				tempoAcumuladoGuiche02 += veiculoGuiche02.getTempo();

				Veiculo atual = rodovia.dequeue();
				guiche02.enqueue(atual);
			}
		}

		// atendimento do guiche 03
		if(rodovia.size() > 0){
			Veiculo veiculoGuiche03 = rodovia.front();
			if(tempoAcumuladoGuiche03 + veiculoGuiche03.getTempo() <= 120){
				tempoAcumuladoGuiche03 += veiculoGuiche03.getTempo();

				Veiculo atual = rodovia.dequeue();
				guiche03.enqueue(atual);
			}
		}

		// atendimento do guiche 04
		if(rodovia.size() > 0){
			Veiculo veiculoGuiche04 = rodovia.front();
			if(tempoAcumuladoGuiche04 + veiculoGuiche04.getTempo() <= 120){
				tempoAcumuladoGuiche04 += veiculoGuiche04.getTempo();

				Veiculo atual = rodovia.dequeue();
				guiche04.enqueue(atual);
			}
		}
	}

	public void geraRelatorio(){
		int guicheMaisAtendimento = 0;
		if(relatorio.qtdTotalVeiculos01() > relatorio.qtdTotalVeiculos02() &&  
				relatorio.qtdTotalVeiculos01() > relatorio.qtdTotalVeiculos03() &&
				relatorio.qtdTotalVeiculos01() > relatorio.qtdTotalVeiculos04()){
			guicheMaisAtendimento = 1;
		}else if(relatorio.qtdTotalVeiculos02() > relatorio.qtdTotalVeiculos01() &&  
				relatorio.qtdTotalVeiculos02() > relatorio.qtdTotalVeiculos03() &&
				relatorio.qtdTotalVeiculos02() > relatorio.qtdTotalVeiculos04()){
			guicheMaisAtendimento = 2;
		}else if(relatorio.qtdTotalVeiculos03() > relatorio.qtdTotalVeiculos01() &&  
				relatorio.qtdTotalVeiculos03() > relatorio.qtdTotalVeiculos02() &&
				relatorio.qtdTotalVeiculos03() > relatorio.qtdTotalVeiculos04()){
			guicheMaisAtendimento = 3;
		}else if(relatorio.qtdTotalVeiculos04() > relatorio.qtdTotalVeiculos01() &&  
				relatorio.qtdTotalVeiculos04() > relatorio.qtdTotalVeiculos02() &&
				relatorio.qtdTotalVeiculos04() > relatorio.qtdTotalVeiculos03()){
			guicheMaisAtendimento = 4;
		}
		
		int guicheMenorAtendimento = 0;
		if(relatorio.qtdTotalVeiculos01() < relatorio.qtdTotalVeiculos02() &&  
				relatorio.qtdTotalVeiculos01() < relatorio.qtdTotalVeiculos03() &&
				relatorio.qtdTotalVeiculos01() < relatorio.qtdTotalVeiculos04()){
			guicheMenorAtendimento = 1;
		}else if(relatorio.qtdTotalVeiculos02() < relatorio.qtdTotalVeiculos01() &&  
				relatorio.qtdTotalVeiculos02() < relatorio.qtdTotalVeiculos03() &&
				relatorio.qtdTotalVeiculos02() < relatorio.qtdTotalVeiculos04()){
			guicheMenorAtendimento = 2;
		}else if(relatorio.qtdTotalVeiculos03() < relatorio.qtdTotalVeiculos01() &&  
				relatorio.qtdTotalVeiculos03() < relatorio.qtdTotalVeiculos02() &&
				relatorio.qtdTotalVeiculos03() < relatorio.qtdTotalVeiculos04()){
			guicheMenorAtendimento = 3;
		}else if(relatorio.qtdTotalVeiculos04() < relatorio.qtdTotalVeiculos01() &&  
				relatorio.qtdTotalVeiculos04() < relatorio.qtdTotalVeiculos02() &&
				relatorio.qtdTotalVeiculos04() < relatorio.qtdTotalVeiculos03()){
			guicheMenorAtendimento = 4;
		}

		int qtdAutomoveisMaior = relatorio.getQtdAtendimentosAutomoveis(guicheMaisAtendimento);
		int qtdCaminhoesMaior = relatorio.getQtdAtendimentosCaminhoes(guicheMaisAtendimento);
		
		int qtdAutomoveisMenor = relatorio.getQtdAtendimentosAutomoveis(guicheMenorAtendimento);
		int qtdCaminhoesMenor = relatorio.getQtdAtendimentosCaminhoes(guicheMenorAtendimento);
		
		try {
			File file = new File("Rel_Guiche.txt");
			FileWriter fr = new FileWriter(file);
			PrintWriter out = new PrintWriter(fr);	

			out.write("Relatorio\r\n\r\n");
			
			out.write("O guiche que mais teve atendimento foi o: " + guicheMaisAtendimento);
			out.write("\r\nA qtd de automoveis desse guiche foi: " + qtdAutomoveisMaior);
			out.write("\r\nA qtd de caminhoes desse guiche foi: " + qtdCaminhoesMaior);
			
			out.write("\r\n\r\nO guiche que menos teve atendimento foi o: " + guicheMenorAtendimento);
			out.write("\r\nA qtd de automoveis desse guiche foi: " + qtdAutomoveisMenor);
			out.write("\r\nA qtd de caminhoes desse guiche foi: " + qtdCaminhoesMenor);			

			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontado: " + e.toString());	
		} catch (Exception e) {
			System.out.println("Ocorreu um erro: " + e.toString());
		}
	}

}
