/*
 * Complexity:
 * O(n)
 * 
 * 
 * What we want:
 * We want to see the valued passed as string in a inverted way  
 * 
 */

public class InvertedString {

	public static void main(String[] args) {
		System.out.println("The word UEHH inverted is: " + isPalindrome("UEHH"));
	}
	
	public static String isPalindrome(String value){		
		char[] letters = value.toCharArray();
		String invertedValue = "";
		for (int i = letters.length - 1; i >= 0; i--) {
			invertedValue = invertedValue + letters[i];
		}

		return invertedValue;
	}

}
