package progii.abstracts;

public class EmpregadoHorista extends Empregado{
	public int horasTrabalhas;
	public double valorHora;

	public EmpregadoHorista(String nome, String sobrenome, String cpf, int horasTrabalhadas, double valorHora) {
		super(nome, sobrenome, cpf);
		this.horasTrabalhas = horasTrabalhadas;
		this.valorHora = valorHora;
	}

	public int getHorasTrabalhas() {
		return horasTrabalhas;
	}

	public void setHorasTrabalhas(int horasTrabalhas) {
		this.horasTrabalhas = horasTrabalhas;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	@Override
	public double calculaSalario() {
		return getHorasTrabalhas() * getValorHora();
	}

	@Override
	public String toString(){
		return super.toString() + ", [Horas Trabalhadas: " + getHorasTrabalhas() + "], [Valor Hora: " + getValorHora() + "], [Salario: " + calculaSalario() + "]";
	}

}
