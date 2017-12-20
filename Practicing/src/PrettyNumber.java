/*
 * Complexity:
 * O(2n) ou O(n)
 * 
 * 
 * What we want:
 * We want all numbers that are divisible by 2, 3 and 6 from a range passed as argument
 * 
 * 
 * Explanation:
 * We know that for a number be divisible by 6, it is by 2 and 3, necessarily
 * So, we find the first number and then we increment it to be faster 
 * 
 */

public class PrettyNumber {

	public static void main(String[] args) {
		System.out.println("From 1 to 30, these are the pretty numbers:");
		getPrettyNumber(1, 30);
	}
	
	private static void getPrettyNumber(int n1, int n2){
		int firstNumber = 0;
		for(int i = n1; i <= n2; i++){
			if(i % 6 == 0){
				firstNumber = i;
				break;
			}
		}
		
		for(int j = firstNumber; j <= n2; j+=6){
			System.out.print(j + " | ");
		}
	}

}
