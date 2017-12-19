package labii.exe03;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		// Arrays
		int tamanhoArray = 5000;
		int[] array1 = new int[tamanhoArray];
		for (int i = 0; i < tamanhoArray; i++) {
			int num = 1 + (int)(Math.random() * (tamanhoArray - 1));
			array1[i] = num;
		}
		int[] array2 = array1.clone();
		int[] array3 = array1.clone();

		
		// Variaveis
		int selecionaOrdem = 0;
		int tipoOrdenacao = 0;
		String msg = "";

		
		// Seleciona Ordem
		boolean continuar = false;		
		do {
			try {
				System.out.println("Deseja selecionar a ordem? (1 - Sim, 2 - Não)");
				selecionaOrdem = teclado.nextInt();

				if(selecionaOrdem != 1 && selecionaOrdem != 2){
					continuar = false;
					throw new EscolhaOrdemException();					
				}
				continuar = true;
			} catch (EscolhaOrdemException e) {
				System.out.println(e.toString());
				continuar = false;
			} catch (NumberFormatException e) {
				System.out.println("Seleção da Ordem Escolhida Inválida!: " + e.toString());
				System.out.println(e.toString());
				continuar = false;
			} catch (InputMismatchException e) {
				System.out.println("Seleção da Ordem Escolhida Inválida!: " + e.toString());
				System.out.println(e.toString());
				continuar = false;
			} catch (Exception e) {
				System.out.println("Seleção da Ordem Escolhida Inválida!: " + e.toString());
				continuar = false;
			}
		} while (!continuar);		

		
		// Escolha de Ordem: Sim
		boolean continuarInterno = false;
		if(selecionaOrdem == 1){			
			do {
				try {
					System.out.println("Deseja qual ordem? (1 - Crescente, 2 - Decrescente)");
					tipoOrdenacao = teclado.nextInt();

					if(tipoOrdenacao != 1 && tipoOrdenacao != 2){
						continuarInterno = false;
						throw new NumeroOrdemException();						
					}					
					continuarInterno = true;
				} catch (NumeroOrdemException e) {
					System.out.println(e.toString());
					continuarInterno = false;
				} catch (NumberFormatException e) {
					System.out.println("Numero da Ordem Escolhido Inválida!: " + e.toString());
					continuarInterno = false;
				} catch (InputMismatchException e) {
					System.out.println("Numero da Ordem Escolhido Inválida!: " + e.toString());
					continuarInterno = false;
				} catch (Exception e) {
					System.out.println("Numero da Ordem Escolhido Inválida!: " + e.toString());
					continuarInterno = false;
				}
			} while (!continuarInterno);

			// Numero Ordem: Crescente
			if(tipoOrdenacao == 1){
				msg = "Crescente";
				// System.out.println("Array original: " + Arrays.toString(array1));
				
				MetodosOrdenacao m = new MetodosOrdenacao();			
				m.insertionSort(array1, 1);
				m.bubbleSort(array2, 1);
				m.selectionSort(array3, 1);	
				
				System.out.println("Voce escolheu o tipo de ordenação: " + msg);
				System.out.println("O tempo de ordenamento para o Insertion Sort foi: " + m.tempoInsertionSort);
				System.out.println("O tempo de ordenamento para o Bubble Sort foi: " + m.tempoBubbleSort);
				System.out.println("O tempo de ordenamento para o Selection Sort foi: " + m.tempoSelectionSort);
			} 
			// Numero Ordem: Decrescente
			if(tipoOrdenacao == 2){
				msg = "Decrescente";
				// System.out.println("Array original: " + Arrays.toString(array1));
				
				MetodosOrdenacao m = new MetodosOrdenacao();			
				m.insertionSort(array1, 2);
				m.bubbleSort(array2, 2);
				m.selectionSort(array3, 2);	
				
				System.out.println("Voce escolheu o tipo de ordenação: " + msg);				
				System.out.println("O tempo de ordenamento para o Insertion Sort foi: " + m.tempoInsertionSort);
				System.out.println("O tempo de ordenamento para o Bubble Sort foi: " + m.tempoBubbleSort);
				System.out.println("O tempo de ordenamento para o Selection Sort foi: " + m.tempoSelectionSort);
			}
		} 

		// Escolha de Ordem: Não
		if (selecionaOrdem == 2){
			msg = "Padrão = Crescente";		
			// System.out.println("Array original: " + Arrays.toString(array1));
			
			MetodosOrdenacao m = new MetodosOrdenacao();			
			m.insertionSort(array1);
			m.bubbleSort(array2);
			m.selectionSort(array3);	
			
			System.out.println("Voce escolheu o tipo de ordenação: " + msg);
			System.out.println("O tempo de ordenamento para o Insertion Sort foi: " + m.tempoInsertionSort);
			System.out.println("O tempo de ordenamento para o Bubble Sort foi: " + m.tempoBubbleSort);
			System.out.println("O tempo de ordenamento para o Selection Sort foi: " + m.tempoSelectionSort);
		}
	}

	public static class EscolhaOrdemException extends Exception{

		public String toString (){
			return "Seleção da Ordem Escolhida Inválida. Os valores são 1 - Sim e 2 - Não!";
		}

	}

	public static class NumeroOrdemException extends Exception{

		public String toString (){
			return "Numero da Ordem Escolhido Inválida. Os valores são 1 - Crescente e 2 - Descrescente!";
		}

	}


}
