package labii.exe11;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		NodeQueue<String> infixFormulas = leArquivo();
		registraArquivoPosFix(infixFormulas);
	}

	public static NodeQueue<String> leArquivo(){
		NodeQueue<String> aux = new NodeQueue<String>();

		try {
			FileReader fr = new FileReader("formulas.txt");
			BufferedReader in = new BufferedReader(fr);

			String line = in.readLine();
			while (line != null)
			{
				aux.enqueue(line);
				line = in.readLine();
			}

			in.close ();
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo formulas.txt");
		}

		return aux;
	}

	public static void registraArquivoPosFix(Queue<String> infixFormulas){
		try {
			File file = new File("formulasPosfix.txt");
			FileWriter fr = new FileWriter(file);
			PrintWriter out = new PrintWriter(fr);	

			int size = infixFormulas.size();
			for (int i = 0; i < size; i++) {
				String formulaInfixCurrente = infixFormulas.dequeue();
				String formulaPosFixCurrente = convertePosFix(formulaInfixCurrente);

				out.write(formulaPosFixCurrente);
				out.write("\n");
			}

			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontado: " + e.toString());	
		} catch (Exception e) {
			System.out.println("Ocorreu um erro: " + e.toString());
		}
	}

	private static String convertePosFix(String infix){
		NodeStack<Character> pilha = new NodeStack<Character>();
		StringBuffer postfix = new StringBuffer(infix.length());
		
		pilha.push('(');
		infix += ')';
		
		for (Character c: infix.toCharArray()) {
			
			/*  Se o caractere atual em infix for um dígito, acrescentá-lo a postfix. */
			if(Character.isDigit(c)){
				postfix.append(c);
			}			
			
			/* Se o caractere atual em infix for um parêntese esquerdo, adicioná-lo à pilha. */
			else if(c == '('){
				pilha.push(c);
			}			
			
			/*
			 Se o caractere atual em infix for um operador:
				- Retirar os operadores do topo da pilha enquanto eles tiverem
				precedência maior ou igual ao operador atual e acrescentar os
				operadores removidos a postfix.
				- Inserir na pilha o caractere atual de infix (o operador)
			 */
			else if(isOperador(c)){
				Character top = pilha.top();
				while(!pilha.isEmpty() && !isPrecedenciaMenor(c, top)){				
					postfix.append(pilha.pop());
				}
				
				pilha.push(c);
			}			
			
			/*
			 Se o caractere atual em infix for um parêntese direito:
				- Retirar os operadores do topo da pilha e acrescentá-los a postfix até
				que um parêntese esquerdo esteja no topo da pilha.
				- Retirar e descartar o parêntese esquerdo da pilha.
			 */
			else if(c == ')'){
				while (!pilha.isEmpty() && pilha.top() != '('){
					Character operadorDoTopo = pilha.pop();
                    postfix.append(operadorDoTopo);
				}			
			}			
			
			/* Quando é ' ', ignorar */
			else{
				if(c != ' ')
					postfix.append(c);
			}
		}

		String end = "";		
		for (int i = 0; i < postfix.toString().length(); i++) {
			if(postfix.charAt(i) != '(')
				end+=postfix.charAt(i);
		}

		return end.toString();
	}

	private static boolean isPrecedenciaMenor(char currente, char top){
	    switch (currente)
	    {
	        case '+':
	        case '-':
	            return !(top == '+' || top == '-');

	        case '*':
	        case '/':
	            return top == '+' || top == '-';

	        default:
	            return false;
	    }
	}
		
	private static boolean isOperador(char c){
		return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
	}

}
