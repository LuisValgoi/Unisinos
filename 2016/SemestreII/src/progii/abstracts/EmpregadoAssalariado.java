package progii.abstracts;

public class EmpregadoAssalariado extends Empregado{
	public double salarioMensal;

	public EmpregadoAssalariado(String nome, String sobrenome, String cpf, double salarioMensal) {
		super(nome, sobrenome, cpf);
		this.salarioMensal = salarioMensal;
	}

	public double getSalarioMensal() {
		return salarioMensal;
	}

	public void setSalarioMensal(double salarioMensal) {
		this.salarioMensal = salarioMensal;
	}

	@Override
	public double calculaSalario() {
		return getSalarioMensal();
	}

	@Override
	public String toString(){
		return super.toString() + ", [Salario: " + getSalarioMensal() + "]";
	}
}
