package labi.aula09ProvaGA;

/*  Aluno: Luis Henrique Valgoi | Prova GA | Turma: 33 | Lab 1 */

import java.util.Scanner;

public class Servico {
	private int tipoServico;
	private int tipoMaquina;
	private Cliente cliente;
	private double precoLavagem;
	private double precoSecagem;
	private double valorDesconto;
	private double precoFinal;
	
	public Servico(Cliente cliente, int tipoMaquina){
		this.tipoServico = 1;		
		this.precoLavagem = 0;
		this.precoSecagem = 0;
		this.valorDesconto = 0;
		this.precoFinal = 0;
		this.cliente = cliente;
		
		if(tipoMaquina != 9 || tipoMaquina != 11 || tipoMaquina != 16){
			this.tipoMaquina = 9;
		}
		else{		
			this.tipoMaquina = tipoMaquina;
		}		
	}
	
	public Servico(Cliente cliente){
		this.tipoServico = 2;
		this.precoLavagem = 0;
		this.precoSecagem = 0;
		this.valorDesconto = 0;
		this.precoFinal = 0;		
		this.cliente = cliente;
		
		int numeroSorteado = 1 + (int)(Math.random() * 3);
		
		if(numeroSorteado == 1){
			this.tipoMaquina = 9;
		}
		else if(numeroSorteado == 2){
			this.tipoMaquina = 11;
		}
		else if(numeroSorteado == 3){
			this.tipoMaquina = 16;
		}
	}
	
	public String getTipoServicoDescrito(){
		String response = "";
		
		if(this.tipoServico == 1){
			response = "Só Lavar";
		}
		else if(this.tipoServico == 2){
			response = "Lavar e secar";
		}
		else{
			response = "Ocorreu algum erro";	
		}
		
		return response;
	}
	
	public void calculaPrecos(){
		////////////////////////////////////////////////
		this.precoLavagem = this.calculaPrecoLavagem();

		////////////////////////////////////////////////
		if(this.tipoServico == 2){
			Scanner teclado = new Scanner(System.in);
			System.out.println("Digite o tempo de duração da secagem");
			double tempoDuracao = teclado.nextDouble();
			
			this.precoSecagem = this.calculaPrecoSecagem(tempoDuracao);
		}
		
		////////////////////////////////////////////////
		double valorDescontoTemp = 0.0;
		double precoFinalTemp = this.precoLavagem + this.precoSecagem;
		
		int pontosCliente = (int)precoFinalTemp / 5;
		this.cliente.creditaPontos(pontosCliente);
		
		if(this.cliente.getPontos() >= 30){
			valorDescontoTemp = precoFinalTemp * 0.10;			
			this.cliente.zeraPontos();
		}

		this.valorDesconto = valorDescontoTemp;
		this.precoFinal = precoFinalTemp - this.valorDesconto;
	}
	
	public void emiteNota(){
		System.out.println("Servico tipo " + this.tipoServico + " - " + this.getTipoServicoDescrito());
		
		System.out.println("Maquina de Lavar Usada: " + this.tipoMaquina + "kg");
		
		System.out.println("Preco da Lavagem: R$" + this.precoLavagem);
		
		if(this.tipoServico == 2){
			System.out.println("Preco da Secagem: R$" + this.precoSecagem);	
		}		
		
		System.out.println("Desconto: R$" + this.valorDesconto);
		
		System.out.println("Preco Final: R$" + this.precoFinal);
		
		this.cliente.exibeDados();
	}
	
	private double calculaPrecoLavagem(){
		double precoLavagem = 0;
		
		if(this.tipoMaquina == 9){
			precoLavagem = 15.50;
		}
		else if(this.tipoMaquina == 11){
			precoLavagem = 21.00;
		}
		else if(this.tipoMaquina == 16){
			precoLavagem = 31.50;
		}
		
		return precoLavagem;
	}
	
	private double calculaPrecoSecagem(double tempo){
		double precoSecagem = Double.MIN_VALUE;
		int minExtra = Integer.MIN_VALUE;
		
		if (tempo < 0){
			return precoSecagem;
		}
		
		if(tempo <= 15.00){
			precoSecagem = 10.00;
		}
		else{
			minExtra = (int)tempo - 15;
			precoSecagem = 10.00 + (minExtra * 0.6);
		}		
		return precoSecagem;
	}
}
