
public class Moda {

	public static void main(String[] args) {
		int[] array = {10,11,12,13,14,14};
		int response = getModa(array);
		System.out.println(response);
	}
	
	private static int getModa(int[] arr){		
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

}
