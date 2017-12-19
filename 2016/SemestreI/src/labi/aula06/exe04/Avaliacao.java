package labi.aula06.exe04;

public class Avaliacao {
	
	private double notaGrauA;
	private double notaGrauB;
	
	public Avaliacao(double notaGA, double notaGB){
		this.setNotaGrauA(notaGrauA);
		this.setNotaGrauB(notaGrauB);
	}

	public double getNotaGrauA() {		
		return notaGrauA;
	}

	public void setNotaGrauA(double notaGrauA) {
		if(notaGrauA >= 0 && notaGrauA <= 10){
			this.notaGrauA = notaGrauA;
		}		
	}

	public double getNotaGrauB() {
		return notaGrauB;
	}

	public void setNotaGrauB(double notaGrauB) {
		if(notaGrauB >= 0 && notaGrauB <= 10){
			this.notaGrauB = notaGrauB;
		}
	}
	
	public double calculaMedia(){
		return ((this.notaGrauA * 1) + (this.notaGrauB * 2) / 3);
	} 
}
