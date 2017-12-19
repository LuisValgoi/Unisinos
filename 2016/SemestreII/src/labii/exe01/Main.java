package labii.exe01;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {

			boolean continuar = false;
			int tamanhoArray = Integer.MIN_VALUE;
			do {
				try {
					do{
						tamanhoArray = perguntaUsuario();
					}while(tamanhoArray < 0 || tamanhoArray < 100);

					continuar = true;
				} catch(InputMismatchException ex){
					escrever("Número digitado não é um inteiro!");
					escrever("Detalhe: " + ex.toString());
				}
			} while (!continuar);

			int[] arrayNaoOrdenado = new int[tamanhoArray];
			for (int i = 0; i < arrayNaoOrdenado.length; i++) {
				int numeroRandomico = 1 + (int)(Math.random() * 500);
				arrayNaoOrdenado[i] = numeroRandomico;
			}

			int[] arrayOrdenado = arrayNaoOrdenado.clone();
			Arrays.sort(arrayOrdenado);

			escrever("-------------------------------------------------------------");
			escrever("O Array não ordenado é composto por os seguintes elementos: " + Arrays.toString(arrayNaoOrdenado));
			escrever("O Array ordenado é composto por os seguintes elementos: " + Arrays.toString(arrayOrdenado));
			escrever("-------------------------------------------------------------");

			int maiorValor = Integer.MIN_VALUE;
			int posicaoMaiorValor = Integer.MIN_VALUE;
			int passosEncontrarMaiorValor = Integer.MIN_VALUE;

			int menorValor = Integer.MIN_VALUE;
			int posicaoMenorValor = Integer.MIN_VALUE;
			int passosEncontrarMenorValor = Integer.MIN_VALUE;

			int maiorValorPar = Integer.MIN_VALUE;
			int posicaoMaiorValorPar = Integer.MIN_VALUE;
			int passosEncontrarMaiorValorPar = Integer.MIN_VALUE;

			int maiorValorImpar = Integer.MIN_VALUE;
			int posicaoMaiorValorImpar = Integer.MIN_VALUE;
			int passosEncontrarMaiorValorImpar = Integer.MIN_VALUE;

			int menorValorPar = Integer.MIN_VALUE;
			int posicaoMenorValorPar = Integer.MIN_VALUE;
			int passosEncontrarMenorValorPar = Integer.MIN_VALUE;

			int menorValorImpar = Integer.MIN_VALUE;
			int posicaoMenorValorImpar = Integer.MIN_VALUE;
			int passosEncontrarMenorValorImpar = Integer.MIN_VALUE;

			maiorValor = pesquisaMaiorValor(arrayNaoOrdenado);
			posicaoMaiorValor = posicaoValor(arrayNaoOrdenado, maiorValor);
			passosEncontrarMaiorValor = passosEncontrarValor(arrayOrdenado, maiorValor);
			escrever("O maior valor é: " + maiorValor);
			escrever("O maior valor esta na posição: " + posicaoMaiorValor);
			escrever("Pesquisa Binaria encontrou o maior valor em: " + passosEncontrarMaiorValor + " passos");
			escrever("-------------------------------------------------------------");

			menorValor = pesquisaMenorValor(arrayNaoOrdenado);
			posicaoMenorValor = posicaoValor(arrayNaoOrdenado, menorValor);
			passosEncontrarMenorValor = passosEncontrarValor(arrayOrdenado, menorValor);
			escrever("O menor valor é: " + menorValor);
			escrever("O menor valor esta na posição: " + posicaoMenorValor);
			escrever("Com a Pesquisa Binaria encontrou o menor valor em: " + passosEncontrarMenorValor + " passos");
			escrever("-------------------------------------------------------------");

			try {
				maiorValorPar = pesquisaMaiorValorPar(arrayNaoOrdenado);
				posicaoMaiorValorPar = posicaoValor(arrayNaoOrdenado, maiorValorPar);
				passosEncontrarMaiorValorPar = passosEncontrarValor(arrayOrdenado, maiorValorPar);
			} catch(NumeroParNaoEncontradoException ex) {
				escrever("Detalhe: " + ex.toString());
			}
			escrever("O maior valor par é: " + maiorValorPar);
			escrever("O maior valor par esta na posição: " + posicaoMaiorValorPar);
			escrever("Com a Pesquisa Binaria encontrou o maior valor par em: " + passosEncontrarMaiorValorPar + " passos");
			escrever("-------------------------------------------------------------");

			try {
				maiorValorImpar = pesquisaMaiorValorImpar(arrayNaoOrdenado);
				posicaoMaiorValorImpar = posicaoValor(arrayNaoOrdenado, maiorValorImpar);
				passosEncontrarMaiorValorImpar = passosEncontrarValor(arrayOrdenado, maiorValorImpar);
			} catch(NumeroImparNaoEncontradoException ex) {
				escrever("Detalhe: " + ex.toString());
			}
			escrever("O maior valor impar é: " + maiorValorImpar);
			escrever("O maior valor impar esta na posição: " + posicaoMaiorValorImpar);
			escrever("Com a Pesquisa Binaria encontrou o maior valor impar em: " + passosEncontrarMaiorValorImpar + " passos");
			escrever("-------------------------------------------------------------");

			try {
				menorValorPar = pesquisaMenorValorPar(arrayNaoOrdenado);
				posicaoMenorValorPar = posicaoValor(arrayNaoOrdenado, menorValorPar);
				passosEncontrarMenorValorPar = passosEncontrarValor(arrayOrdenado, menorValorPar);
			} catch(NumeroParNaoEncontradoException ex) {
				escrever("Detalhe: " + ex.toString());
			}
			escrever("O Menor par: " + menorValorPar);
			escrever("O menor valor par esta na posição: " + posicaoMenorValorPar);
			escrever("Com a Pesquisa Binaria encontrou o menor valor par em: " + passosEncontrarMenorValorPar + " passos");
			escrever("-------------------------------------------------------------");

			try {
				menorValorImpar = pesquisaMenorValorImpar(arrayNaoOrdenado);
				posicaoMenorValorImpar = posicaoValor(arrayNaoOrdenado, menorValorImpar);
				passosEncontrarMenorValorImpar = passosEncontrarValor(arrayOrdenado, menorValorImpar);
			} catch(NumeroImparNaoEncontradoException ex) {
				escrever("Detalhe: " + ex.toString());
			}
			escrever("Menor impar: " + menorValorImpar);
			escrever("O menor valor impar esta na posição: " + posicaoMenorValorImpar);
			escrever("Com a Pesquisa Binaria encontrou o menor valor impar em: " + passosEncontrarMenorValorImpar + " passos");

		} catch (Exception ex) {
			escrever("Detalhe: " + ex.toString());
		}
	}

	public static int perguntaUsuario() throws NumberFormatException{
		Scanner teclado = new Scanner(System.in);
		escrever("Digite um número inteiro maior que 99");
		return teclado.nextInt();
	}

	public static void escrever(String value){
		System.out.println(value);
	}

	// Caso: Maior Valor
	public static int pesquisaMaiorValor(int[] array){
		int maiorValor = array[0];

		for (int i = 0; i < array.length; i++) {
			if(array[i] > maiorValor && array[i] != maiorValor){
				maiorValor = array[i];
			}
		}

		return maiorValor;
	}

	// Caso: Menor Valor
	public static int pesquisaMenorValor(int[] array){
		int menorValor = array[0];

		for (int i = 0; i < array.length; i++) {
			if(array[i] < menorValor && menorValor != array[i]){
				menorValor = array[i];
			}
		}

		return menorValor;
	}

	// Caso: Maior Valor Par
	public static int pesquisaMaiorValorPar(int[] array) throws NumeroParNaoEncontradoException{
		int maiorValorPar = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {
			if(array[i] > maiorValorPar && array[i] % 2 == 0 && maiorValorPar != array[i]){
				maiorValorPar = array[i];
			}
		}

		if (maiorValorPar == Integer.MIN_VALUE){
			throw new NumeroParNaoEncontradoException();
		}

		return maiorValorPar;
	}

	// Caso: Maior Valor Impar
	public static int pesquisaMaiorValorImpar(int[] array) throws NumeroImparNaoEncontradoException{
		int maiorValorImpar = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {
			if(array[i] > maiorValorImpar && array[i] % 2 != 0 && maiorValorImpar != array[i]){
				maiorValorImpar = array[i];
			}
		}

		if (maiorValorImpar == Integer.MIN_VALUE){
			throw new NumeroImparNaoEncontradoException();
		}

		return maiorValorImpar;
	}

	// Caso: Menor Valor Par
	public static int pesquisaMenorValorPar(int[] array) throws NumeroParNaoEncontradoException{
		int menorValorPar = array[0];
		int countException = 0;

		for (int i = 0; i < array.length; i++) {
			if(array[i] < menorValorPar && array[i] % 2 == 0 && menorValorPar != array[i]){
				menorValorPar = array[i];
				countException++;
			}
		}

		if (countException == 0){
			throw new NumeroParNaoEncontradoException();
		}

		return menorValorPar;
	}

	// Caso: Menor Valor Impar
	public static int pesquisaMenorValorImpar(int[] array) throws NumeroImparNaoEncontradoException{
		int menorValorImpar = array[0];
		int countException = 0;

		for (int i = 0; i < array.length; i++) {
			if(array[i] < menorValorImpar && array[i] % 2 != 0 && menorValorImpar != array[i]){
				menorValorImpar = array[i];
				countException++;
			}
		}

		if (countException == 0){
			throw new NumeroImparNaoEncontradoException();
		}

		return menorValorImpar;
	}

	// Método de Busca de posição
	public static int posicaoValor(int[] array, int valor){
		int posicao = 0;

		for (int i = 0; i < array.length; i++) {
			if(array[i] == valor){
				posicao = i;
			}
		}

		return posicao;
	}

	// Método de Busca Binária de valor
	public static int passosEncontrarValor(int[] arrayOrdenado, int valor){
		int sup = arrayOrdenado.length -1;
		int min = 0;
		int med = 0;
		int passos = 1;

		while (min <= sup) {
			med = (sup + min) / 2;

			if(valor == arrayOrdenado[med]){
				return passos;
			}
			else if(valor > arrayOrdenado[med]){
				min = med + 1;
				passos++;
			}
			else if(valor < arrayOrdenado[med]){
				sup = med -1;
				passos++;
			}
		}

		return passos;
	}

}
