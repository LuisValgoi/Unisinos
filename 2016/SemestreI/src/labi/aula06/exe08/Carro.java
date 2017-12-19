package labi.aula06.exe08;


public class Carro {
	private double tanque;
	private double consumo;
	private double kmPercorrida;
	
	public Carro(){
		this.tanque = 0;
		this.consumo = 10;
		this.kmPercorrida = 0;
	}
	
	public Carro(double qtdNoTanque, double consumo, double kilometragem){
		if(qtdNoTanque <= 55){
			this.tanque = qtdNoTanque;	
		}		
		this.consumo = consumo;		
		this.kmPercorrida = kilometragem;
	}

	public double getConsumo() {
		return consumo;
	}

	public void setConsumo(double consumo) {
		if(consumo > 0){
			this.consumo = consumo;	
		}else{
			this.consumo = 10;
		}
	}
	
	public boolean abastece(double qtdParaPorNoTanque){
		if(this.tanque + qtdParaPorNoTanque <= 55){
			this.tanque = this.tanque + qtdParaPorNoTanque;
			return true;
		}else{
			return false;
		}
	}
	
	public boolean anda(double qtdKmParaSerPercorrido){
		double qtdLitrosQueConsumira = qtdKmParaSerPercorrido / this.consumo;
		double kmQueAindaPodeAndar = this.consumo * this.tanque;
		
		if(qtdKmParaSerPercorrido <= kmQueAindaPodeAndar){
			this.tanque = this.tanque - qtdLitrosQueConsumira; 
			this.kmPercorrida = this.kmPercorrida + qtdKmParaSerPercorrido;
			
			return true;
		}else{
			return false;	
		}	
	}
	
	public String status(){
		String statusTanque = String.format("Seu carro tem: %sL no tanque.\n", this.tanque);
		String statusConsumo = String.format("Seu carro consome: %s/L.\n", this.consumo);
		String statusKM = String.format("Seu carro percorreu: %skms.", this.kmPercorrida);
		
		return statusTanque + statusConsumo + statusKM;
	}
}
