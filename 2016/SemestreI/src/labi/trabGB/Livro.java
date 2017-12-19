package labi.trabGB;

/** Alunos : Luis Valgoi Trabalho GB Turma: 33 2016/1 */

public class Livro {
	private String titulo;
	private int numeroDePaginas; 	// quantidade total de páginas do livro
	private double preco;
	private int tempoTotalLeitura; 	// em minutos
	private double percentualLido;
	private int interrupcao; 		//o número da página onde foi interrompida a leitura na última sessão de leitura que ocorreu
		
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
			
	// Métodos Específicos	
	public int fazLeitura(){
		int qtdPaginasNaoLidas = getNumeroDePaginas() - getInterrupcao();
		
		// Para simular a quantidade de páginas lidas durante a sessão: Calcular um inteiro randômico menor ou igual à quantidade de páginas que ainda não foram lidas
		int qtdPaginasLidas = 1 + (int)(Math.random() * (qtdPaginasNaoLidas - 1));

		// Calcular o tempo de leitura da sessão à razão de 3 minutos por página.
		int tempoLeitura = qtdPaginasLidas * 3;
		
		// Calcular o PercentualLido
		double percentualDasPaginasLidas = (qtdPaginasLidas * 100) / getNumeroDePaginas();		
		
		// Atualizar os três últimos atributos listados acima - tempoTotalLeitura / percentuaLido / interrupcao
		setTempoTotalLeitura(getTempoTotalLeitura() + tempoLeitura);
		setPercentualLido(getPercentualLido() + percentualDasPaginasLidas);
		setInterrupcao(getInterrupcao() + qtdPaginasLidas);
		
		return qtdPaginasLidas;
	}
	
	public void exibeDados(){
		Helpers.wr("- Título do Livro: " + getTitulo());
		Helpers.wr("- Quantidade Total de Páginas do Livro: " + getNumeroDePaginas());
		Helpers.wr("- Preço do Livro: R$ " + getPreco());
		Helpers.wr("- O Tempo Total de Leitura do Livro: " + getTempoTotalLeitura() + " minutos.");
		Helpers.wr("- Porcentagem de Leitura do Livro: " + getPercentualLido() + "%");
		Helpers.wr("- Última Página Lida: " + getInterrupcao());		
	}
}
