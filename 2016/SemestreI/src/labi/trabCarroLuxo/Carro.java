package labi.trabCarroLuxo;


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
		
		this.kmPercorrida = kilometragem;
		setConsumo(consumo);
	}

	public double getConsumo() {
		return this.consumo;
	}

	public void setConsumo(double consumo) {
		if(consumo > 0){
			this.consumo = consumo;	
		}else{
			this.consumo = 10;
		}
	}
	
	public boolean abastece(double qtdParaPorNoTanque){
		if((this.tanque + qtdParaPorNoTanque) > 55){
			return false;			
		}else{
			this.tanque = this.tanque + qtdParaPorNoTanque;
			return true;
		}
	}
	
	public boolean anda(double qtdKmParaSerPercorrido){
		double qtdLitrosQueConsumira = qtdKmParaSerPercorrido / this.getConsumo();
		double kmQueAindaPodeAndar = this.getConsumo() * this.tanque;
		
		if(qtdKmParaSerPercorrido <= kmQueAindaPodeAndar){
			this.tanque = this.tanque - qtdLitrosQueConsumira; 
			this.kmPercorrida = this.kmPercorrida + qtdKmParaSerPercorrido;			
			return true;
		}else{
			return false;	
		}	
	}
	
	public String status(){
		String statusTanque = String.format("Seu carro tem: %sL no tanque.", this.tanque);
		String statusConsumo = String.format("\nSeu carro consome: %s/L.", this.consumo);
		String statusKM = String.format("\nSeu carro já percorreu ao total: %skms.", this.kmPercorrida);
		String statusLiberadoParaPercorrer = String.format("\nSeu carro pode andar: %skms com o combustivel disponivel.", this.consumo * this.tanque);
		
		return statusTanque + statusConsumo + statusKM + statusLiberadoParaPercorrer;
	}
}
