/*  
 * Complexity: 
 * O(2n) ou O(n)
 * 
 * What we want:
 * We want see the number unique numbers
 * 
 * 
 * Explanation:
 * We have a hash map (dictionary / table) that has:
 * KEY = single array value
 * VALUE = value's occurrence
 * If already exists, increment the value of that key
 * Get all keys
 * If its occurrence == 1 == UNIQUE
 * 
 */

import java.util.HashMap;

public class UniqueNumber {

	public static void main(String[] args) {
		System.out.println("Array: 11 | 12 | 13 | 14 | 15 | 16 | 16 | 16");
		int[] array = {11, 12, 13, 14, 15, 16, 16, 16};
		smart(array);
	}
	
	public static void smart(int[] array){
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();	
		
		for(int number : array){
			if (!hashMap.containsKey(number))
				hashMap.put(number, 1);
			else
				hashMap.put(number, hashMap.get(number)+1);
		}

		for(Integer keyValue : hashMap.keySet()){
			int keyOccurrence = hashMap.get(keyValue); 
			if(keyOccurrence == 1)
				System.out.println(keyValue + " is unique!");
		}
	}

}
