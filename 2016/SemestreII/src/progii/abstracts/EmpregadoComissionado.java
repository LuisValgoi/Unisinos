package progii.abstracts;

public class EmpregadoComissionado extends Empregado{
	public double valorVendido, comissao;
	
	public EmpregadoComissionado(String nome, String sobrenome, String cpf, double v, double c) {
		super(nome, sobrenome, cpf);
		this.valorVendido = v;
		this.comissao = c;
	}	

	public double getValorVendido() {
		return valorVendido;
	}

	public void setValorVendido(double valor) {
		this.valorVendido = valor;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	@Override
	public double calculaSalario() {
		return (getValorVendido() *  getComissao()) / 100;
	}

	@Override
	public String toString(){
		return super.toString() + ", [Valor: " + getValorVendido() + "], [Comissão: " + getComissao() + "], [Salario: " + calculaSalario() + "]";
	}

}
