package labi.aula06.exe04;

import java.util.Scanner;

public class TestaAluno {
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		//////////////////////////////////////////////////////// 1º Aluno 
		System.out.println("Digite seu nome");
		String nome1 = teclado.nextLine();
				
		System.out.println("Digite a nota do GA do 1º Aluno");
		double nGA1 = teclado.nextDouble();
		
		System.out.println("Digite a nota do GB do 1º Aluno");
		double nGB1 = teclado.nextDouble();
		
		Aluno aluno1 = new Aluno(nome1, nGA1, nGB1);
		
		//////////////////////////////////////////////////////// 2º Aluno
		Aluno aluno2 = new Aluno(nome1);
		System.out.println("Digite a nota do GA do 2º Aluno");
		double nGA2 = teclado.nextDouble();
		
		System.out.println("Digite a nota do GB do 2º Aluno");
		double nGB2 = teclado.nextDouble();
		
		aluno2.setAvaliacao(nGA2, nGB2);		
		
		//////////////////////////////////////////////////////// 3º Aluno		
		System.out.println("Digite o nome do 3º Aluno");
		String nome3 = teclado.next();
		
		System.out.println("Digite a nota do GA do 3º Aluno");
		double nGA3 = teclado.nextDouble();
		
		System.out.println("Digite a nota do GB do 3º Aluno");
		double nGB3 = teclado.nextDouble();
		
		Avaliacao aval = new Avaliacao(nGA3, nGB3);		
		Aluno aluno3 = new Aluno(nome3, aval);
		
		//////////////////////////////////////////////////////// Prints		
		System.out.println("Nome do Aluno | Nota Grau A | Nota Grau B | Media");
		System.out.println(aluno1.getNome() +" |"+ aluno1.getAvaliacao().getNotaGrauA() +"     |"+  aluno1.getAvaliacao().getNotaGrauB() +"    |"+  aluno1.getAvaliacao().calculaMedia());
		System.out.println(aluno2.getNome() +" |"+ aluno2.getAvaliacao().getNotaGrauA() +"     |"+  aluno2.getAvaliacao().getNotaGrauB() +"    |"+  aluno2.getAvaliacao().calculaMedia());
		System.out.println(aluno3.getNome() +" |"+ aluno3.getAvaliacao().getNotaGrauA() +"     |"+  aluno3.getAvaliacao().getNotaGrauB() +"    |"+  aluno3.getAvaliacao().calculaMedia());
	}
}
