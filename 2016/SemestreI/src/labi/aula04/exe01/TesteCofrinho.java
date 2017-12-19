package labi.aula04.exe01;

import java.util.Scanner;

public class TesteCofrinho {
	
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);

		// Primeiro cofre
		System.out.print("Digite o nome do dono do 1� Cofre:");
		String nomeDono = teclado.nextLine();			
		
		Cofrinho cofrinho1 = new Cofrinho(nomeDono);
		cofrinho1.depositaUmaMoedaDezCentavos(2);
		cofrinho1.depositaUmaMoedaVinteCincoCentavos(4);
		cofrinho1.depositaUmaMoedaCinquentaCentavos(3);

		// Segundo cofre
		System.out.print("Digite o nome do dono do 2� Cofre:");
		String nomeDonoDois = teclado.nextLine();
		
		Cofrinho cofrinho2 = new Cofrinho(nomeDonoDois);
		cofrinho2.depositaUmaMoedaDezCentavos(4);
		cofrinho2.depositaUmaMoedaVinteCincoCentavos(2);
		cofrinho2.depositaUmaMoedaCinquentaCentavos(4);

		// Novo Nome do Dono - 1� Cofre
		System.out.print("Digite o novo nome do dono do 1� Cofre:");
		String novoNomeDonoC1 = teclado.nextLine();
		cofrinho1.setNome(novoNomeDonoC1);		
		
		// Cria��o de um 3� Cofre
		Cofrinho cofrinho3 = new Cofrinho(nomeDonoDois);
		cofrinho3.depositaUmaMoedaCinquentaCentavos(2);		
		
		// Armazenamento do valor do Dolar
		System.out.print("Digite o valor do DOLAR (use virgula):");
		double valorDolar = teclado.nextDouble();
		
		// Exibe na tela informa��es do 1� Cofre
		System.out.println("\nNome do Dono do 1� Cofre: " + cofrinho1.getNome());
		System.out.println("Valor total no 1� Cofre: R$" + cofrinho1.calculaTotal());
		System.out.println("Valor total no 1� Cofre: U$" + cofrinho1.calculaTotal(valorDolar));
		
		// Exibe na tela informa��es do 2� Cofre
		System.out.println("\nNome do Dono do 2� Cofre: " + cofrinho2.getNome());
		System.out.println("Valor total no 2� Cofre: R$" + cofrinho2.calculaTotal());
		System.out.println("Valor total no 2� Cofre: U$" + cofrinho2.calculaTotal(valorDolar));
				
		// Exibe na tela informa��es do 3� Cofre
		System.out.println("\nNome do Dono do 3� Cofre: " + cofrinho3.getNome());
		System.out.println("Valor total no 3� Cofre: R$" + cofrinho3.calculaTotal());
		System.out.println("Valor total no 3� Cofre: U$" + cofrinho3.calculaTotal(valorDolar));
	}
}
