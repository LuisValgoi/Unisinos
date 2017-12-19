package labi.trabGB;

/** Alunos : Luis Valgoi Trabalho GB Turma: 33 2016/1 */

public class Livro {
	private String titulo;
	private int numeroDePaginas; 	// quantidade total de p�ginas do livro
	private double preco;
	private int tempoTotalLeitura; 	// em minutos
	private double percentualLido;
	private int interrupcao; 		//o n�mero da p�gina onde foi interrompida a leitura na �ltima sess�o de leitura que ocorreu
		
	//Ctor
	public Livro(String titulo, int numeroPaginas){
		this.setTitulo(titulo);
		this.setNumeroDePaginas(numeroPaginas);
		this.setPreco(numeroPaginas * 0.15);
		
		this.setTempoTotalLeitura(0);
		this.setPercentualLido(0);
		this.setInterrupcao(0);
	}
	
	// Getters and Setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public void setNumeroDePaginas(int numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getTempoTotalLeitura() {
		return tempoTotalLeitura;
	}

	public void setTempoTotalLeitura(int tempoTotalLeitura) {
		this.tempoTotalLeitura = tempoTotalLeitura;
	}

	public double getPercentualLido() {
		return percentualLido;
	}

	public void setPercentualLido(double percentualLido) {
		this.percentualLido = percentualLido;
	}

	public int getInterrupcao() {
		return interrupcao;
	}

	public void setInterrupcao(int interrupcao) {
		this.interrupcao = interrupcao;
	}
			
	// M�todos Espec�ficos	
	public int fazLeitura(){
		int qtdPaginasNaoLidas = getNumeroDePaginas() - getInterrupcao();
		
		// Para simular a quantidade de p�ginas lidas durante a sess�o: Calcular um inteiro rand�mico menor ou igual � quantidade de p�ginas que ainda n�o foram lidas
		int qtdPaginasLidas = 1 + (int)(Math.random() * (qtdPaginasNaoLidas - 1));

		// Calcular o tempo de leitura da sess�o � raz�o de 3 minutos por p�gina.
		int tempoLeitura = qtdPaginasLidas * 3;
		
		// Calcular o PercentualLido
		double percentualDasPaginasLidas = (qtdPaginasLidas * 100) / getNumeroDePaginas();		
		
		// Atualizar os tr�s �ltimos atributos listados acima - tempoTotalLeitura / percentuaLido / interrupcao
		setTempoTotalLeitura(getTempoTotalLeitura() + tempoLeitura);
		setPercentualLido(getPercentualLido() + percentualDasPaginasLidas);
		setInterrupcao(getInterrupcao() + qtdPaginasLidas);
		
		return qtdPaginasLidas;
	}
	
	public void exibeDados(){
		Helpers.wr("- T�tulo do Livro: " + getTitulo());
		Helpers.wr("- Quantidade Total de P�ginas do Livro: " + getNumeroDePaginas());
		Helpers.wr("- Pre�o do Livro: R$ " + getPreco());
		Helpers.wr("- O Tempo Total de Leitura do Livro: " + getTempoTotalLeitura() + " minutos.");
		Helpers.wr("- Porcentagem de Leitura do Livro: " + getPercentualLido() + "%");
		Helpers.wr("- �ltima P�gina Lida: " + getInterrupcao());		
	}
}
