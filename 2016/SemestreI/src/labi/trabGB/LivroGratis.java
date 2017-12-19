package labi.trabGB;

/** Alunos : Luis Valgoi Trabalho GB Turma: 33 2016/1 */

public class LivroGratis extends Livro{
	private Anuncio[] anuncios;
	private int ultimoAnuncioExibido; // inteiro que indica a posição do array de anúncios do último anúncio apresentado
		
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
	
	// Métodos Específicos
	public void insereAnuncios(){
		// Para cada posição do array de anúncios, instanciar um objeto do tipo Anuncio, lendo seu título do teclado
		for (int i = 0; i < getAnuncios().length; i++) {
			Helpers.wr("Digite o Título do Anùncio de nº: " + i);
			String titulo = Helpers.leString();
			getAnuncios()[i] = new Anuncio(titulo);
		}
	}
	
	// Sobrescreve o método de mesmo nome da superclasse. Faz tudo que o método da superclasse faz, mais...
	public int fazLeitura(){
		int qtdPaginasLidas = super.fazLeitura();

		// Ao início da sessão de leitura, o próximo anúncio do array é exibido (fazer isso chamando o metodo da classe anuncio)
		getAnuncios()[getUltimoAnuncioExibido()].exibeDados();
		
		// Atualizar o atributo que controla o último anúncio exibido		
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
		Helpers.wr("- Posição do último anúncio apresentado: " + getUltimoAnuncioExibido());
		
		// Dados dos anuncios
		Helpers.wr("-- Anúncios:");
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
