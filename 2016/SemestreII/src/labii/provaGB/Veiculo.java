package labii.provaGB;

public class Veiculo {
	private int tipo; // 1 = automovel, 2 = caminhao
	private int tempo;	
	
	public Veiculo(int tipo){
		if(tipo != 1 && tipo != 2){
			this.tempo = 0;
		}else{
			this.tipo = tipo;
			
			if(tipo == 1)
				this.tempo = 30;
			else
				this.tempo = 60;
		}
	}

	public int getTipo() {
		return tipo;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo){
		this.tempo = tempo;
	}
}
