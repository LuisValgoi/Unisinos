package labii.exe08;

public class Exception06 extends Exception{
	int t = 0;
	
	public Exception06(int ta){
		t = ta;
	}
	
	@Override
	public String toString() {
		return "O n�mero de elementos encontrados " + t + " n�o condiz com o valor esperado de 20 elementos.";
	}
}
