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
						System.out.println("O valor respectivo com 3 zeros � esquerda �: 000"+ a.getMenor());
					}					
					
					int valor = (int) (Math.random() * 101);
					a.setSegundoNumero(valor);					
					a.classificaOrdemCrescente();
					
					System.out.println("Depois das opera��es de numeros aleatorios e ordena��o: 1� - "+ a.getPrimeiroNumero());
					System.out.println("Depois das opera��es de numeros aleatorios e ordena��o: 2� - "+ a.getSegundoNumero());
					System.out.println("Depois das opera��es de numeros aleatorios e ordena��o: 3� - "+ a.getTerceiroNumero());
					
					int valor1 = ((int) (Math.random()*(105 - 5))) + 5;
					int valor2 = ((int) (Math.random()*(105 - 5))) + 5;
					int valor3 = ((int) (Math.random()*(105 - 5))) + 5;
					TresNumerosInteiros b = new TresNumerosInteiros(valor1, valor2, valor3);
					
					b.setSegundoNumero(b.getPrimeiroNumero() - b.getSegundoNumero());
					
					System.out.println("2� obj - 1� valor: "+ b.getPrimeiroNumero());
					System.out.println("2� obj - 2� valor: "+ b.getSegundoNumero());
					System.out.println("2� obj - 3� valor: "+ b.getTerceiroNumero());
					
					int auxA = a.getTerceiroNumero();
					int auxB = b.getTerceiroNumero();
					a.setTerceiroNumero(auxA);
					b.setTerceiroNumero(auxB);
					System.out.println("==============================");
					System.out.println("1� obj - 1� valor: "+ a.getPrimeiroNumero());
					System.out.println("1� obj - 2� valor: "+ a.getSegundoNumero());
					System.out.println("1� obj - 3� valor: "+ a.getTerceiroNumero());
					System.out.println("2� obj - 1� valor: "+ b.getPrimeiroNumero());
					System.out.println("2� obj - 2� valor: "+ b.getSegundoNumero());
					System.out.println("2� obj - 3� valor: "+ b.getTerceiroNumero());				
					
				}
			}
		}		
	}

}
