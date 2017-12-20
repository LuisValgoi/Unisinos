/*
 * Complexity:
 * O(n)
 * 
 * 
 * What we want:
 * We want to check if a word is a palindrome
 * 
 * 
 * Explanation:
 * We know that a palindrome is a word that we are able to read from left to right and from right to left, equaly 
 * 
 */

public class Palindrome {

	public static void main(String[] args) {
		System.out.println("The word ARARA is a palindrome? " + isPalindrome("ARARA"));
	}

	public static String isPalindrome(String value){		
		char[] letters = value.toCharArray();
		String invertedValue = "";
		for (int i = letters.length - 1; i >= 0; i--) {
			invertedValue = invertedValue + letters[i];
		}

		if(invertedValue.equals(value)){
			return "Yes";
		}else{
			return "No";
		}
	}

}
