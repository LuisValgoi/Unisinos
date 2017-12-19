package labi.trabGA;

/*
 * Aluno : Luis Henrique Valgoi | Trabalho GA | Turma:33 | 2016/1 
 */

public class Propietario {
	private String nome;
	private String endereco;
	private double totalFaturado;

	public Propietario(String n, String e){
		this.nome = n;
		this.endereco = e;
	}

	public void credita(double partePropietarioTotalF){
		this.totalFaturado += partePropietarioTotalF;
	}

	public void exibeDados(){
		Helpers.write("\n** DADOS SOBRE O PROPIETÁRIO **");
		Helpers.write("O Nome do Propietário é: " + getNome() + ".");	
		Helpers.write("O Endereço do Propietário é: " + getEndereco() + ".");		
		Helpers.write("O Total de faturamento do Propietário é: " + getTotalFaturado() + " R$.");
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getTotalFaturado() {
		return this.totalFaturado;
	}

	public void setTotalFaturado(double totalFaturado) {
		this.totalFaturado = totalFaturado;
	}

}
