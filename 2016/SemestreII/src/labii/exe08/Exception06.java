package labii.exe08;

public class Exception06 extends Exception{
	int t = 0;
	
	public Exception06(int ta){
		t = ta;
	}
	
	@Override
	public String toString() {
		return "O número de elementos encontrados " + t + " não condiz com o valor esperado de 20 elementos.";
	}
}
