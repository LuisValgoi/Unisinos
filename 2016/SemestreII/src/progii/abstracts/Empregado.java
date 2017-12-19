package progii.abstracts;

public abstract class Empregado {
	protected String nome, sobrenome, cpf;
	
	public Empregado(String nome, String sobrenome, String cpf) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public abstract double calculaSalario();

	@Override
	public String toString(){
		return String.format("[Nome: %], [Sobrenome: %], [Cpf: %]", getNome(), getSobrenome(), getCpf());		
	}
}
