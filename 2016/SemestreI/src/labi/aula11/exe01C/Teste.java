package labi.aula11.exe01C;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {		
		double folhaPagamento = 0;				
		double salarioMedio = 0;
		int qtdFunc = 0;		
		Funcionario func;
		Funcionario maisFodao = null;
		
		double folhaPagamentoDoDepartamentoDois = 0;
		int qtdFuncDoDepartamentoDois = 0;
		
		char resp;
		do {
			wr("Quer entrar com dados [S-sim N-n�o] ?");
			resp = Character.toUpperCase(leChar());			 
		} while ((resp != 'S' && resp != 'N') || resp == 'N');		
		
		while(resp == 'S' || resp == 's'){			
			int tipo;
			
			/* SORTEIA O FUNCIONARIO */
			tipo = 1 + (int)(Math.random() * 2);
			wr("Tipo Funcionario Sorteado: " + tipo);
			
			
			/* PEGA O NOME */
			wr("\nNome?");
			String nome = leString();
			
			
			/* PEGA O SALARIO */
			wr("Salario?");
			double salario = leDouble();
			
			
			/* PEGA O NUMERO DO DEPARTAMENTO */
			wr("Numero Departamento?");
			int numDep = leInt();

			
			/* PEGA O NOME DO DEPARTAMENTO */
			wr("Nome Departamento?");
			String nomeDep = leString();
			
			
			/* SETA O TIPO DE FUNCIONARIO */
			String nomeSecretario;			
			if(tipo == 2){
				func = new Funcionario(nome, numDep, nomeDep, salario);				
			}
			else{
				wr("Nome Secret�rio?");
				nomeSecretario = leString();
				
				func = new Gerente(nome, numDep, nomeDep, salario);
				Gerente gerente = (Gerente) func;
				gerente.setNomeSecretario(nomeSecretario);
			}		
			
			/* PEGA O CODIGO REAJUSTE */
			int cod;			
			do{
				wr("Codigo Reajuste?");
				cod = leInt();
				
				if(cod != 1 && cod != 2 && cod != 3){
					wr("Seu idiota, escreva um numero certo!");
				}
			}while(cod != 1 && cod != 2 && cod != 3 && cod != 0);
			
			
			/* REAJUSTA O SALARIO */
			func.reajustaSalario(cod);
			
			
			/* SETO A FOLHA DE PAGAMENTO */
			folhaPagamento += func.getSalario();
			
			
			/* MANIPULA OS FUNCIONARIOS DO DEPARTAMENTO 2 */
			if(func.getDepartamento().getNumero() == 2){
				qtdFuncDoDepartamentoDois++;
				folhaPagamentoDoDepartamentoDois += func.getSalario();
			}
			
			/* PEGA O FUNCIONARIO QUE TEM MAIOR SALARIO */
			if(maisFodao != null){
				if(func.getSalario() > maisFodao.getSalario()){
					maisFodao = func;
				}
			}else{
				maisFodao = func;
			}
			wr("===============================");
		}
		
		wr("O valor da folha de pagamento (sal�rio total da empresa) ap�s o reajuste �:" + folhaPagamento);
		
		wr("O nome do funcion�rio ou gerente com o maior sal�rio ap�s o reajuste �: " + maisFodao.getNome());
		wr("O salario do funcion�rio ou gerente com o maior sal�rio ap�s o reajuste �: " + maisFodao.getSalario());
		wr("O nome do departamento do funcion�rio ou gerente com o maior sal�rio ap�s o reajuste �: " + maisFodao.getDepartamento().getNome());
		wr("O numero do departamento do funcion�rio ou gerente com o maior sal�rio ap�s o reajuste �: " + maisFodao.getDepartamento().getNumero());
		
		if(qtdFuncDoDepartamentoDois != 0){
			wr("O sal�rio m�dio, ap�s o reajuste, dos funcion�rios (incluindo os gerentes) do departamento 2 �: " + folhaPagamentoDoDepartamentoDois / qtdFuncDoDepartamentoDois);
		}else if(qtdFuncDoDepartamentoDois == 0 || qtdFuncDoDepartamentoDois < 0){ 
			wr("O sal�rio m�dio, ap�s o reajuste, dos funcion�rios (incluindo os gerentes) do departamento 2 �: N�O FOI POSSIVEL CALCULAR POIS N�O TEM FUNCIONARIOS DO DEPARTAMENTO 2");	
		}		
	}
	
	public static void wr(String v){
		System.out.println(v);
	}
	
	public static String leString(){
		Scanner teclado = new Scanner (System.in);
		return teclado.nextLine();
	}
	
	public static int leInt(){
		Scanner teclado = new Scanner (System.in);
		return teclado.nextInt();
	}
	
	public static double leDouble(){
		Scanner teclado = new Scanner (System.in);
		return teclado.nextDouble();
	}
	
	public static char leChar(){
		Scanner teclado = new Scanner (System.in);
		String value = teclado.nextLine();
		return value.charAt(0);
	}
}
