package labi.aula06.exe07.B;

import java.util.Scanner;

public class TesteTresNumerosInteiros {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);		
		
		int primeiroValor = Integer.MIN_VALUE;
		int segundoValor = Integer.MIN_VALUE;
		int terceiroValor = Integer.MIN_VALUE;
		
		System.out.println("Digite o primeiro numero");
		primeiroValor = teclado.nextInt();
		
		if(primeiroValor < 0){
			System.out.println("Primeiro Numero INVALIDO");	
		}else{
			System.out.println("Digite o segundo numero");
			segundoValor = teclado.nextInt();
			
			if(segundoValor < 0){
				System.out.println("Segundo Numero INVALIDO");				
			}else{
				System.out.println("Digite o terceiro numero");
				terceiroValor = teclado.nextInt();
				
				if(terceiroValor < 0){
					System.out.println("Terceiro Numero INVALIDO");
				}else{
					TresNumerosInteiros a = new TresNumerosInteiros(primeiroValor, segundoValor, terceiroValor);
					
					System.out.println("Maior numero: " + a.getMaior());
					System.out.println("Menor numero: " + a.getMenor());
					
					int qtdDigitosMaior = String.valueOf(a.getMaior()).length();
					int qtdDigitosMenor =  String.valueOf(a.getMenor()).length();
					
					System.out.println("O maior numero tem : " + qtdDigitosMaior + " digitos");
					System.out.println("O menor numero tem : " + qtdDigitosMenor + " digitos");
					
					if(qtdDigitosMenor < 3){
						System.out.println("O valor respectivo com 3 zeros à esquerda é: 000"+ a.getMenor());
					}					
					
					int valor = (int) (Math.random() * 101);
					a.setSegundoNumero(valor);					
					a.classificaOrdemCrescente();
					
					System.out.println("Depois das operações de numeros aleatorios e ordenação: 1º - "+ a.getPrimeiroNumero());
					System.out.println("Depois das operações de numeros aleatorios e ordenação: 2º - "+ a.getSegundoNumero());
					System.out.println("Depois das operações de numeros aleatorios e ordenação: 3º - "+ a.getTerceiroNumero());
					
					int valor1 = ((int) (Math.random()*(105 - 5))) + 5;
					int valor2 = ((int) (Math.random()*(105 - 5))) + 5;
					int valor3 = ((int) (Math.random()*(105 - 5))) + 5;
					TresNumerosInteiros b = new TresNumerosInteiros(valor1, valor2, valor3);
					
					b.setSegundoNumero(b.getPrimeiroNumero() - b.getSegundoNumero());
					
					System.out.println("2º obj - 1º valor: "+ b.getPrimeiroNumero());
					System.out.println("2º obj - 2º valor: "+ b.getSegundoNumero());
					System.out.println("2º obj - 3º valor: "+ b.getTerceiroNumero());
					
					int auxA = a.getTerceiroNumero();
					int auxB = b.getTerceiroNumero();
					a.setTerceiroNumero(auxA);
					b.setTerceiroNumero(auxB);
					System.out.println("==============================");
					System.out.println("1º obj - 1º valor: "+ a.getPrimeiroNumero());
					System.out.println("1º obj - 2º valor: "+ a.getSegundoNumero());
					System.out.println("1º obj - 3º valor: "+ a.getTerceiroNumero());
					System.out.println("2º obj - 1º valor: "+ b.getPrimeiroNumero());
					System.out.println("2º obj - 2º valor: "+ b.getSegundoNumero());
					System.out.println("2º obj - 3º valor: "+ b.getTerceiroNumero());				
					
				}
			}
		}		
	}

}
