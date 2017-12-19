package labi.aula03.exe01;


public class TestaDado {

	public static void main(String[] args) {
		Dado dado = new Dado(6);
		
		double resultado = dado.jogaDado();
		
		System.out.print(String.format("O resultado é: %1s", resultado));		
	}
}
