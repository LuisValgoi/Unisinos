package labi.aula11.exe02A;


public class Pessoa {
	
	private String nome;
	private int anoNascimento;		
	
	public Pessoa(String nome, int anoNascimento) {
		this.nome = nome;
		this.anoNascimento = anoNascimento;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getAnoNascimento() {
		return anoNascimento;
	}
	
	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	
	public Pessoa maisVelha(Pessoa outra){		
		if (this.anoNascimento < outra.anoNascimento){
			return this;
		}else{
			return outra;
		}	
	}
	
	@Override
	public String toString() {
		String nome = "Nome: " + this.nome;
		String ano = "Ano de Nascimento: " + this.anoNascimento;
		return nome + "\n" + ano;		
	}
}
