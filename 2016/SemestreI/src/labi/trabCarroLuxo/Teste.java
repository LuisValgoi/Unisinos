package labi.trabCarroLuxo;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		/* 2) Faça  uma classe de teste bastante rica (de forma a testar todos os métodos)
		 * para o exercício anterior, instanciando diversos carros (usando um comando de repetição).
		 * Devem ser instanciados carros e carros de luxo, usando a mesma variável do tipo Carro.
		 * No final, exiba totais e médias que achar interessante calcular e o carro mais econômico.
		 * Seja criativo!
		 */

		Carro carro = null;
		Carro carroMaisEconomico = null;
		double qtdKmParaSerPercorrido, quantoKmsTodosAndaram = 0, qtdParaPorNoTanque, qtdKmsMaior = 0, maiorKilometragem = 0;
		double consumo, tanque, kilometragem;
		boolean isArCondicionadoLigado, isCarroAptoParaAndar, isCarroAptoParaAbastecer;


		/* QUANTOS CARROS */
		wr("Quantos carros?");
		int qtdCarros = leInt();

		for(int i = 1; i <= qtdCarros; i++){

			/* SETA QUANTO CONSOME */
			wr("Quanto consome por litro?");
			consumo = leDouble();


			/* SETA QUANTOS LITROS O TANQUE TEM */
			wr("Quanto litros tem o tanque?");
			tanque = leDouble();


			/* SETA QUAL É A KILOMETRAGEM DO CARRO */
			wr("Qual é a kilometragem do carro?");
			kilometragem = leDouble();


			/* SETA SE É CARRO DE LUXO OU NÃO */
			char isCarroLuxo;
			do{
				wr("Carro de Luxo ou nem [S ou N]?");
				isCarroLuxo = leString().toUpperCase().charAt(0);

				if(isCarroLuxo != 'S' && isCarroLuxo != 'N'){
					wr("Escolha errada.");
				}
			}while(isCarroLuxo != 'S' && isCarroLuxo != 'N');

			
			if(isCarroLuxo == 'S'){
				carro = new CarroLuxo(tanque, consumo, kilometragem);
				
				/* SETA SE O AC TA LIGADO OU NÃO */
				char isLigadoTemp;
				do{
					wr("Deseja ligar o AC [S ou N]?");
					isLigadoTemp = leString().toUpperCase().charAt(0);

					if(isLigadoTemp != 'S' && isLigadoTemp != 'N'){
						wr("Escolha errada.");
					}
				}while(isLigadoTemp != 'S' && isLigadoTemp != 'N');

				if(isLigadoTemp == 'S'){
					CarroLuxo carroLuxo = (CarroLuxo)carro;
					carroLuxo.ligarAr();
					carro = carroLuxo;
				}				
			}else {
				carro = new Carro(tanque, consumo, kilometragem);
			}


			/* SETA QUAL É A KILOMETRAGEM QUE ANDARÁS */
			do{
				wr("Quanto kms andarás?");
				qtdKmParaSerPercorrido = leDouble();

				isCarroAptoParaAndar = carro.anda(qtdKmParaSerPercorrido);

				if(!isCarroAptoParaAndar){
					wr("A quantidade de Kilometros indicada que o carro irá percorrer, é maior do que a que ele pode. Tente novamente!");
				}
			}while(!isCarroAptoParaAndar);


			/* SETA QUANTOS LITROS DESEJA ABASTECER */
			char querAbastecer;
			do{
				wr("Deseja abastecer [S ou N]?");
				querAbastecer = leString().toUpperCase().charAt(0);

				if(querAbastecer != 'S' && querAbastecer != 'N'){
					wr("Escolha errada.");
				}
			}while(querAbastecer != 'S' && querAbastecer != 'N');

			if(querAbastecer == 'S'){
				do{
					wr("Digite a quantidade de litros para por no tanque");
					qtdParaPorNoTanque = leDouble();

					isCarroAptoParaAbastecer = carro.abastece(qtdParaPorNoTanque);

					if(!isCarroAptoParaAbastecer){
						wr("A quantidade de Litros indicada que o carro irá abastecer, é maior do que a que ele pode. Tente novamente!");
					}
				}while(!isCarroAptoParaAbastecer);
			}else{
				wr("Ok.");
			}


			/* SETA QUANTO KILOMETROS TODOS CARROS ANDARAM */
			quantoKmsTodosAndaram = quantoKmsTodosAndaram + qtdKmParaSerPercorrido;


			/* SETA QUAL FOI A VIAGEM MAIS LONGA */
			if(qtdKmsMaior == 0){
				qtdKmsMaior = qtdKmParaSerPercorrido;
			}
			if(qtdKmParaSerPercorrido > qtdKmsMaior){
				qtdKmsMaior = qtdKmParaSerPercorrido;
			}


			/* SETA O CARRO DE MAIOR KILOMETRAGEM */
			if(maiorKilometragem == 0){
				maiorKilometragem = kilometragem;
			}
			if(kilometragem > maiorKilometragem){
				maiorKilometragem = kilometragem;
			}


			/* SETA O CARRO MAIS ECONOMICO */
			if(carroMaisEconomico == null){
				carroMaisEconomico = carro;
			}
			if(carro.getConsumo() < carroMaisEconomico.getConsumo()){
				carroMaisEconomico = carro;
			}


			/* CHAMA RELATORIO 1 */
			wr(carro.status());
			wr("************************************************");
		}

		/* CHAMA RELATORIO 2 */
		wr("Todos os carros andaram: " + quantoKmsTodosAndaram + "km.");
		wr("O carro mais econômico é o que consome: " + carro.getConsumo() + "km/l.");
		wr("A viagem mais longa foi de: " + qtdKmsMaior + "kms.");
		wr("A maior kilometragem dos carros cadastrados é: " + maiorKilometragem + "kms.");
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
}
