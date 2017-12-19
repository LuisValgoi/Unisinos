package labi.aula08.exe02;

public class TesteGeraExibeSequenciaInteiros {

	public static void main(String[] args) {
		GeraExibeSequenciaInteiros n = new GeraExibeSequenciaInteiros(3, 12);
		
		System.out.println("Inteiros");
		n.geraExibeInt();
		
		System.out.println("\nPares");
		n.geraExibePares();

		System.out.println("\nMultiplos de 3 e 5");
		n.geraExibeMultiplos();
		
		System.out.println("\nMultiplos de m:");
		n.geraExibeMultiplosCalcMed(6);
		
		System.out.println("\nOs divisores são:");
		n.geraExibeDivisores();
		
		System.out.println("\nOs primos são:");
		n.geraExibePrimos();
	}
}
