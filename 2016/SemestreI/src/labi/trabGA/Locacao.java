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
				
		
		// Se os pontos s�o iguais ou acima de 250
		double pontosPropietario = this.locador.getPontos();
		
		double desconto = Double.MIN_VALUE;		
		if(pontosPropietario >= 250.00){
			// Se ele ganha o sorteio, ter� o desconto no valor de uma di�ria e seus pontos ser�o zerados
			if(fazSorteio()){
				desconto = this.carro.getPrecoDiaria();
				this.locador.setPontos(0);
			}
		}		
		// Se os pontos est�o de 150 a 249, o desconto vale 7% do pre�o da loca��o e abate 150 pontos
		else if(pontosPropietario >= 150.00 && pontosPropietario <= 249.00){
			desconto = this.preco * 0.7;
			this.locador.setPontos(this.locador.getPontos() - 150);
		}		
		// Se os pontos est�o de 100 a 149, o desconto ser� de 4% e abate 100 pontos
		else if(pontosPropietario >= 100.00 && pontosPropietario <= 149.00){
			desconto = this.preco * 0.4;
			this.locador.setPontos(this.locador.getPontos() - 100);
		}
		
		// Calculo baseado no valor de acordo com o valor de di�ria e as di�rias consumidas
		// Abate do pre�o o desconto calculado anteriormente e atualiza o atributo pre�o		
		this.preco = this.duracao * this.carro.getPrecoDiaria() - desconto;
		double precoParaPropietario = this.preco - (this.preco * 0.15);
		this.carro.getDono().credita(precoParaPropietario);		
		
		// Lan�a os pontos referentes ao que ele acaba de pagar pela loca��o
		this.locador.ganhaPontos(this.preco);
		
		// Chama o m�todo maiorLocacao para ver se a di�ria � a maior registrada
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
		Helpers.write("Escreva P se achas que o n�mero � PAR ou I se achas que o n�mero � �MPAR");
		char escolhaUsuario = teclado.next().charAt(0);
		
		// Verifica se o numero sorteado � par
		boolean isNumeroSorteadoPar = false;		
		if(numeroSorteio % 2 == 0){
			isNumeroSorteadoPar = true;
		}
		
		// Verifica se a escolha do usuario � par		
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
			System.out.println("O n�mero sorteado foi: " + numeroSorteio);
			temp = true;
		}else{
			System.out.println("ERROW!");
			System.out.println("O n�mero sorteado foi: " + numeroSorteio);
			temp = false;
		}
		
		return temp;
	}
	
	public void exibeDados(){
		carro.exibeDados();
		Helpers.write("\n** DADOS SOBRE A LOCA��O **");
		Helpers.write("O Nome do Locador �: " + locador.getNome() + ".");
		Helpers.write("O Locador tem " + locador.getPontos() + " pontos.");
		Helpers.write("A Dura��o da Loca��o foi: " + this.duracao + " dias.");
		Helpers.write("O Pre�o final da Loca��o foi de: " + this.preco + " R$.");	
		
		if(this.duracao == 0){
			System.out.println("A Loca��o ainda n�o encerrou!");
		}else if(this.duracao != 0){
			System.out.println("A Loca��o j� foi encerrada!");
		}
	}
}

