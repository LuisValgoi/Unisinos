package labi.aula04.exe03;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class TesteCalculadora {
	
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite o 1º Número");
		double n1 = teclado.nextDouble();	
		
		System.out.println("\nQual operação você deseja fazer? \nSOMAR,SUBTRAIR,MULTIPLICAR,RESTO,DIVIDIR");
		String operacao = teclado.next();
		
		System.out.println("\nDigite o 2º Número");
		double n2 = teclado.nextDouble();		
		
		double resultado = setOperation(operacao, n1, n2);		
		System.out.println("\nO resultado é: " + resultado);
	}
	
	public static int setOperation(String operacao, int n1, int n2){
		
		Calculadora calc = new Calculadora();
		
		int resposta = 0;	
		
		if(operacao.equalsIgnoreCase("SOMAR") || operacao.equalsIgnoreCase("SOMA")){
			resposta = calc.soma(n1, n2);
		}else if(operacao.equalsIgnoreCase("SUBTRAIR")){
			resposta = calc.subtrai(n1, n2);
		}else if(operacao.equalsIgnoreCase("MULTIPLICAR")){
			resposta = calc.multiplica(n1, n2);
		}else if(operacao.equalsIgnoreCase("DIVIDIR") || operacao.equalsIgnoreCase("DIVIDI")){
			resposta = calc.divideReal(n1, n2);
		}else if(operacao.equalsIgnoreCase("RESTO")){
			resposta = (int)calc.divideResto(n1, n2);
		}
		
		return resposta;
	}
	
	public static double setOperation(String operacao, double n1, double n2){
		
		Calculadora calc = new Calculadora();
		
		double resposta = 0;		
		
		if(operacao.equalsIgnoreCase("SOMAR") || operacao.equalsIgnoreCase("SOMA")){
			resposta = calc.soma(n1, n2);
		}else if(operacao.equalsIgnoreCase("SUBTRAIR")){
			resposta = calc.subtrai(n1, n2);
		}else if(operacao.equalsIgnoreCase("MULTIPLICAR")){
			resposta = calc.multiplica(n1, n2);
		}else if(operacao.equalsIgnoreCase("DIVIDIR") || operacao.equalsIgnoreCase("DIVIDI")){
			resposta = calc.divideReal(n1, n2);
		}else if(operacao.equalsIgnoreCase("RESTO")){
			resposta = calc.divideResto(n1, n2);
		}
		
		return resposta;
	}	
}
