package labi.aula08.exe02;

import java.util.Scanner;

public class TesteMenu{

	public static void main(String args[]){
		//Declara��o de vari�veis
		Scanner t;
		GeraExibeSequenciaInteiros seq;
		int l1, l2;
		int op;

		//Instancia��o de um teclado
		t = new Scanner(System.in);

		//Leitura e valida��o dos limites
		do{
			System.out.println("Limite 1:");
			l1 = t.nextInt();
			
			System.out.println("Limite 2:");
			l2 = t.nextInt();
			
			if (l1 <= 0 || l2 <= 0){
				System.out.println("Os limites devem ser positivos!");
				System.out.println("Digite novamente!");
			}
		}while (l1 <= 0 || l2 <= 0);

		//Instancia��o de um objeto da classe GeraExibeSequenciaInteiros
		seq = new GeraExibeSequenciaInteiros(l1, l2);

		//Repete, enquanto a op��o for diferente de sair
		do{
			System.out.println ("\f Menu Principal ");
			System.out.println(" 1 � Gera e exibe inteiros");
			System.out.println(" 2 - Gera e exibe pares");
			System.out.println(" 3 - Gera e exibe m�lt. comuns de 3 e 5");
			System.out.println(" 4 � Exibe a m�dia arit. dos m�ltiplos");
			System.out.println(" 5 - Gera e exibe divisores");
			System.out.println(" 6 - Gera e exibe primos ");
			System.out.println(" 7 � Sair");

			
			//Leitura e valida��o da op��o
			do{
				System.out.println("Escolha a op��o: ");
				op = t.nextInt();

				if (op<1 || op>7){
					System.out.println("Op��o inv�lida. Digite novamente!");
				}					
			}while (op<1 || op>7);

			
			// Verifica a op��o do usu�rio e executa
			if (op ==1){
				seq.geraExibeInt();
			}
			else if (op ==2){
				seq.geraExibePares();
			}
			else if (op ==3){
				seq.geraExibeMultiplos();
			}
			else if (op ==4){
				seq.geraExibeMultiplosCalcMed(10);
			}
			else if (op ==5){
				seq.geraExibeDivisores();
			}
			else if (op ==6){
				seq.geraExibePrimos();
			}

			
			//Ap�s a execu��o, se a op��o n�o � sair, volta ao Menu
			if(op != 7){
				System.out.println("tecle Enter para voltar ao menu");
			}

		}//fim da repeti��o

		while(op != 7 );
	}
}