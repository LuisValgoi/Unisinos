package labi.trabGB;

/** Alunos : Luis Valgoi Trabalho GB Turma: 33 2016/1 */

public class TestaLivroGratis {

	public static void main(String[] args) {
		Livro livro = new LivroGratis("O trabalho", 10+(int)(Math.random()*400), 2+(int)(Math.random()*4));          
		
		// Inserir anuncios e exibir todos os dados do livro
		((LivroGratis)livro).insereAnuncios();
		((LivroGratis)livro).exibeDados();	
		
		// Declarar e inicializar vari�veis locais necess�rias
		LeitorDigital leitor = null;
		leitor = new LeitorDigital(2);
		leitor.getEstante()[0] = livro;
		int numeroPaginasSessao = 0;
		int numeroPaginasSessaoMaisLonga = 0;
		int numeroPaginasSessaoTotal = 0;
		int tempoSessaoMaisLonga = 0;
		int numeroExibicoesDoAnuncio = ((LivroGratis)livro).getAnuncios()[0].getNumeroExibicoes();
		String tituloAnuncioApresentadoMenosVezes = ((LivroGratis)livro).getAnuncios()[0].getTitulo();		
		int qtdSessoesLeituras = 0;
		
		// Simular v�rias sess�es de leitura, parando quando o livro for todo lido ou o n�mero de p�ginas de uma sess�o estiver no intervalo (20,27)	
		Helpers.wr(leitor.baixaUmLivro());
		leitor.exibeEstante();
		
		do{
			// Realiza a leitura
			numeroPaginasSessao = ((LivroGratis)livro).fazLeitura();
			
			// Quantidade de Paginas lidas na sessao mais longa
			if(((LivroGratis)livro).getTempoTotalLeitura() > tempoSessaoMaisLonga){
				tempoSessaoMaisLonga = ((LivroGratis)livro).getTempoTotalLeitura();
				numeroPaginasSessaoMaisLonga = ((LivroGratis)livro).getNumeroDePaginas();
			}
			
			// Pega o titulo do anuncio que foi apresentado menos vezes
			for (int i = 1; i < ((LivroGratis)livro).getAnuncios().length; i++) {
				if(((LivroGratis)livro).getAnuncios()[i].getNumeroExibicoes() < numeroExibicoesDoAnuncio){
					tituloAnuncioApresentadoMenosVezes = ((LivroGratis)livro).getAnuncios()[i].getTitulo();
				}
			}
			
			// Somatorio das paginas
			numeroPaginasSessaoTotal += numeroPaginasSessao;
			
			// Quantas Sessoes foram realizadas
			qtdSessoesLeituras++;		
			
		}while (((LivroGratis)livro).getPercentualLido() < 100.00 
				&& (numeroPaginasSessao < 20 || numeroPaginasSessao > 27) 
				&& qtdSessoesLeituras < ((LivroGratis)livro).getAnuncios().length);
		
		
		// Exibir a quantidade de sess�es que foram realizadas
		Helpers.wr("Exibir a quantidade de sess�es que foram realizadas: " + qtdSessoesLeituras);
		
		// Exibir a quantidade de p�ginas lidas na sess�o de leitura mais longa
		Helpers.wr("Exibir a quantidade de p�ginas lidas na sess�o de leitura mais longa: " + numeroPaginasSessaoMaisLonga);
		
		// Exibir a m�dia de p�ginas por sess�o           
		Helpers.wr("Exibir a m�dia de p�ginas por sess�o: " + numeroPaginasSessaoTotal/qtdSessoesLeituras);
		
		// Exibir o t�tulo do an�ncio que foi apresentado menos vezes. Em caso de empate, qualquer um dos que empataram nessa condicao
		Helpers.wr("Exibir o t�tulo do an�ncio que foi apresentado menos vezes: " + tituloAnuncioApresentadoMenosVezes);		
	}
}