/*
 * Complexity:
 * O(n)
 * 
 * 
 * What we want:
 * We want to see the valued passed as string in a inverted way  
 * 
 * 
 * Explanation:
 * We add to an char array the string content
 * We go through this array
 * - starting athe the lenght - 1 UNTIL it is >= 0
 * we add to an temp string
 * we return it
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
