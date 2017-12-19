package labi.aula08.exe02;

import java.util.Scanner;

public class TesteMenu{

	public static void main(String args[]){
		//Declaração de variáveis
		Scanner t;
		GeraExibeSequenciaInteiros seq;
		int l1, l2;
		int op;

		//Instanciação de um teclado
		t = new Scanner(System.in);

		//Leitura e validação dos limites
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

		//Instanciação de um objeto da classe GeraExibeSequenciaInteiros
		seq = new GeraExibeSequenciaInteiros(l1, l2);

		//Repete, enquanto a opção for diferente de sair
		do{
			System.out.println ("\f Menu Principal ");
			System.out.println(" 1 – Gera e exibe inteiros");
			System.out.println(" 2 - Gera e exibe pares");
			System.out.println(" 3 - Gera e exibe múlt. comuns de 3 e 5");
			System.out.println(" 4 – Exibe a média arit. dos múltiplos");
			System.out.println(" 5 - Gera e exibe divisores");
			System.out.println(" 6 - Gera e exibe primos ");
			System.out.println(" 7 – Sair");

			
			//Leitura e validação da opção
			do{
				System.out.println("Escolha a opção: ");
				op = t.nextInt();

				if (op<1 || op>7){
					System.out.println("Opção inválida. Digite novamente!");
				}					
			}while (op<1 || op>7);

			
			// Verifica a opção do usuário e executa
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

			
			//Após a execução, se a opção não é sair, volta ao Menu
			if(op != 7){
				System.out.println("tecle Enter para voltar ao menu");
			}

		}//fim da repetição

		while(op != 7 );
	}
}