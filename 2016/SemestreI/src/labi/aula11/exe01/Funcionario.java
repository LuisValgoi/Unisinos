package labi.aula11.exe01;

public class Funcionario {
	private String nome;
	private Departamento departamento;
	private double salario;
	
	public Funcionario(String nome, Departamento departamento, double salario){
		this.nome = nome;
		this.departamento = departamento;
		this.salario = salario;
	}
	
	public Funcionario(String nome, int numeroDepartamento, String nomeDepartamento, double salario){
		this.nome = nome;
		this.departamento = new Departamento(numeroDepartamento, nomeDepartamento);
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}

	public double getSalario() {
		return salario;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void reajustaSalario(int codigo){
		
		if(codigo == 1){
			double valorParaAdicionar = this.salario * 0.20;
			this.salario = this.salario + valorParaAdicionar;
		}
		else if(codigo == 2){
			double valorParaAdicionar = this.salario * 0.05;
			this.salario = this.salario + valorParaAdicionar;
		}
		else if(codigo == 3){
			double valorParaAdicionar = this.salario * 0.13;
			this.salario = this.salario + valorParaAdicionar;
		}
	}
	
	public void reajustaSalario(int codigo, double valorLimite){
		
		if(codigo == 1){
			double valorParaAdicionar = this.salario * 0.20;
			this.salario = this.salario + valorParaAdicionar;			
		}
		else if(codigo == 2){
			double valorParaAdicionar = this.salario * 0.05;
			this.salario = this.salario + valorParaAdicionar;
		}
		else if(codigo == 3){
			double valorParaAdicionar = this.salario * 0.13;
			this.salario = this.salario + valorParaAdicionar;
		}
		
		if(this.departamento.getNumero() == 25){
			if(this.salario < valorLimite){
				this.salario = this.salario + 57.00;
			}
		}
		
	}
}
