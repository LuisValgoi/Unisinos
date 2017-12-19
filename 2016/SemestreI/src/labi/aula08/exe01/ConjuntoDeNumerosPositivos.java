package labi.aula08.exe01;

public class ConjuntoDeNumerosPositivos {
	private int somaTodosNumeros;
	private int qtdNumeros;
	private int maiorNumero;
	
	public ConjuntoDeNumerosPositivos(){
		this.somaTodosNumeros = 0;
		this.qtdNumeros = 0;
		this.maiorNumero = 0;
	}
	
	public void incluiUmNumero(int n){
		if(n > 0){
			this.somaTodosNumeros += n;
			this.qtdNumeros++;
			if(maiorNumero < n){
				this.maiorNumero = n;
			}
		}
	}
	
	public double getMedia(){
		if((double)qtdNumeros == 0.0){
			return 0;
		}else{
			return ((double)somaTodosNumeros / (double)qtdNumeros);	
		}
	}
	
	public int getMaior(){
		return this.maiorNumero;
	}
	
	public int getSomaTodos(){
		return this.somaTodosNumeros;
	}
}
