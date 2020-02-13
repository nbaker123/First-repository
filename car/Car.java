
public class Car {
	
	private int yearModel;
	private String make;
	private int speed;
	
	//Constructor
	public Car(int y, String m) {
		yearModel = y;
		make = m;
		speed = 0;
	}

	public int getYearModel() {
		return yearModel;
	}

	public void setYearModel(int yearModel) {
		this.yearModel = yearModel;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void accelerate() {
		speed += 5;
	}
	
	public void brake() {
		speed -= 5;
	}
}
