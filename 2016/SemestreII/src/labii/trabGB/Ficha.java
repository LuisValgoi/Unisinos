package labii.trabGB;

public class Ficha {
	private int numero;
	private String senha;
	private boolean isPrioritario;
	private String servicoDesignacao;
	private int tempoRestante;

	// construtor
	public Ficha(int numero, boolean isPrioritario, String servico) {
		this.numero = numero;
		this.isPrioritario = isPrioritario;
		this.senha = servico + numero + (isPrioritario ? "pr" : "npr");
		this.servicoDesignacao = servico;

		if(servicoDesignacao.equalsIgnoreCase("A"))
			tempoRestante = 2;

		else if(servicoDesignacao.equalsIgnoreCase("B"))
			tempoRestante = 1;

		else if(servicoDesignacao.equalsIgnoreCase("C"))
			tempoRestante = 3;		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isPrioritario() {
		return isPrioritario;
	}

	public void setPrioritario(boolean isPrioritario) {
		this.isPrioritario = isPrioritario;
	}

	public String getServicoDesignacao() {
		return servicoDesignacao;
	}

	public void setServicoDesignacao(String servicoDesignacao) {
		this.servicoDesignacao = servicoDesignacao;
	}

	public int getTempoRestante() {
		return tempoRestante;
	}

	public void setTempoRestante(int tempoRestante) {
		this.tempoRestante = tempoRestante;
	}	
}
