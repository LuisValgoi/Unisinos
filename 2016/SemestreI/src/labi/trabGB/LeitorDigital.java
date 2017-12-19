package labi.trabGB;

/** Alunos : Luis Valgoi Trabalho GB Turma: 33 2016/1 */

public class LeitorDigital {
	private Livro[] estante; 			// armazena os livros baixados pelo usuário para serem lidos através do aplicativo.
	private double precoPorExibicao;	// o que vai custar ao anunciante por cada exibição de seu anúncio
	private double faturamento;			// vai acumular toda a renda do aplicativo, com a venda dos Livros baixados e com os anúncios mostrados

	// Ctor
	public LeitorDigital(int qtdMaximaDeLivrosDaEstante){
		this.estante = new Livro[qtdMaximaDeLivrosDaEstante];
		this.precoPorExibicao = 2.50;
		this.faturamento = 0;
	}

	// Getters and Setters
	public Livro[] getEstante(){
		return estante;
	}

	public double getPrecoPorExibicao(){
		return precoPorExibicao;
	}

	public double getFaturamento(){
		return faturamento;
	}

	public void setPrecoPorExibicao(double precoPorExibicao) {
		this.precoPorExibicao = precoPorExibicao;
	}

	public void setFaturamento(double faturamento) {
		this.faturamento = faturamento;
	}

	// Metodos Específicos
	public Livro buscaLivro(String texto){
		// Recebe texto como parâmetro e procura na estante um livro com este título
		for (int i = 0; i < getEstante().length; i++) {
			if(getEstante()[i] != null){
				if(getEstante()[i].getTitulo().equalsIgnoreCase(texto)){
					// Se achar, retorna o objeto encontrado
					return getEstante()[i];
				}	
			}			
		}
		// Se não achar, retorna null
		return null;
	}

	public String baixaUmLivro(){
		String respostaFinal = "";		
		Livro v = null;

		// Na sequência, ler do teclado um título de livro
		Helpers.wr("Digite um título de livro.");
		String titulo = Helpers.leString();

		// se já existe algum livro na estante com este título, exibir mensagem e repetir a leitura, até que o título digitado seja inédito
		while (buscaLivro(titulo) != null) {
			Helpers.wr("Livro Encontrado. Digite um título de livro inédito.");
			titulo = Helpers.leString();
		}

		// A seguir, ler o número de páginas do livro 
		Helpers.wr("Digite o numero de páginas do livro.");		
		int numeroPaginas = Helpers.leInt();

		// Perguntar ao usuário se ele quer o livro grátis ou pago
		Helpers.wr("Quer um livro pago (1) ou um livro grátis (2)?");
		int tipolivro = Helpers.leInt();
		while (tipolivro != 1 && tipolivro != 2) {
			Helpers.wr("Escolha errada. Quer um livro pago (1) ou um livro grátis (2)?");
			tipolivro = Helpers.leInt();			
		}		

		// Conforme sua resposta, instanciar um objeto Livro ou LivroGratis e atribui-lo à variável v. 
		if(tipolivro == 1){
			v = new Livro(titulo, numeroPaginas);

			// Se for um livro pago, atualizar o atributo do faturamento
			setFaturamento(getFaturamento() + v.getPreco());
		}else{
			Helpers.wr("Quantos anuncios você gostaria de ter?");
			int qtdAnuncios = Helpers.leInt();

			v = new LivroGratis(titulo, numeroPaginas, qtdAnuncios);
			((LivroGratis)v).insereAnuncios();
		}

		// Finalmente, inserir o livro que foi instanciado, na próxima posição vazia do array que representa a estante. 
		int count = 0;
		for (int i = 0; i < getEstante().length; i++) {
			if(getEstante()[i] == null){
				getEstante()[i] = v;
				break;
			}else{
				count++;
			}
		}

		// Se a estante estiver lotada, nada disso pode ser feito, obviamente
		// O método deve retornar uma frase, para indicar o sucesso ou não da operação
		if(count == getEstante().length){
			respostaFinal = "Estante lotada";
		}else{
			respostaFinal = "Livro baixado com sucesso"; 
		}	

		return respostaFinal;
	}

