package labii.provaGB;

public class Relatorio {

	private int guiche01QtdNumeroCaminhoes;
	private int guiche01QtdNumeroAutomoveis;

	private int guiche02QtdNumeroCaminhoes;
	private int guiche02QtdNumeroAutomoveis;

	private int guiche03QtdNumeroCaminhoes;
	private int guiche03QtdNumeroAutomoveis;

	private int guiche04QtdNumeroCaminhoes;
	private int guiche04QtdNumeroAutomoveis;

	public Relatorio(){
		this.guiche01QtdNumeroCaminhoes = 0;
		this.guiche01QtdNumeroAutomoveis = 0;

		this.guiche02QtdNumeroCaminhoes = 0;
		this.guiche02QtdNumeroAutomoveis = 0;

		this.guiche03QtdNumeroCaminhoes = 0;
		this.guiche03QtdNumeroAutomoveis = 0;

		this.guiche04QtdNumeroCaminhoes = 0;
		this.guiche04QtdNumeroAutomoveis = 0;
	}

	public int qtdTotalVeiculos01(){
		return guiche01QtdNumeroCaminhoes + guiche01QtdNumeroAutomoveis; 
	}

	public int qtdTotalVeiculos02(){
		return guiche02QtdNumeroCaminhoes + guiche02QtdNumeroAutomoveis; 
	}

	public int qtdTotalVeiculos03(){
		return guiche03QtdNumeroCaminhoes + guiche03QtdNumeroAutomoveis; 
	}

	public int qtdTotalVeiculos04(){
		return guiche04QtdNumeroCaminhoes + guiche04QtdNumeroAutomoveis; 
	}

	public int getQtdAtendimentosAutomoveis(int numeroGuiche){
		if(numeroGuiche == 1){
			return guiche01QtdNumeroAutomoveis;
		}else if(numeroGuiche == 2){
			return guiche02QtdNumeroAutomoveis;
		}else if(numeroGuiche == 3){
			return guiche03QtdNumeroAutomoveis;
		}else{
			return guiche04QtdNumeroAutomoveis;
		}
	}

	public int getQtdAtendimentosCaminhoes(int numeroGuiche){
		if(numeroGuiche == 1){
			return guiche01QtdNumeroCaminhoes;
		}else if(numeroGuiche == 2){
			return guiche02QtdNumeroCaminhoes;
		}else if(numeroGuiche == 3){
			return guiche03QtdNumeroCaminhoes;
		}else{
			return guiche04QtdNumeroCaminhoes;
		}
	}

	public void conta(int numeroGuiche, Veiculo veiculo){
		if(numeroGuiche == 1){
			if(veiculo.getTipo() == 1){
				guiche01QtdNumeroAutomoveis++;
			}else{
				guiche01QtdNumeroCaminhoes++;
			}
		}
		else if(numeroGuiche == 2){
			if(veiculo.getTipo() == 1){
				guiche02QtdNumeroAutomoveis++;
			}else{
				guiche02QtdNumeroCaminhoes++;
			}
		}
		else if(numeroGuiche == 3){
			if(veiculo.getTipo() == 1){
				guiche03QtdNumeroAutomoveis++;
			}else{
				guiche03QtdNumeroCaminhoes++;
			}	
		}
		else if(numeroGuiche == 4){
			if(veiculo.getTipo() == 1){
				guiche04QtdNumeroAutomoveis++;
			}else{
				guiche04QtdNumeroCaminhoes++;
			}
		}

	}

}
