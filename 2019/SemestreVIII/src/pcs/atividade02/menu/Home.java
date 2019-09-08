package pcs.atividade02.menu;

import java.util.LinkedList;

import pcs.atividade02.helpers.ScannerHelper;

public class Home {
	
	// PUBLICOS
	public static void main(String[] args) {
		executaTestes();		
		executaAlgoritimo();
	}
	
	public static void executaAlgoritimo () {
		ScannerHelper.wr("## EXECUÇÃO: Automatizada");

		ScannerHelper.wr("Quantos numeros voce quer digitar?");
		int qtdNumeros = ScannerHelper.leInt();
		LinkedList<Double> numeros = pedeUsuarioListaNumeros(qtdNumeros);

		Double media = calculaMedia(numeros);
		System.out.println("A média dos numeros digitados é: " + media);
		
		Double desvioPadrao = calculaDesvioPadrao(media, numeros);
		ScannerHelper.wr("O desvio padrão é de: " + desvioPadrao);
	}
	
	public static void executaTestes () {
		LinkedList<Double> lista01 = new LinkedList<Double>();
		lista01.add(160.0);
		lista01.add(591.0);
		lista01.add(114.0);
		lista01.add(229.0);
		lista01.add(230.0);
		lista01.add(270.0);
		lista01.add(128.0);
		lista01.add(1657.0);
		lista01.add(624.0);
		lista01.add(1503.0);
		
		LinkedList<Double> lista02 = new LinkedList<Double>();
		lista02.add(15.0);
		lista02.add(69.9);
		lista02.add(6.5);
		lista02.add(22.4);
		lista02.add(28.4);
		lista02.add(65.9);
		lista02.add(19.4);
		lista02.add(198.7);
		lista02.add(38.8);
		lista02.add(138.2);
		
		executaTeste01(lista01);
		executaTeste02(lista02);
	}
	
	// PRIVADOS
	private static LinkedList<Double> pedeUsuarioListaNumeros (int qtdNumeros) {
		LinkedList<Double> numeros = new LinkedList<Double>();
		for(int i = 1; i <= qtdNumeros; i++) {
			ScannerHelper.wr("Digite o " + i + "º número?");
			double numero = ScannerHelper.leDouble(); 
			numeros.addLast(numero);
		}
		return numeros;
	}
	
	private static void executaTeste01 (LinkedList<Double> numeros) {
		ScannerHelper.wr("## EXECUÇÃO: Teste 01");
		
		Double media = calculaMedia(numeros);
		ScannerHelper.wr("A média dos numeros digitados é: " + media);
		
		Double desvioPadrao = calculaDesvioPadrao(media, numeros);
		ScannerHelper.wr("O desvio padrão é de: " + desvioPadrao);
		
		ScannerHelper.wr("\n");
	}
	
	private static void executaTeste02 (LinkedList<Double> numeros) {
		ScannerHelper.wr("## EXECUÇÃO: Teste 02");
		
		Double media = calculaMedia(numeros);
		ScannerHelper.wr("A média dos numeros digitados é: " + media);
		
		Double desvioPadrao = calculaDesvioPadrao(media, numeros);
		ScannerHelper.wr("O desvio padrão é de: " + desvioPadrao);
		
		ScannerHelper.wr("\n");
	}
	
	private static Double calculaMedia (LinkedList<Double> numeros) {
		double somaNumeros = 0;
		for (int i = 0; i < numeros.size(); i++) {
			somaNumeros += numeros.get(i);
		}
		double mediaNumeros = somaNumeros / numeros.size();
		return mediaNumeros;
	}

	private static Double calculaDesvioPadrao (double mediaNumeros, LinkedList<Double> numeros) {
		// desvio medio
		double somaDesvioMedio = 0;
		LinkedList<Double> numerosDesvioMedio = new LinkedList<Double>();
		for (int i = 0; i < numeros.size(); i++) {
			Double numeroDesvioMedio = mediaNumeros - numeros.get(i);
			if (numeroDesvioMedio < 0) { 
				numeroDesvioMedio = numeroDesvioMedio * -1;
			}
			somaDesvioMedio += numeroDesvioMedio;
			numerosDesvioMedio.add(numeroDesvioMedio);
		}
		double desvioMedio = somaDesvioMedio / numerosDesvioMedio.size();
		
		
		// varianca
		double somaVarianca = 0;
		LinkedList<Double> numerosVarianca = new LinkedList<Double>();
		for (int i = 0; i < numerosDesvioMedio.size(); i++) {
			Double numeroDesvioMedio = numerosDesvioMedio.get(i);
			Double numeroVarianca = Math.pow(numeroDesvioMedio, 2);
			somaVarianca += numeroVarianca;
			numerosVarianca.add(numeroVarianca);
		}
		double varianca = somaVarianca / numerosVarianca.size();
		
		
		// desvio parão
		double desvioPadrao = Math.sqrt(varianca);
		
		return desvioPadrao;
	}
}
