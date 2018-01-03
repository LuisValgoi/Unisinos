import java.util.HashMap;
import java.util.Map.Entry;

/*
 * Complexity: 
 * O(n²) e O(n) 
 * 
 * 
 * What we want:
 * We want the number of our array that has more occurrence
 * 
 * 
 * Explanation (getModaDumb - O(n²))
 * We have a for that gets the current value
 * We have a second for that walks after it
 * We check if it is equals
 * We add to our external variables and we incremet the occurence variables
 * 
 * 
 * Explanation (getModaSmart - O(n))
 * We add the values of the array in a table (key = value, value = occurence)
 * then we check wich value has more occurence
 */

public class Moda {

	public static void main(String[] args) {
		int[] array = {10,11,12,13,14,14,14,14};
		
		// dumb way
		int response = getModaDumb(array);
		System.out.println(response);
		
		// smart way
		int response2 = getModaSmart(array);
		System.out.println(response2);
	}
	
	private static int getModaDumb(int[] arr){
		int moreOftenValueOccurrences 	= 0;
		int moreOftenValue 	 			= 0;
		
		for(int i = 0; i < arr.length; i++){
			int currentValue = arr[i];
			int currentValueOccurrences = 1;			
			
			for(int j = i+1; j < arr.length; j++){
				int nextValue = arr[j];
				
				if(currentValue == nextValue){
					currentValueOccurrences = currentValueOccurrences + 1;
				}
			}
			
			if(currentValueOccurrences > moreOftenValueOccurrences){
				moreOftenValue = currentValue;
				moreOftenValueOccurrences = currentValueOccurrences;
			}
		}
		
		return moreOftenValue;
	}

	private static int getModaSmart(int[] arr){
		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>(arr.length);
		
		for (int i = 0; i < arr.length; i++) {
			int value = arr[i];
			int key = value;
			
			if(table.containsKey(value)) {
				int occurrence = table.get(value) + 1;
				table.put(key, occurrence);
			}else {
				int occurrence = 1;
				table.put(key, occurrence);
			}				
		}
		
		int biggerValue = 0;
		int biggerOccurrence = 0;
		for (Entry<Integer, Integer> entrySet : table.entrySet()) {
			int value = entrySet.getKey();
			int occurrence = entrySet.getValue();
			
			if(occurrence > biggerOccurrence) {
				biggerValue = value;
				biggerOccurrence = occurrence;
			}				
		}
		
		return biggerValue;
	}
}
