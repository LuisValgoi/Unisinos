package labi.trabGA;

/*
 * Aluno : Luis Henrique Valgoi | Trabalho GA | Turma:33 | 2016/1 
 */

import java.util.Scanner;

public class Helpers {
	
	public static void write(String valor){
		System.out.println(valor);
	}
	
	public static void write(int valor){
		System.out.println(valor);
	}
	
	public static void write(double valor){
		System.out.println(valor);
	}
	
	public static String writeAndReturnString(String valor){
		Scanner teclado = new Scanner(System.in);
		System.out.println(valor);
		return teclado.nextLine();
	}
	
	public static int writeAndReturnInt(String valor){
		Scanner teclado = new Scanner(System.in);
		System.out.println(valor);
		return teclado.nextInt();
	}
	
	public static double writeAndReturnDouble(String valor){
		Scanner teclado = new Scanner(System.in);
		System.out.println(valor);
		return teclado.nextDouble();
	}
}
