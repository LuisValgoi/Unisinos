package labi.aula10.exe05;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int numFuncionarios = 0;
		double totalPagoSalarioAntesReajuste = 0;
		double maiorSalarioAposReajuste = 0;
		double todosSalarioDepartamento3 = 0;
		double salarioMedioDepartamento3AposReajuste = 0;		

		char resp;
		do{
			Teste.escreve("Quer entrar com dados [S-sim N-não] ? ");
			String temp = teclado.nextLine();			
			resp = temp.charAt(0);			
		} while (resp != 'S' && resp != 'N');
		
		if(resp == 'N' || resp == 'n'){
			Teste.escreve("ok");
		}
		
		while(resp == 'S'){
			
			/* NOME FUNCIONARIO */
			String nomeF;
			Teste.escreve("Entre com o nome do funcionário:");
			nomeF = teclado.next();

			/* NUMERO DEPARTAMENTO */
			int numeroD;
			do{
				Teste.escreve("Digite o número de departamento do Funcionário");
				numeroD = teclado.nextInt();

				if(numeroD <= 0){
					Teste.escreve("Escolha errada. Digite novamente");
				}
			}while(numeroD <= 0);

			/* NOME DEPARTAMENTO */
			Teste.escreve("Digite o nome de departamento do Funcionário");
			String nomeD = teclado.next();

			/* SALARIO FUNCIONARIO */
			Teste.escreve("Digite o salario do Funcionário");
			double salarioF = teclado.nextDouble();

			/* CODIGO REAJUSTE */
			int codigoReajuste;
			do{
				Teste.escreve("Digite o código de Reajuste");
				codigoReajuste = teclado.nextInt();

				if(codigoReajuste < 0 || (codigoReajuste != 1 && codigoReajuste != 2 && codigoReajuste != 3)){
					Teste.escreve("Escolha errada. Digite novamente");
				}
			}while(codigoReajuste < 0 || (codigoReajuste != 1 && codigoReajuste != 2 && codigoReajuste != 3));

			Funcionario func = new Funcionario(nomeF, numeroD, nomeD, salarioF);

			/* SET = TOTAL PAGO EM SALARIO ANTES DO REAJUSTE */
			totalPagoSalarioAntesReajuste += func.getSalario();

			func.reajustaSalario(codigoReajuste);

			/* SET = MAIOR SALARIO DA EMPRESA APOS O REAJUSTE */
			if (maiorSalarioAposReajuste < func.getSalario()){
				maiorSalarioAposReajuste = func.getSalario();
			}

			if(func.getDepartamento().getNumero() == 3){
				todosSalarioDepartamento3 += func.getSalario();
			}

			/* SET = SALARIO MEDIO DO DEPARTAMENTO 3 APOS REAJUSTE */
			if(todosSalarioDepartamento3 > 0){
				salarioMedioDepartamento3AposReajuste = todosSalarioDepartamento3 / numFuncionarios;	
			}	
			numFuncionarios++;
			
			Teste.escreve("Quer entrar com dados [S-sim N-não] ? ");
			String temp = teclado.next();
			resp = temp.charAt(0);
		}
		
		System.out.println("=========================");
		Teste.escreve("TOTAL PAGO EM SALARIO ANTES DO REAJUSTE: " + totalPagoSalarioAntesReajuste);
		Teste.escreve("MAIOR SALARIO DA EMPRESA APOS O REAJUSTE: " + maiorSalarioAposReajuste);
		Teste.escreve("SALARIO MEDIO DO DEPARTAMENTO 3 APOS REAJUSTE: " + salarioMedioDepartamento3AposReajuste);
	}

	private static void escreve(String valor){
		System.out.println(valor);
	}
}
