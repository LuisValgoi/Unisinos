package labi.aula07.exe02;

public class Pessoa {	
	
	private String nome;
	private double peso;
	private double altura;
	private String email;
	private Data dataNascimento;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDataNascimento() {
		return this.dataNascimento.getDataPadrao();
	}
	
	public void setDataNascimento(Data data) {
		this.dataNascimento = data;
	}
	
	public int getIdade(){
		
		int anoDoNascimento = this.dataNascimento.getAno();
		int mesDoNascimento = this.dataNascimento.getMes();
		int diaDoNascimento = this.dataNascimento.getDia();
		
		int anoHoje = 2015;
		int mesHoje = 3;
		int diaHoje = 10;
			
		int idadeTemp = 0;
		
		if (mesHoje < mesDoNascimento){			
			idadeTemp = (anoHoje - anoDoNascimento) - 1;
		}
		
		if(mesDoNascimento == mesHoje){
			if(diaDoNascimento == diaHoje){
				idadeTemp = (anoHoje - anoDoNascimento);
			}else{
				idadeTemp = (anoHoje - anoDoNascimento) - 1;
			}
		}
		
		return idadeTemp;				
	}
	
	public boolean isFaixaEtariaMaioridade(){
		int idade = this.getIdade();
		
		if(idade >= 18){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean podeComprarBebida(){		
		if(isFaixaEtariaMaioridade()){
			return true;
		}else{
			return false;
		}
	}
}
