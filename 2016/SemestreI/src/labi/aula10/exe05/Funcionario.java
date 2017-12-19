package labi.aula10.exe05;

public class Funcionario {
	private String nome;
	private Departamento departamento;
	private double salario;
	
	public Funcionario(String n, Departamento d, double s){
		this.nome = n;
		this.departamento = d;
		this.salario = s;
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
