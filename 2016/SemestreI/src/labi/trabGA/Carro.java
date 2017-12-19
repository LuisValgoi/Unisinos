package labi.trabGA;

/*
 * Aluno : Luis Henrique Valgoi | Trabalho GA | Turma:33 | 2016/1 
 */

public class Carro {
	private String placa;
	private String descricao;
	private Propietario dono;
	private double precoDiaria;
	private int maiorLocacao;
	private long quilometragem;

	public Carro(String placa, String descricao, Propietario objDonoCarro, double precoDiaria, long quilometragem){
		this.placa = placa;
		this.descricao = descricao;
		this.dono = objDonoCarro;
		this.precoDiaria = precoDiaria;
		this.quilometragem = quilometragem;
	}

	public Carro(String placa, String descricao, String nomeP, String enderecoP, double precoDiaria, long quilometragem){
		this.placa = placa;
		this.descricao = descricao;
		this.dono = new Propietario(nomeP, enderecoP);
		this.precoDiaria = precoDiaria;
		this.quilometragem = quilometragem;
	}

	public void maiorLocacao(int qtdDiarias){
		if (this.maiorLocacao < qtdDiarias){
			this.maiorLocacao = qtdDiarias;
		}
	}

	public void exibeDados(){
		dono.exibeDados();
		Helpers.write("\n** DADOS SOBRE O CARRO **");
		Helpers.write("A Placa do Carro é: " + getPlaca() + ".");
		Helpers.write("A Descrição do Carro é: " + getDescricao() + ".");		
		Helpers.write("O Preço da Diária do Carro é: " + getPrecoDiaria() + " R$.");
		Helpers.write("A Quilometragem do Carro é: " + getQuilometragem() + " km.");
		Helpers.write("A Quantidade de Dias que a Maior Locação deste Carro teve foi: " + getMaiorLocacao()  + " dias.");
	}

	public void setDono(Propietario dono){
		this.dono = dono;
	}

	public void setPrecoDiaria(double precoDiaria){
		this.precoDiaria = precoDiaria;
	}

	public void setQuilometragem(long quilometragem){
		this.quilometragem = quilometragem;
	}

	public String getPlaca(){
		return this.placa;
	}

	public String getDescricao(){
		return this.descricao;
	}

	public double getPrecoDiaria(){
		return this.precoDiaria;
	}

	public int getMaiorLocacao(){
		return this.maiorLocacao;
	}

	public long getQuilometragem(){
		return this.quilometragem;
	}

	public Propietario getDono(){
		return this.dono;
	}

}
