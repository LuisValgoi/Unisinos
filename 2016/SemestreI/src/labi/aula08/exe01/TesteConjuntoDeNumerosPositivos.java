package labi.aula08.exe01;

import java.util.Scanner;

public class TesteConjuntoDeNumerosPositivos {

	public static void main(String[] args) {
		ConjuntoDeNumerosPositivos cj = new ConjuntoDeNumerosPositivos();
		
		Scanner teclado = new Scanner(System.in);
				
		int numDigitado = 1;
		while (numDigitado != 0){
			System.out.println("Digite o numero");
			numDigitado = teclado.nextInt();
			
			cj.incluiUmNumero(numDigitado);			
		}
		
		System.out.println("O maior �:" + cj.getMaior());		
		System.out.println(cj.getMedia() == 0.0 ? "Imposs�vel calcular a m�dia" : "A m�dia �: " + cj.getMedia());
		System.out.println("A soma �:" + cj.getSomaTodos());
	}
}
