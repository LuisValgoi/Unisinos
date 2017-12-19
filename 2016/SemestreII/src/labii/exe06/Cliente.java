package labii.exe06;

import java.io.Serializable;

public class Cliente implements Serializable{

	private String nome;
	private int idade;
	private String sexo;
	private String renda;
	private String empregado;
	private String credito;

	public Cliente(String nome, int idade, String sexo, String renda, String empregado, String credito) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.renda = renda;
		this.empregado = empregado;
		this.credito = credito;
	}
	
	public Cliente(String nome, int idade, String credito) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.credito = credito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRenda() {
		return renda;
	}

	public void setRenda(String renda) {
		this.renda = renda;
	}

	public String getEmpregado() {
		return empregado;
	}

	public void setEmpregado(String empregado) {
		this.empregado = empregado;
	}

	public String getCredito() {
		return credito;
	}

	public void setCredito(String credito) {
		this.credito = credito;
	}

}
