package labi.aula11.exe02A;

public class Avaliacao {
	private double gA;
	private double gB;
	private double mF;
	
	public Avaliacao(double gA,double gB){
		setNotaGa (gA);
		setNotaGb (gB);
		calculaMediaFinal();
	}
	
	public double getGrauA(){
		return gA;
	}
	
	public double getGrauB(){
		return gB;
	}
	
	public double getMediaFinal(){
		return mF;
	}
	
	private void setNotaGa (double nota){
		if (nota>=0 && nota<=10)
			gA = nota;
	}
	
	private void setNotaGb (double nota){
		if (nota>=0 && nota<=10)
			gB = nota;
	}

	private void calculaMediaFinal(){
		mF = gA*0.33 + gB*0.67 ;
	}
}