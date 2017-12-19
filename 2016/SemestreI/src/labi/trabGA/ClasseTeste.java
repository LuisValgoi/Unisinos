package labi.trabGA;

/*
 * Aluno : Luis Henrique Valgoi | Trabalho GA | Turma:33 | 2016/1 
 */

import java.util.Scanner;

public class ClasseTeste {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		Helpers.write("Digite o NOME do Propietario");
		String nomePropietario = teclado.nextLine();

		Helpers.write("Digite o ENDEREÇO do Propietario");
		String enderecoPropietario = teclado.nextLine();

		Helpers.write("Digite a PLACA do Carro");
		String placaCarro = teclado.nextLine();

		Helpers.write("Digite a DESCRICAO do Carro (marca, modelo, ano, etc.)");
		String descricaoCarro = teclado.nextLine();

		Helpers.write("Digite o PREÇO DA DIÁRIA do Carro");
		double precoDiariaCarro = teclado.nextDouble();

		Helpers.write("Digite a QUILOMETRAGEM do Carro");
		long quilometragemCarro = teclado.nextLong();

		Helpers.write("Quantos DIAS de Locação");
		int diasLocacao = teclado.nextInt();
		
		Helpers.write("Digite o NOME do Locador");
		String nomeLocador = teclado.next();		
		
		Helpers.write("** ------------------------- **");
		Carro carro = new Carro(placaCarro, descricaoCarro, nomePropietario, enderecoPropietario, precoDiariaCarro, quilometragemCarro);
		Locador locador = new Locador(nomeLocador);
		Locacao locacao = new Locacao(carro, locador);
		locador.setPontos(258);
		locacao.devolve(diasLocacao, 6500);
		locacao.exibeDados();
	}
}
