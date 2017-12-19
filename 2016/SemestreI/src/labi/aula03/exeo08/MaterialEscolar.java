package labi.aula03.exeo08;


public class MaterialEscolar {
	
	private int codigo;
	private String nome;
	private double preco;
	private int qtdEstoque;

	public MaterialEscolar(int codigoT, String nomeT, double precoT, int qtdEstoqueT){
		this.codigo = codigoT;
		this.nome = nomeT;
		this.preco = precoT;
		this.qtdEstoque = qtdEstoqueT;
	}

	public void compraMaterial(int qtdComprada){
		this.qtdEstoque = this.qtdEstoque + qtdComprada;
	}

	public void vendeMaterial(int qtdVendida){
		this.qtdEstoque = this.qtdEstoque - qtdVendida;
	}

	public void setNome(String nomeT){
		this.nome = nomeT;
	}

	public void setPreco(double precoT){
		this.preco = precoT;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public String getNome() {
		return this.nome;
	}

	public double getPreco() {
		return this.preco;
	}

	public int getQtdEstoque() {
		return this.qtdEstoque;
	}	

}

