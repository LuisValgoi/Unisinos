package labii.trabGA;

public class InsercaoPilotoException extends Exception{
	
	@Override
	public String toString (){
		return "Não foi possível adicionar este piloto, pois há espaço suficiente!";
	}
	
}
