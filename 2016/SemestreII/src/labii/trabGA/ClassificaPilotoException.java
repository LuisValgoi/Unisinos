package labii.trabGA;

public class ClassificaPilotoException extends Exception{

	@Override
	public String toString() {
		return "N�o foi poss�vel classificar os pilotos, pois o mesmo encontra-se vazio"; 
	}
}
