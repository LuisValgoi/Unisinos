package labi.aula16ProvaGB;

/** Alunos : Luis Valgoi Prova GB LAB 1 Turma: 33 */

import java.util.Scanner;

public class Helpers {
	
	public static void wr(String v){
		System.out.println(v);
	}
	
	public static void wr(double v){
		System.out.println(v);
	}
	
	public static void wr(int v){
		System.out.println(v);
	}

	public static String leString(){
		Scanner teclado = new Scanner (System.in);
		return teclado.nextLine();
	}

	public static int leInt(){
		Scanner teclado = new Scanner (System.in);
		return teclado.nextInt();
	}

	public static double leDouble(){
		Scanner teclado = new Scanner (System.in);
		return teclado.nextDouble();
	}
}
