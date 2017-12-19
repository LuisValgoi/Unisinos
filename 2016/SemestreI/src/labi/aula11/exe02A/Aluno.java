package labi.aula11.exe02A;


public class Aluno extends Pessoa {
	private Avaliacao avaliacao;

	public Aluno(String nome, int anoNascimento, Avaliacao avaliacao) {
		super(nome, anoNascimento);
		this.avaliacao = avaliacao;
	}

	public Aluno(String nome, int anoNascimento, int gA, int gB) {
		super(nome, anoNascimento);	
		avaliacao = new Avaliacao(gA, gB);
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	@Override
	public String toString() {
		String superString = super.toString();
		return superString + "\n" + this.avaliacao;		
	}
}
