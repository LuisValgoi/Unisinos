package labii.exe02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio01 {

	/**
	 * Main da aplicação
	 * @param args
	 */
	public static void main(String[] args) {
		// Array final
		int[] array = new int[20];

		// Laço
		for (int i = 0; i < array.length; i++) {

			// Valor digitado
			int valor = 0;

			// Flag para continuar perguntando se der erro
			boolean seguir = false;

			// Laço
			do {
				try {
					Scanner t = new Scanner(System.in);
					System.out.println("Forneca o " + (i + 1) + "º valor de " + array.length);
					valor = t.nextInt();
					seguir = true;
				} catch (NumberFormatException e) {
					System.out.println("**Número digitado errado, digite novamente!**");
					seguir = false;
				} catch (InputMismatchException e) {
					System.out.println("**Número digitado errado, digite novamente!**");
					seguir = false;
				} catch (Exception e) {
					System.out.println("**Número digitado errado, digite novamente!**");
					seguir = false;
				}
			} while (!seguir);				

			// Atribuição caso de tudo certo
			array[i] = valor;
		}

		// Impressão 1
		System.out.print("\nValores do vetor: ");
		for (int i = 0; i < array.length; i++){			
			System.out.print(array[i] + " ");
		}
		System.out.print("\n");
		
		// Impressão 1.A
		int[] specsMenor = specsMenorValores(array);
		int[] specsMaior = specsMaiorValores(array);
		System.out.println("O menor valor é " + specsMenor[1] + ", ele se encontra na posição: " + specsMenor[0]);
		System.out.println("O maior valor é " + specsMaior[1] + ", ele se encontra na posição: " + specsMaior[0]);
		
		// Impressão 1.B
		int[] specsParesImpares = qtdParesImpares(array);
		System.out.println("Quantidade de valores pares:" + specsParesImpares[0]);
		System.out.println("Quantidade de valores ímpares:" + specsParesImpares[1]);
	}

	/**
	 * Método que retorna um array de 2 posições: 1º Posiçao do Menor Valor. 2º Valor do Menor Valor
	 * @param array
	 * @return
	 */
	public static int[] specsMenorValores(int[] array){
		int posicaoMenorValor = 0;
		int menorValor = array[0];		
		int[] specs = new int[2];

		for (int i = 0; i < array.length; i++) {
			if(array[i] < menorValor){
				posicaoMenorValor = i;
				menorValor = array[i];
			}
		}
		specs[0] = posicaoMenorValor;
		specs[1] = menorValor;

		return specs;
	}

	/**
	 * Método que retorna um array de 2 posições: 1º Posiçao do Maior Valor. 2º Valor do Maior Valor
	 * @param array
	 * @return
	 */
	public static int[] specsMaiorValores(int[] array){
		int posicaoMaiorValor = 0;
		int maiorValor = array[0];		
		int[] specs = new int[2];

		for (int i = 0; i < array.length; i++) {
			if(array[i] > maiorValor){
				posicaoMaiorValor = i;
				maiorValor = array[i];
			}
		}

		specs[0] = posicaoMaiorValor;
		specs[1] = maiorValor;

		return specs;
	}

	/**
	 * Método que me retorna um array de 2 posições. 1ª Qtd Valores Pares. 2ª Qtd Valores Impares
	 * @param array
	 * @return
	 */
	public static int[] qtdParesImpares(int[] array){
		int qtdPares = 0;
		int qtdImpares = 0;
		int[] specs = new int[2];
		
		for (int i = 0; i < array.length; i++) {
			if(array[i] % 2 == 0)
				qtdPares++;
			else
				qtdImpares++;
		}		
		specs[0] = qtdPares;
		specs[1] = qtdImpares;
		
		return specs;
	}
}
