package labi.aula06.exe06;


public class VentiladorDigital {
	private int velocidade;
	
	public VentiladorDigital(){
		this.velocidade = 0;
	}
	
	public VentiladorDigital(int velocidade){
		if(velocidade == 0 || velocidade == 1 || velocidade == 2 || velocidade == 3){
			this.velocidade = velocidade;
		}
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void mudaVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	
	public void desliga(){
		this.velocidade = 0;
	}
	
	public void liga(){
		if(this.velocidade == 0){
			this.velocidade = 1;
		}
	}
}
