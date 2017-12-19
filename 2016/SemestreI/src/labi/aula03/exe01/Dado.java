package labi.aula03.exe01;

public class Dado {

	private int lados;
		
	public Dado (int nlados) {
		this.lados = nlados;
	}
	
	public double jogaDado(){
		return (int) (Math.random ( ) * lados + 1);	
	}
}
