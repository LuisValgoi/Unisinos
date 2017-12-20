
public class ArrayMulitply {

	public static void main(String[] args) {
		System.out.println("Array:");

		System.out.println("1 | 2 | 3 | 4 | 5 ");

		System.out.println("Multiplied Array:");

		int[] array = {1, 2, 3, 4, 5};
		for (int i : getMultipliedArray(array)) {
			System.out.print(i + " | ");
		}
	}
	
	public static int[] getMultipliedArray(int[] arr){
		int[] arrMult = new int[arr.length];
		
		int multTotal = 1; 
		for (int i = 1; i < arr.length; i++) {
			multTotal = multTotal * arr[i];
		}
		
		for (int i = 0; i < arrMult.length; i++) {
			if(arr[i] != 0)
				arrMult[i] = multTotal / arr[i];
		}
		
		return arrMult;
	}
}