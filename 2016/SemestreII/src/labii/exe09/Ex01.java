package labii.exe09;

import java.util.Scanner;

import labii.aula12.queue.ArrayQueue;
import labii.aula12.stack.ArrayStack;

public class Ex01 {

	public static void main(String[] args) {
		if(isPalindromo())
			System.out.println("é palindromo");
		else
			System.out.println("não é palindromo");	
	}
	
	public static boolean isPalindromo(){
		Scanner teclado = new Scanner(System.in);
		boolean resposta = true;
		
		System.out.println("Digite a frase");
		String frase = teclado.nextLine();
		String fraseFinal = "";
				
		for (int i = 0; i < frase.length(); i++) {
			if(frase.charAt(i) != ' ')
				fraseFinal += frase.charAt(i);
		}
		
		ArrayQueue<Character> q = new ArrayQueue<Character>(fraseFinal.length());
		ArrayStack<Character> s = new ArrayStack<Character>(fraseFinal.length());
		
		int i = 0;
		while (i < fraseFinal.length()) {				
			Character caracter = fraseFinal.charAt(i);
			q.enqueue(caracter);
			s.push(caracter);
			i++;
		}
		
		while (!q.isEmpty()) {
			if(q.dequeue() != s.pop())
				return false;
		}		
		return resposta;
	}

}
