package labi.aula02.exe04;


public class Circulo {

	private double raio;
	
	public Circulo () {
	}
		
	public void setRaio(double raioPersonalizado){
		this.raio = raioPersonalizado;	
	}
	
	private double calculateRaio(){
		double area = Math.PI * Math.pow(this.raio, 2);		
		return area;
	}
	
	public void showRaioAndArea(){
		double area = this.calculateRaio();
		System.out.print(String.format("O RAIO é: %1s e a ÁREA é: %1s", this.raio, area));
	}
}
