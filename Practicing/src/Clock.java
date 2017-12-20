/*
 * Complexity: O(1)
 * 
 * Explanation:
 * We know that:
 * 1 hour has 30�
 * 1 minute has 6�
 * Minutes do change the pointer clock
 * 
 */

public class Clock {
	public static void main(String[] args){
		System.out.println("1:30 in the clock has: " + getClockPointerAngle(1, 30) + "� between its pointers.");
		System.out.println("2:30 in the clock has: " + getClockPointerAngle(2, 30) + "� between its pointers.");
	}

	private static double getClockPointerAngle(int hour, int minutes){
		double angHours = 0;
		double angMinutes = 0;

		if(hour == 12){
			angHours = 0;
		}

		// we know that each hour has 30�
		double minutesInfluence = (minutes / 60.0) * 30;
		angHours = (hour * 30) + (minutesInfluence);

		// we know that each minute has 6�
		angMinutes = minutes * 6;

		if(angHours > angMinutes){
			return angHours - angMinutes;		
		}else{
			return angMinutes - angHours;
		}
	}
}