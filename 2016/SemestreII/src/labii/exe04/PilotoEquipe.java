package labii.exe04;

public class PilotoEquipe implements PilotoEquipeInterface, Comparable<PilotoEquipe> {
	
	public String nomePiloto;
	public String nomeEquipe;
	public double pontuacao;	
	
	public PilotoEquipe(String nomePiloto, String nomeEquipe, double pontuacao) {
		this.nomePiloto = nomePiloto;
		this.nomeEquipe = nomeEquipe;
		this.pontuacao = pontuacao;
	}

	public String getNome() {
		return this.nomePiloto;
	}

	public void setNome(String nome) {
		this.nomePiloto = nome;
	}

	public String getEquipe() {
		return this.nomeEquipe;
	}

	public void setEquipe(String equipe) {
		this.nomeEquipe = equipe;
	}

	public double getPontos() {
		return this.pontuacao;
	}

	public void setPontos(double pontos) {
		this.pontuacao = pontos;
	}

	public int compareTo(PilotoEquipe pilotoEquipe) {
		return (int) (pilotoEquipe.getPontos() - this.pontuacao);
	}

}
