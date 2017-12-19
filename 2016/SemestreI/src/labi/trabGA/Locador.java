package labi.trabGA;

/*
 * Aluno : Luis Henrique Valgoi | Trabalho GA | Turma:33 | 2016/1 
 */

public class Locador {
	private String nome;
	private double pontos;

	public Locador(String nome){
		this.nome = nome;
		this.pontos = 0;
	}

	public void ganhaPontos(double valorPagoPelaLocacao){
		double pontos = (valorPagoPelaLocacao / 10.00);
		this.pontos = this.pontos + pontos;
	}

	public String getNome(){
		return this.nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public double getPontos(){
		return this.pontos;
	}

	public void setPontos(double pontos){
		this.pontos = pontos;
	}	
}