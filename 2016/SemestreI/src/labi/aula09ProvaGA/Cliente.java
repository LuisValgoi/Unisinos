package labi.aula09ProvaGA;

/*  Aluno: Luis Henrique Valgoi | Prova GA | Turma: 33 | Lab 1 */

public class Cliente {
	private String nome;
	private int pontos;
	
	public Cliente(String nomeP){
		this.nome = nomeP;
		this.pontos = 0;
	}
	
	public void creditaPontos(int p){
		this.pontos += p;
	}
	
	public void zeraPontos(){
		this.pontos = 0;
	}
	
	public void exibeDados(){
		System.out.println("Cliente "+ this.nome + ". " + this.getPontos() + " pontos.");
	}

	public int getPontos(){
		return this.pontos;
	}
}
