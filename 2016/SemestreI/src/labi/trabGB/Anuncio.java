package labi.trabGB;

/** Alunos : Luis Valgoi Trabalho GB Turma: 33 2016/1 */

public class Anuncio {	
	private String titulo; 			// pode ser o nome do produto ou empresa que est� anunciando
	private int numeroExibicoes; 	//conta a quantidade de vezes que o an�ncio foi apresentado (exibido) no leitor digital.

	//Ctor
	public Anuncio(String titulo){
		this.setTitulo(titulo);
		this.setNumeroExibicoes(0);
	}

	// Getters and Setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumeroExibicoes() {
		return numeroExibicoes;
	}

	public void setNumeroExibicoes(int numeroExibicoes) {
		this.numeroExibicoes = numeroExibicoes;
	}

	// M�todos Espec�ficos
	public void exibe(){
		Helpers.wr("Exibido o an�ncio " + getTitulo());
		this.numeroExibicoes++;
	}
	
	public void exibeDados(){
		Helpers.wr("-- T�tulo do an�ncio: " + getTitulo());
		Helpers.wr("-- Quantidade de Exibi��es do an�ncio: " + getNumeroExibicoes());
	}
}
