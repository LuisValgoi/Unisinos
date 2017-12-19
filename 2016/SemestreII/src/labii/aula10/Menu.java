package labii.aula10;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// 1 - LER DADOS DO ARQUIVO
		ArrayList<Cliente> clientes = lerDadosArquivo();

		// 2 - MENU OPERACOES
		menuOperacoes(clientes);
		
		// 3 - INSERCAO SOLICITADA
		insercaoFixa(clientes);
		
		// 4 - LISTA BRUNAS
		listaBruna(clientes);
		
		// 5 - MODIFICAR DATA ANIVER MELISSA
		modificarMelissa(clientes);
		
		// 6 - USAR A OPCAO 5 DO MENU
		usarOperacao05(clientes);	
		
		// 7 - REGISTRAR EM ARQUIVO
		registrarEmArquivo(clientes);		
	}
	
	
	private static ArrayList<Cliente> lerDadosArquivo(){
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		boolean prosseguir = true;
		do {			
			try {			
				Scanner teclado = new Scanner(System.in);
				
				Util.wr("Digite o nome do arquivo");
				String nomeArquivo = teclado.nextLine();			
				
				File file = new File(nomeArquivo);			
				FileReader fr = new FileReader(file);
				BufferedReader in = new BufferedReader(fr);			

				String line = in.readLine();
				line = in.readLine();			
				while (line != null) {
					String[] dados = buscaDadosDaLinha(line, "#");
					Cliente clienteAtual = new Cliente(dados[0], dados[1], dados[2], Double.parseDouble(dados[3]));
					clientes.add(clienteAtual);
					line = in.readLine();
				}

				in.close();
				prosseguir = true;

			} catch (FileNotFoundException e) {
				prosseguir = false;
				Util.wr("Não foi encontrado o arquivo com este nome: " + e.toString());
			} catch (Exception e) {
				prosseguir = false;
				Util.wr("Ocorreu algum erro: " + e.toString());
			}			
		} while (!prosseguir);	

		return clientes;
	}

	private static String[] buscaDadosDaLinha (String line, String pattern) {
		return line.split(pattern);
	} 

	private static void menuOperacoes(ArrayList<Cliente> clientes){
		int idOperacao = 0;
		boolean prosseguir = true;

		do {
			try {
				Scanner teclado = new Scanner(System.in);
				Util.wr("\nSegue o menu:");
				Util.wr("1- adicionar um novo cliente");
				Util.wr("2- consultar se um cliente com determinado nome existe");
				Util.wr("3- editar os dados cadastrais de um cliente existente");
				Util.wr("4- identificar e listar clientes que possuem o mesmo nome (1º nome)");
				Util.wr("5- identificar os 3 clientes que mais e menos gastam");
				Util.wr("6- registrar os dados em arquivo");
				Util.wr("\nQual sua escolha?");
				idOperacao = teclado.nextInt();
				
				if(idOperacao != 1 && idOperacao != 2 && idOperacao != 3 && idOperacao != 4 && idOperacao != 5 && idOperacao != 6)
					throw new InputMismatchException();				
				
				prosseguir = true;
				
			} catch (InputMismatchException e) {
				prosseguir = false;
				Util.wr("Escolha uma opçao certa!");
			} catch (Exception e) {
				prosseguir = false;
				Util.wr("Ops, algo aconteceu" + e.toString());
			}						
		} while (!prosseguir && idOperacao != 1 && idOperacao != 2 && idOperacao != 3 && idOperacao != 4 && idOperacao != 5 && idOperacao != 6);

				
		switch (idOperacao) {
		case 1:	
			operacao01(clientes);
			break;
		case 2:
			operacao02(clientes);
			break;
		case 3:
			operacao03(clientes);
			break;
		case 4:
			operacao04(clientes);
			break;
		case 5:			
			operacao05(clientes);
			break;
		case 6:
			operacao06(clientes);
			break;
		default:
			break;
		}
	}
	
	private static void operacao01(ArrayList<Cliente> clientes){
		Util.wr("Voce esta na opcao: 'adicionar um novo cliente'. Vamos lá!");

		String nome = null;
		String genero = null;
		String dataAniversario = null;
		double ultimaCompra = 0;
		
		boolean prosseguir = true;
		do {
			try {
				Scanner teclado = new Scanner(System.in);
				Util.wr("Digite o nome");
				nome = teclado.nextLine();
				
				Util.wr("Digite o genero");
				genero = teclado.nextLine();
				
				Util.wr("Digite a dataAniversario");
				dataAniversario = teclado.nextLine();
				
				Util.wr("Digite a ultimaCompra");
				ultimaCompra = teclado.nextDouble();				
				prosseguir = true;
				
			} catch (InputMismatchException e) {
				prosseguir = false;
				Util.wr("Voce digitou algum campo errado!");
			} catch (Exception e) {
				prosseguir = false;
				Util.wr("Ops, algo aconteceu" + e.toString());
			}
		} while (!prosseguir);
		
		Cliente cliente = new Cliente(nome, genero, dataAniversario, ultimaCompra);
		clientes.add(cliente);
		
		Util.wr("Criado com sucesso!");
	}

	private static void operacao02(ArrayList<Cliente> clientes){
		Util.wr("\nVoce esta na opcao: 'consultar se um cliente com determinado nome existe'. Vamos lá!");

		Scanner teclado = new Scanner(System.in);
		Util.wr("Digite o nome");
		String nome = teclado.nextLine();
		
		int count = 0;
		for (Cliente cliente : clientes) {
			if(cliente.getNome().split(" ")[0].equalsIgnoreCase(nome) || cliente.getNome().equalsIgnoreCase(nome)){
				Util.wr("Existe! Segue os dados:");
				Util.wr(cliente.toString());
				break;
			}else{
				count++;
				if(count == clientes.size())
					Util.wr("Não achei.");	
			}
		}		
	}
	
	private static void operacao03(ArrayList<Cliente> clientes){
		Util.wr("\nVoce esta na opcao: 'editar os dados cadastrais de um cliente existente'. Vamos lá!");	
		
		String genero = null;
		String dataAniversario = null;
		double ultimaCompra = 0;
		Cliente clienteParaEditar = null;
		
		Scanner teclado = new Scanner(System.in);
		Util.wr("Digite o nome para achar o cara para editar");
		String nome = teclado.nextLine();
		
		for (Cliente cliente : clientes) {
			if(cliente.getNome().split(" ")[0].equalsIgnoreCase(nome) || cliente.getNome().equalsIgnoreCase(nome)){
				Util.wr("Achei!");				

				boolean prosseguir = true;
				do {
					try {
						teclado = new Scanner(System.in);
						Util.wr("Digite o novo nome");
						nome = teclado.nextLine();
						
						Util.wr("Digite o novo genero");
						genero = teclado.nextLine();
						
						Util.wr("Digite a nova dataAniversario");
						dataAniversario = teclado.nextLine();
						
						Util.wr("Digite a nova ultimaCompra");
						ultimaCompra = teclado.nextDouble();				
						prosseguir = true;
						
					} catch (InputMismatchException e) {
						prosseguir = false;
						Util.wr("Voce digitou algum campo errado!");
					} catch (Exception e) {
						prosseguir = false;
						Util.wr("Ops, algo aconteceu" + e.toString());
					}
				} while (!prosseguir);
				
				clienteParaEditar = cliente;				
				break;
			}
		}		
		
		clienteParaEditar.setNome(nome);
		clienteParaEditar.setGenero(genero);
		clienteParaEditar.setDataAniversario(dataAniversario);
		clienteParaEditar.setUltimaCompra(ultimaCompra);
		Util.wr("Editado com sucesso!");
		
		for (Cliente cliente : clientes) {
			if(cliente.getNome().split(" ")[0].equalsIgnoreCase(nome) || cliente.getNome().equalsIgnoreCase(nome))
				cliente = clienteParaEditar;			
		}	
	}

	private static void operacao04(ArrayList<Cliente> clientes){
		Util.wr("\nVoce esta na opcao: 'identificar e listar clientes que possuem o mesmo nome (1º nome)'. Vamos lá!");
		
		ArrayList<Cliente> aux = (ArrayList<Cliente>) clientes.clone();
		Collections.sort(aux, new ClassificaPorNome());
		
		ArrayList<Cliente> clientesComNomesIguais = new ArrayList<Cliente>();		
		for (int i = 0; i < aux.size(); i++) {
			for (int j = i+1; j < aux.size(); j++) {
				if(aux.get(i).getNome().split(" ")[0].equalsIgnoreCase(aux.get(j).getNome().split(" ")[0])){
					clientesComNomesIguais.add(aux.get(i));
					clientesComNomesIguais.add(aux.get(j));
				}					
			}
		}
		
		Util.wr("Aqui estao os clientes com nomes iguais");
		for (Cliente cliente : clientesComNomesIguais) {
			Util.wr(cliente.toString());
		}
	}

	private static void operacao05(ArrayList<Cliente> clientes){
		Util.wr("\nVoce esta na opcao: 'identificar os 3 clientes que mais e menos gastam'. Vamos lá!");
		
		ArrayList<Cliente> aux = (ArrayList<Cliente>) clientes.clone();
		Collections.sort(aux, new ClassificaPorUltimaCompra());
		
		ArrayList<Cliente> clientesTresQueMaisGastaram = new ArrayList<Cliente>(3);
		ArrayList<Cliente> clientesTresQueMenosGastaram = new ArrayList<Cliente>(3);
		
		clientesTresQueMaisGastaram.add(aux.get(0));
		clientesTresQueMaisGastaram.add(aux.get(1));
		clientesTresQueMaisGastaram.add(aux.get(2));		

		clientesTresQueMenosGastaram.add(aux.get(aux.size() - 1));
		clientesTresQueMenosGastaram.add(aux.get(aux.size() - 2));
		clientesTresQueMenosGastaram.add(aux.get(aux.size() - 3));

		Util.wr("Os que menos gastaram: ");
		for (Cliente cliente : clientesTresQueMenosGastaram)
			Util.wr(cliente.toString());
		
		Util.wr("\nOs que mais gastaram: ");
		for (Cliente cliente : clientesTresQueMaisGastaram)
			Util.wr(cliente.toString());	
	}
	
	private static void operacao06(ArrayList<Cliente> clientes){
		Util.wr("\nVoce esta na opção 'registrar os dados em arquivo'. Vamos lá!");
		
		try {
			File file = new File("Operacao06.txt");
			FileWriter fr = new FileWriter(file);
			PrintWriter out = new PrintWriter(fr);	
			
			out.write("Nome | Gênero | Dt. Aniversário | Valor Compra");
			for (Cliente c : clientes) {				
				out.write("\n" + c.getNome() + " | " + c.getGenero() + " | " + c.getDataAniversario() + " | " + c.getUltimaCompra());
			}
			
			out.close();
			
		} catch (FileNotFoundException e) {
			Util.wr("Arquivo não encontado: " + e.toString());	
		} catch (Exception e) {
			Util.wr("Ocorreu um erro: " + e.toString());
		}
		
		Util.wr("Gerado com sucesso");
	}

	private static void insercaoFixa(ArrayList<Cliente> clientes){
		Util.wr("\nInserindo os 3 carinhas fixos...");
		Cliente c1 = new Cliente("Suzana Afonso de Sousa", "F", "12/03", 54.10);
		Cliente c2 = new Cliente("Heitor Augusto", "M", "29/01", 112.90);
		Cliente c3 = new Cliente("Eliane Mendes", "F", "18/05", 41.50);
		
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		Util.wr("Inserido");
	}

	private static void listaBruna(ArrayList<Cliente> clientes){
		Util.wr("\nEncontrei estas brunas:");
		
		ArrayList<Cliente> brunas = encontrarTodasPorNome(clientes, "Bruna");		
		for (Cliente cliente : brunas) {
			Util.wr(cliente.toString());
		}
	}
	
	private static void modificarMelissa(ArrayList<Cliente> clientes){
		Util.wr("\nModificando a data de aniver da melissa...");
		ArrayList<Cliente> melissas = encontrarTodasPorNome(clientes, "Melissa");		
		melissas.get(0).setDataAniversario("31/03");		
		Util.wr("Modificado.");
		Util.wr("Segue os dados: " + melissas.get(0));
	}
	
	private static void usarOperacao05(ArrayList<Cliente> clientes){
		operacao05(clientes);
	}
	
	private static void registrarEmArquivo(ArrayList<Cliente> clientes){
		operacao06(clientes);		
	}
	
	private static ArrayList<Cliente> encontrarTodasPorNome(ArrayList<Cliente> clientes, String nome){
		ArrayList<Cliente> clientesComNomeSolicitado = new ArrayList<Cliente>();
		
		for (Cliente cliente : clientes) {
			if(cliente.getNome().split(" ")[0].equalsIgnoreCase(nome)){
				clientesComNomeSolicitado.add(cliente);
			}			
		}
		
		return clientesComNomeSolicitado;
	}

}


