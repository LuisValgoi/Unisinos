package labi.aula07.exe01;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		Teste.escreve("Digite nome do Funcionário");
		String nomeF = teclado.nextLine();
		
		Teste.escreve("Digite o número de departamento do Funcionário");
		int numeroD = teclado.nextInt();

		Teste.escreve("Digite o nome de departamento do Funcionário");
		String nomeD = teclado.next();
		
		Teste.escreve("Digite o salario do Funcionário");
		double salarioF = teclado.nextDouble();
		
		Teste.escreve("Digite o código de Reajuste");
		int codigoReajuste = teclado.nextInt();
		
		if(codigoReajuste == 1 || codigoReajuste == 2 || codigoReajuste == 3){
			Funcionario func1 = new Funcionario(nomeF, numeroD, nomeD, salarioF);
			
			double valorSalarioAntigo = func1.getSalario();
			
			func1.reajustaSalario(codigoReajuste);
			
			double valorSalarioNovo = func1.getSalario();
			
			Teste.escreve("NOME FUNCIONARIO:");
			Teste.escreve(func1.getNome());
			
			Teste.escreve("SALARIO ANTERIOR:");
			Teste.escreve(valorSalarioAntigo);
			
			Teste.escreve("SALARIO REAJUSTADO:");
			Teste.escreve(valorSalarioNovo);
			
			Teste.escreve("NOME DO DEPARTAMENTO:");
			Teste.escreve(func1.getDepartamento().getNome());
			
		}else{
			Teste.escreve("Codigo de Reajuste inserido errado");
		}		
	}
	
	private static void escreve(String valor){
		System.out.println(valor);
	}
	
	private static void escreve(double valor){
		System.out.println(valor);
	}
}
