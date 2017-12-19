package labi.aula02.exe07;


public class Retangulo {

	private double base;	
	private double altura;
	
	public Retangulo () {
	}
		
	public void setRetangulo (double base, double altura) {		
		this.base = base;
		this.altura = altura;
	}
	
	private double calcularArea(){
		double area = this.base * this.altura;
		
		return area;
	}
	
	public void exibirArea(){
		double area = this.calcularArea();
		System.out.print(String.format("A ÁREA é: %1s", area));
	}
}
