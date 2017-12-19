package labi.aula04.exe02;


public class VentiladorAnalogico {
	private int velocidade;
	
	public VentiladorAnalogico(){ 
		this.velocidade = 0;
	}
	
	public VentiladorAnalogico(int velocidadeT){
		this.velocidade = velocidadeT;
	}

	public int getVelocidade() {
		return velocidade;
	}
	
	public void aumentaVelocidade(){
		if (this.velocidade == 1){
			this.velocidade = 2;
		}
		else if (this.velocidade == 0){
			this.velocidade = 1;
		}
		else if (this.velocidade == 2){
			this.velocidade = 2;
		}
	}
	
	public void diminuiVelocidade(){
		if (this.velocidade == 1){
			this.velocidade = 0;
		}
		else if (this.velocidade == 0){
			this.velocidade = 0;
		}
		else if (this.velocidade == 2){
			this.velocidade = 1;
		}
	}
}
