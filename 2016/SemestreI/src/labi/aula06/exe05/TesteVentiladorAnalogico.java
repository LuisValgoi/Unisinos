package labi.aula06.exe05;

import java.util.Scanner;

public class TesteVentiladorAnalogico {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		VentiladorAnalogico ventilador = new VentiladorAnalogico(2);
		
		System.out.println("A velocidade do seu ventilador é: " + ventilador.getVelocidade());		
		
		ventilador.diminuiVelocidade();
		int velocidade = ventilador.getVelocidade();		
		System.out.println("Com o acionamento dos métodos ele fica: " + velocidade);
	}
}
