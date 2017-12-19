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
		
		System.out.println("O maior é:" + cj.getMaior());		
		System.out.println(cj.getMedia() == 0.0 ? "Impossível calcular a média" : "A média é: " + cj.getMedia());
		System.out.println("A soma é:" + cj.getSomaTodos());
	}
}
