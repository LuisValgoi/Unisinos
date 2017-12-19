package labi.aula06.exe04;

public class Aluno {
	
	private String nome;
	private Avaliacao avaliacao;
	
	public Aluno(String nome) {
		this.nome = nome;		
	}
	
	public Aluno(String nome, Avaliacao avaliacao) {
		this.nome = nome;
		this.avaliacao = avaliacao;
	}
	
	public Aluno(String nome, double nGA, double nGB) {
		this.nome = nome;
		this.avaliacao = new Avaliacao(nGB, nGB); 
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(double nGA, double nGB) {
		this.avaliacao = new Avaliacao(nGA, nGB);
	}	
}
