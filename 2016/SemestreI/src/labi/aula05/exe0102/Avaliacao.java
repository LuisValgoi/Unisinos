package labi.aula05.exe0102;


public class Avaliacao {
	
	private double notaGrauA;
	private double notaGrauB;
	
	public Avaliacao(double notaGA, double notaGB){
		this.notaGrauA = notaGA;
		this.notaGrauB = notaGB;
	}

	public double getNotaGrauA() {
		return notaGrauA;
	}

	public void setNotaGrauA(double notaGrauA) {
		this.notaGrauA = notaGrauA;
	}

	public double getNotaGrauB() {
		return notaGrauB;
	}

	public void setNotaGrauB(double notaGrauB) {
		this.notaGrauB = notaGrauB;
	}
	
	public double calculaMedia(){
		return ((this.notaGrauA * 1) + (this.notaGrauB * 2) / 3);
	} 
}
