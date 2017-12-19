package labi.aula06.exe08;


public class TesteCarro {

	public static void main(String[] args) {
		Carro carro = new Carro();
		carro.abastece(5);
		carro.anda(20);
		
		System.out.println(carro.status());
	}
}