	public boolean exibeEstante(){
		if(isEstanteEmpty()){
			return false;
		}

		// Mostra na tela os dados de cada livro existente na estante, precedidos do número da posição que cada um ocupa no array, e retorna true
		for (int i = 0; i < getEstante().length; i++) {
			if(getEstante()[i]!=null){
				Helpers.wr("\nExibindo Livro de nº: " + i);
				getEstante()[i].exibeDados();	
			}						
		}

		return true;
	}

	public boolean sessaoDeLeitura(){
		if(isEstanteEmpty()){
			return false;
		}

		// Começa listando os livros existentes, chamando o método anterior para isso
		exibeEstante();

		// A seguir, o usuário escolhe, via teclado, qual a obra que ele quer ler, através da digitação do respectivo número que está mostrado na tela
		Helpers.wr("\nDigite o número do livro que você quer.");
		int numero = Helpers.leInt();

		// Validar, com repetição, esta entrada de dados
		while (numero >= getEstante().length || numero < 0) {
			Helpers.wr("Numero Errado! Digite o número do livro que você quer.");
			numero = Helpers.leInt();
		}

		// Chama o método que faz leitura da classe Livro
		int numeroPaginasLidas = getEstante()[numero].fazLeitura();

		// Se for um livro grátis  
		if(getEstante()[numero] instanceof LivroGratis || getEstante()[numero].getPreco() == 0.0){

			LivroGratis livroGratis = (LivroGratis)getEstante()[numero];
			int numeroExibicoes = 0; 
			double totalValor = 0;

			// "anuncio que é exibido na sessao"
			numeroExibicoes = livroGratis.getAnuncios()[livroGratis.getUltimoAnuncioExibido() - 1].getNumeroExibicoes();
			totalValor = getPrecoPorExibicao() * numeroExibicoes;

			// Atualizar o atributo que acumula o faturamento, correspondente ao anúncio que é exibido na sessão."
			this.faturamento = this.faturamento + totalValor;		
		}

		// Encerrar a sessão, imprimindo a frase e retornar true 
		Helpers.wr("Você leu " + numeroPaginasLidas + " páginas nesta sessão.");

		return true;
	}

	public void imprimirTodosAnunciosDosLivrosGratisQueEstaoNaEstante(){
		LivroGratis[] livroGratis = null;
		int qtdLivrosGratis = 0;

		// pega a qtd de livros gratis da estante
		for (int i = 0; i < getEstante().length; i++) {
			if(getEstante()[i] instanceof LivroGratis || getEstante()[i].getPreco() == 0){
				qtdLivrosGratis++;
			}
		}

		// popula o array de livros gratis com os livros gratis da estante
		int iLogico = 0;
		if(qtdLivrosGratis > 0){
			livroGratis = new LivroGratis[qtdLivrosGratis];

			for (int i = iLogico; i < getEstante().length; i++) {
				if(getEstante()[i] instanceof LivroGratis || getEstante()[i].getPreco() == 0){
					livroGratis[iLogico++] = (LivroGratis)getEstante()[i];
				}
			}
		}

		// imprime todos anuncios de todos os livros gratis
		for (int i = 0; i < livroGratis.length; i++) {
			livroGratis[i].exibeDadosDeAnuncios();
		}		
	}

	public double[] listaPrecoLivros(){
		double[] array = null;
		int qtdLivrosNaoGratuitos = 0;		

		// pega a quantidade de livros não gratuitos
		for (int i = 0; i < getEstante().length; i++) {
			if(getEstante()[i].getPreco() > 0.0){
				qtdLivrosNaoGratuitos++;
			}
		}

		// se só tiver livros gratuitos, retornar null
		if(qtdLivrosNaoGratuitos == 0){
			return null;
		}

		// se tiver algum livro não gratuito, popula com os valors
		if(qtdLivrosNaoGratuitos > 0){
			array = new double[qtdLivrosNaoGratuitos];

			int iLogico = 0;
			for (int i = iLogico; i < getEstante().length; i++) {
				if(getEstante()[i].getPreco() > 0.0){
					array[iLogico++] = getEstante()[i].getPreco();
				}
			}
		}	

		return array;
	}

	private boolean isEstanteEmpty(){
		int count = 0;
		for (int i = 0; i < getEstante().length; i++) {
			if(getEstante()[i] == null){
				count++;
			}
		}		
		if(count == getEstante().length){
			return true;
		}else{
			return false;
		}
	}

}
