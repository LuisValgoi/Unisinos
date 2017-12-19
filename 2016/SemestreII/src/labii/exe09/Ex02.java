package labii.exe09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ex02 {

	public static void main(String[] args) {

		boolean prosseguir = true;
		do {			
			try {
				// Config e Variav
				File file = new File("Biblia.txt");			
				FileReader fr = new FileReader(file);
				BufferedReader in = new BufferedReader(fr);
				List<String> palindromes = new ArrayList<String>();

				// Palindromes Normais
				System.out.println("Palindromes normais: ");
				String linha = in.readLine();				
				int nLinha = 1;				
				while (linha != null) {					
					String[] palavras = splitador(linha, " ");					
					for (String palavra : palavras){
						String palavraPolida = facoPolimento(palavra);
						if(palavraPolida.length() > 2){
							if(isPalindrome(palavraPolida)){
								System.out.println("Palavra: " + palavra);
								System.out.println("Linha:   " + nLinha);
								palindromes.add(palavraPolida);
							}
						}							
					}
					linha = in.readLine();
					nLinha++;
				}
				in.close();
				prosseguir = true;
				System.out.println("Há " + palindromes.size() + " palindomes normais no antigo testamento");
				
				// Palindromes Unicos
				System.out.println("\nPalindromes unicos: ");
				Set<String> hs = mostraPalindromeUnicos(palindromes);
				System.out.println("Há " + hs.size() + " palindomes unicos no antigo testamento");

			} catch (FileNotFoundException e) {
				prosseguir = true;
				System.out.println("Não foi encontrado o arquivo com este nome: " + e.toString());
			} catch (Exception e) {
				prosseguir = false;
				System.out.println("Ocorreu algum erro: " + e.toString());
			}			
		} while (!prosseguir);
	}

	private static String[] splitador(String line, String pattern) {
		return line.split(pattern);
	}

	private static String facoPolimento(String str){
		return removerCaracterEspecial(removerAcentos(str));
	}

	private static String removerAcentos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	private static String removerCaracterEspecial(String str){
		return str.replaceAll("[^\\p{Alpha}]+","");
	}

	private static boolean isPalindrome(String palavra) {
		String resultado = "";		
		for(int i = palavra.length() - 1; i >= 0; i--)
			resultado += palavra.charAt(i);

		if(resultado.equals(palavra))
			if(!palavra.equals("")){
				return true;
			}
		return false;
	}

	private static Set<String> mostraPalindromeUnicos(List<String> palindromes){
		List<String> palindromesUnicos = new ArrayList<String>(palindromes);		
		Set<String> hs = new HashSet<>();
		
		hs.addAll(palindromesUnicos);
		palindromesUnicos.clear();
		palindromesUnicos.addAll(hs);
		
		for (String palavra : hs)
			System.out.println("Palavra: " + palavra);		
		
		return hs;		
	}

}


