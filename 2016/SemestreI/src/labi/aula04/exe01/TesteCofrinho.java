package labi.aula04.exe01;

import java.util.Scanner;

public class TesteCofrinho {
	
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);

		// Primeiro cofre
		System.out.print("Digite o nome do dono do 1º Cofre:");
		String nomeDono = teclado.nextLine();			
		
		Cofrinho cofrinho1 = new Cofrinho(nomeDono);
		cofrinho1.depositaUmaMoedaDezCentavos(2);
		cofrinho1.depositaUmaMoedaVinteCincoCentavos(4);
		cofrinho1.depositaUmaMoedaCinquentaCentavos(3);

		// Segundo cofre
		System.out.print("Digite o nome do dono do 2º Cofre:");
		String nomeDonoDois = teclado.nextLine();
		
		Cofrinho cofrinho2 = new Cofrinho(nomeDonoDois);
		cofrinho2.depositaUmaMoedaDezCentavos(4);
		cofrinho2.depositaUmaMoedaVinteCincoCentavos(2);
		cofrinho2.depositaUmaMoedaCinquentaCentavos(4);

		// Novo Nome do Dono - 1º Cofre
		System.out.print("Digite o novo nome do dono do 1º Cofre:");
		String novoNomeDonoC1 = teclado.nextLine();
		cofrinho1.setNome(novoNomeDonoC1);		
		
		// Criação de um 3º Cofre
		Cofrinho cofrinho3 = new Cofrinho(nomeDonoDois);
		cofrinho3.depositaUmaMoedaCinquentaCentavos(2);		
		
		// Armazenamento do valor do Dolar
		System.out.print("Digite o valor do DOLAR (use virgula):");
		double valorDolar = teclado.nextDouble();
		
		// Exibe na tela informações do 1º Cofre
		System.out.println("\nNome do Dono do 1º Cofre: " + cofrinho1.getNome());
		System.out.println("Valor total no 1º Cofre: R$" + cofrinho1.calculaTotal());
		System.out.println("Valor total no 1º Cofre: U$" + cofrinho1.calculaTotal(valorDolar));
		
		// Exibe na tela informações do 2º Cofre
		System.out.println("\nNome do Dono do 2º Cofre: " + cofrinho2.getNome());
		System.out.println("Valor total no 2º Cofre: R$" + cofrinho2.calculaTotal());
		System.out.println("Valor total no 2º Cofre: U$" + cofrinho2.calculaTotal(valorDolar));
				
		// Exibe na tela informações do 3º Cofre
		System.out.println("\nNome do Dono do 3º Cofre: " + cofrinho3.getNome());
		System.out.println("Valor total no 3º Cofre: R$" + cofrinho3.calculaTotal());
		System.out.println("Valor total no 3º Cofre: U$" + cofrinho3.calculaTotal(valorDolar));
	}
}
