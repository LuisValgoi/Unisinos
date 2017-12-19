package labi.aula03.exe07;


public class TesteLivro {

	public static void main(String[] args) {
	 Livro livroA;
	 Livro livroB;
	 
	 livroA = new Livro();
	 livroA.setTitulo("TituloUm");
	 livroA.empresta();
	 livroA.exibeDados();
	 
	 livroB = new Livro();
	 livroB.setTitulo("TituloDois");
	 livroB.devolve();
	 livroB.exibeDados();
	}
}
