package labi.aula06.exe07.B;

public class TresNumerosInteiros {
	private int primeiro;
	private int segundo;
	private int terceiro;
	
	public TresNumerosInteiros(int pri, int seg, int ter){
		this.primeiro = pri;
		this.segundo = seg;
		this.terceiro = ter;
	}

	public int getPrimeiroNumero() {
		return primeiro;
	}

	public void setPrimeiroNumero(int primeiro) {
		if(primeiro > 0){
			this.primeiro = primeiro;	
		}else{
			this.primeiro = 1;
		}		
	}

	public int getSegundoNumero() {
		return segundo;
	}

	public void setSegundoNumero(int segundo) {
		if(segundo > 0){
			this.segundo = segundo;	
		}else{
			this.segundo = 1;
		}
	}

	public int getTerceiroNumero() {
		return terceiro;
	}

	public void setTerceiroNumero(int terceiro) {
		if(terceiro > 0){
			this.terceiro = terceiro;	
		}else{
			this.terceiro = 1;
		}
	}
	
	public int getMaior(){		
		int maior = this.primeiro;
		
		if(this.segundo > maior){
			maior = segundo;
		}
		if(this.terceiro > maior){
			maior = terceiro;
		}
		return maior;				
	}
	
	public int getMenor(){		
		int maior = this.primeiro;
		
		if(this.segundo < maior){
			maior = segundo;
		}
		if(this.terceiro < maior){
			maior = terceiro;
		}
		return maior;	
	}
	
	public void classificaOrdemCrescente(){
		int aux = Integer.MIN_VALUE;
		
		if(this.primeiro > this.segundo){
			aux = this.primeiro;
			this.primeiro = this.segundo;		
			this.segundo = aux;
		}
		
		if(this.segundo > this.terceiro){
			aux = this.segundo;
			this.segundo = this.terceiro;		
			this.terceiro = aux;

			if(this.primeiro > this.segundo){
				aux = this.segundo;
				this.primeiro = this.segundo;		
				this.segundo = aux;
			}
		}
	}
}
