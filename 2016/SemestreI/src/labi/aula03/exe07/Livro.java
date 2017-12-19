package labi.aula03.exe07;


public class Livro {
	
	private String titulo;
	private boolean emprestado;
	private boolean devolve;
	
	public Livro(){	
		
	}
	
	public void setTitulo(String T){
		this.titulo = T;
	}
	
	public String getTitulo(){
		return this.titulo;
	}
	
	public void empresta(){
		this.emprestado = true;
	}
	
	public void devolve(){
		this.devolve = true;
	}
	
	public boolean isEmprestado(){
		return this.emprestado;		
	}
	
	public boolean isDevolver(){
		return this.devolve;
	}
		
	public void exibeDados(){
		String empresta = "";
		String devolve = "";
		
		if (isEmprestado()){
			empresta = "Sim";
		}
		else { 
			empresta = "N�o";
		}
		
		if (isDevolver()){
			devolve = "Sim";
		}else{
			devolve = "N�o";
		}
		
		System.out.println(String.format("O t�tulo �: %1s, voc� quer emprestar: %1s e voc� quer devolver: %1s", this.titulo, empresta, devolve));
	}
}
