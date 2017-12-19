package labi.aula01;

public class Pessoa {

	private String nome;
	private int idade;	

	public Pessoa(String n, int i){
		this.nome = n;
		this.idade = i;

		this.fazAniversario();
	}

	private void fazAniversario(){
		System.out.println(String.format("%s, você tem %s anos.", this.nome, this.idade));
	}
}
