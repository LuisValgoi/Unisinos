package progii.comparable;

public class Cars1 implements Comparable<Cars1>{

	private String carName;
	private String carDesc;
	private int power;

	public Cars1(String carName, String carDesc, int power) {
		this.carName = carName;
		this.carDesc = carDesc;
		this.power = power;
	}

	public String getcarName() {
		return carName;
	}
	public void setcarName(String carName) {
		this.carName = carName;
	}
	public String getcarDesc() {
		return carDesc;
	}
	public void setcarDesc(String carDesc) {
		this.carDesc = carDesc;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	public int compareTo(Cars1 compareCar) {
		int comparePower = compareCar.getPower(); 

		//ascending order
		return this.power - comparePower; 

		//descending order
		//return comparePower - this.power;
	}
}    
