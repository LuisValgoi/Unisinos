package labi.trabGB;

/** Alunos : Luis Valgoi Trabalho GB Turma: 33 2016/1 */

public class LivroGratis extends Livro{
	private Anuncio[] anuncios;
	private int ultimoAnuncioExibido; // inteiro que indica a posi��o do array de an�ncios do �ltimo an�ncio apresentado
		
	//Ctor
	public LivroGratis(String titulo, int numeroPaginas, int qtdAnuncios) {
		super(titulo, numeroPaginas);
		super.setPreco(0);
		this.anuncios = new Anuncio[qtdAnuncios];		
		
		this.ultimoAnuncioExibido = 0;
	}
		
	// Getters and Setters
	public Anuncio[] getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(Anuncio[] anuncios) {
		this.anuncios = anuncios;
	}

	public int getUltimoAnuncioExibido() {
		return ultimoAnuncioExibido;
	}
	
	// M�todos Espec�ficos
	public void insereAnuncios(){
		// Para cada posi��o do array de an�ncios, instanciar um objeto do tipo Anuncio, lendo seu t�tulo do teclado
		for (int i = 0; i < getAnuncios().length; i++) {
			Helpers.wr("Digite o T�tulo do An�ncio de n�: " + i);
			String titulo = Helpers.leString();
			getAnuncios()[i] = new Anuncio(titulo);
		}
	}
	
	// Sobrescreve o m�todo de mesmo nome da superclasse. Faz tudo que o m�todo da superclasse faz, mais...
	public int fazLeitura(){
		int qtdPaginasLidas = super.fazLeitura();

		// Ao in�cio da sess�o de leitura, o pr�ximo an�ncio do array � exibido (fazer isso chamando o metodo da classe anuncio)
		getAnuncios()[getUltimoAnuncioExibido()].exibeDados();
		
		// Atualizar o atributo que controla o �ltimo an�ncio exibido		
		this.ultimoAnuncioExibido = pesquisaIndicePorTitulo(getAnuncios()[getUltimoAnuncioExibido()].getTitulo());
		//this.ultimoAnuncioExibido++;
		
		return qtdPaginasLidas;
	}
			
	public void exibeDadosDeAnuncios(){
		for (int i = 0; i < getAnuncios().length; i++) {
			getAnuncios()[i].exibeDados();
		}		
	}

	public void exibeDados(){
		// Dados dos livros
		super.exibeDados();		
		Helpers.wr("- Posi��o do �ltimo an�ncio apresentado: " + getUltimoAnuncioExibido());
		
		// Dados dos anuncios
		Helpers.wr("-- An�ncios:");
		exibeDadosDeAnuncios();
	}

	private int pesquisaIndicePorTitulo(String titulo){
		int index = 0;
		
		for (int i = 0; i < getAnuncios().length; i++) {
			if(getAnuncios()[i].getTitulo().equals(titulo)){
				index = i;
			}
		}
		return index;
	}
}
