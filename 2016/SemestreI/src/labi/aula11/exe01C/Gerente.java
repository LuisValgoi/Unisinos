package labi.aula11.exe01C;


public class Gerente extends Funcionario{

	private String nomeSecretario;
	
	public Gerente(String nomeFunc, int numeroDepartamento, String nomeDepartamento, double salarioFunc) {
		super(nomeFunc, numeroDepartamento, nomeDepartamento, salarioFunc);
		this.nomeSecretario = "Cargo Vago";
	}
	
	public Gerente(String nomeFunc, int numeroDepartamento, String nomeDepartamento, double salarioFunc, String nomeSecretario) {
		super(nomeFunc, numeroDepartamento, nomeDepartamento, salarioFunc);
		this.nomeSecretario = nomeSecretario;
	}

	public String getNomeSecretario() {
		return nomeSecretario;
	}

	public void setNomeSecretario(String nomeSecretario) {
		this.nomeSecretario = nomeSecretario;
	}	
}
