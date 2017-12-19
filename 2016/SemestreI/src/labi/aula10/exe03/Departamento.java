package labi.aula10.exe03;

public class Departamento {	

	private int numero;
	private String nome;

	public Departamento(int num, String nom){
		setNumero(num);
		setNome(nom);
	}

	public void setNumero(int n){
		if (n > 0){
			numero= n;
		}			
	}
	
	public void setNome(String n){
		if (n.length() > 0){
			nome = n;
		}			
	}
	
	public int getNumero(){
		return numero;
	}
	
	public String getNome(){
		return nome;
	}
}
