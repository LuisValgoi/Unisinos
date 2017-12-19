package labii.trabGA;

public class ClassificaPilotoException extends Exception{

	@Override
	public String toString() {
		return "Não foi possível classificar os pilotos, pois o mesmo encontra-se vazio"; 
	}
}
