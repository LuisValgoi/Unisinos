package labi.aula03.exeo08;


public class TesteMaterialEscolar {
	
	public static void main (String[] args0){
		MaterialEscolar caneta = new MaterialEscolar(23, "caneta", 7.5, 20);

		//Comprar ou vender
		caneta.compraMaterial(7);
		caneta.vendeMaterial(3);	
		
		// Busca de valores
		int codigo = caneta.getCodigo();
		String nome = caneta.getNome();
		double preco = caneta.getPreco();
		int qtd = caneta.getQtdEstoque();		
		
		// Impressão no console
		System.out.println(String.format("O código é: %s. \n O Nome é: %s. \n O preço é: %s. \n A quantidade de em estoque é: %s.", codigo, nome, preco, qtd));

	}
} 
