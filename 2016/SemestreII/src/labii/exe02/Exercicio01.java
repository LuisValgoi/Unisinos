package labii.exe02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio01 {

	/**
	 * Main da aplica��o
	 * @param args
	 */
	public static void main(String[] args) {
		// Array final
		int[] array = new int[20];

		// La�o
		for (int i = 0; i < array.length; i++) {

			// Valor digitado
			int valor = 0;

			// Flag para continuar perguntando se der erro
			boolean seguir = false;

			// La�o
			do {
				try {
					Scanner t = new Scanner(System.in);
					System.out.println("Forneca o " + (i + 1) + "� valor de " + array.length);
					valor = t.nextInt();
					seguir = true;
				} catch (NumberFormatException e) {
					System.out.println("**N�mero digitado errado, digite novamente!**");
					seguir = false;
				} catch (InputMismatchException e) {
					System.out.println("**N�mero digitado errado, digite novamente!**");
					seguir = false;
				} catch (Exception e) {
					System.out.println("**N�mero digitado errado, digite novamente!**");
					seguir = false;
				}
			} while (!seguir);				

			// Atribui��o caso de tudo certo
			array[i] = valor;
		}

		// Impress�o 1
		System.out.print("\nValores do vetor: ");
		for (int i = 0; i < array.length; i++){			
			System.out.print(array[i] + " ");
		}
		System.out.print("\n");
		
		// Impress�o 1.A
		int[] specsMenor = specsMenorValores(array);
		int[] specsMaior = specsMaiorValores(array);
		System.out.println("O menor valor � " + specsMenor[1] + ", ele se encontra na posi��o: " + specsMenor[0]);
		System.out.println("O maior valor � " + specsMaior[1] + ", ele se encontra na posi��o: " + specsMaior[0]);
		
		// Impress�o 1.B
		int[] specsParesImpares = qtdParesImpares(array);
		System.out.println("Quantidade de valores pares:" + specsParesImpares[0]);
		System.out.println("Quantidade de valores �mpares:" + specsParesImpares[1]);
	}

	/**
	 * M�todo que retorna um array de 2 posi��es: 1� Posi�ao do Menor Valor. 2� Valor do Menor Valor
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
	 * M�todo que retorna um array de 2 posi��es: 1� Posi�ao do Maior Valor. 2� Valor do Maior Valor
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
	 * M�todo que me retorna um array de 2 posi��es. 1� Qtd Valores Pares. 2� Qtd Valores Impares
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
