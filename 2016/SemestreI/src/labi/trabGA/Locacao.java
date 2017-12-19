package labi.trabGA;

/*
 * Aluno : Luis Henrique Valgoi | Trabalho GA | Turma:33 | 2016/1 
 */

import java.util.Scanner;

public class Locacao {
	private Carro carro;
	private Locador locador;
	private int duracao;
	private double preco;
	
	public Locacao(Carro carro, Locador locador){
		this.carro = carro;
		this.locador = locador;
		this.duracao = 0;
		this.preco = 0;
	}
	
	public double devolve(int diasDeLocacao, long distanciaPercorrida){
		this.duracao = diasDeLocacao;
				
		
		// Se os pontos são iguais ou acima de 250
		double pontosPropietario = this.locador.getPontos();
		
		double desconto = Double.MIN_VALUE;		
		if(pontosPropietario >= 250.00){
			// Se ele ganha o sorteio, terá o desconto no valor de uma diária e seus pontos serão zerados
			if(fazSorteio()){
				desconto = this.carro.getPrecoDiaria();
				this.locador.setPontos(0);
			}
		}		
		// Se os pontos estão de 150 a 249, o desconto vale 7% do preço da locação e abate 150 pontos
		else if(pontosPropietario >= 150.00 && pontosPropietario <= 249.00){
			desconto = this.preco * 0.7;
			this.locador.setPontos(this.locador.getPontos() - 150);
		}		
		// Se os pontos estão de 100 a 149, o desconto será de 4% e abate 100 pontos
		else if(pontosPropietario >= 100.00 && pontosPropietario <= 149.00){
			desconto = this.preco * 0.4;
			this.locador.setPontos(this.locador.getPontos() - 100);
		}
		
		// Calculo baseado no valor de acordo com o valor de diária e as diárias consumidas
		// Abate do preço o desconto calculado anteriormente e atualiza o atributo preço		
		this.preco = this.duracao * this.carro.getPrecoDiaria() - desconto;
		double precoParaPropietario = this.preco - (this.preco * 0.15);
		this.carro.getDono().credita(precoParaPropietario);		
		
		// Lança os pontos referentes ao que ele acaba de pagar pela locação
		this.locador.ganhaPontos(this.preco);
		
		// Chama o método maiorLocacao para ver se a diária é a maior registrada
		this.carro.maiorLocacao(diasDeLocacao);
		
		// Atualiza a quilometragem
		this.carro.setQuilometragem(this.carro.getQuilometragem() + distanciaPercorrida);
		
		return desconto;
	}
	
	public boolean fazSorteio(){
		boolean temp = false;
		
		// Gera o numero aleatorio
		int numeroSorteio = 0+(int)(Math.random() * 99);
			
		// Le a escolha do usuario
		Scanner teclado = new Scanner(System.in);
		Helpers.write("Escreva P se achas que o número é PAR ou I se achas que o número é ÍMPAR");
		char escolhaUsuario = teclado.next().charAt(0);
		
		// Verifica se o numero sorteado é par
		boolean isNumeroSorteadoPar = false;		
		if(numeroSorteio % 2 == 0){
			isNumeroSorteadoPar = true;
		}
		
		// Verifica se a escolha do usuario é par		
		boolean isEscolhaUsuarioPar = false;		
		if(escolhaUsuario == 'P' || escolhaUsuario == 'p'){
			isEscolhaUsuarioPar = true;
		}
		else if(escolhaUsuario == 'I' || escolhaUsuario == 'i'){
			isEscolhaUsuarioPar = false;
		}
				
		// Verifica se o usuario acertou
		if(isNumeroSorteadoPar == isEscolhaUsuarioPar){
			System.out.println("ACERTOU!");
			System.out.println("O número sorteado foi: " + numeroSorteio);
			temp = true;
		}else{
			System.out.println("ERROW!");
			System.out.println("O número sorteado foi: " + numeroSorteio);
			temp = false;
		}
		
		return temp;
	}
	
	public void exibeDados(){
		carro.exibeDados();
		Helpers.write("\n** DADOS SOBRE A LOCAÇÃO **");
		Helpers.write("O Nome do Locador é: " + locador.getNome() + ".");
		Helpers.write("O Locador tem " + locador.getPontos() + " pontos.");
		Helpers.write("A Duração da Locação foi: " + this.duracao + " dias.");
		Helpers.write("O Preço final da Locação foi de: " + this.preco + " R$.");	
		
		if(this.duracao == 0){
			System.out.println("A Locação ainda não encerrou!");
		}else if(this.duracao != 0){
			System.out.println("A Locação já foi encerrada!");
		}
	}
}

