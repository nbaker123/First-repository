
public class CarTest {
	public static void main(String[] args) {
		
		Car c = new Car(2005, "Audi");
		for(int i = 0; i < 5; i++) {
			c.accelerate();
			System.out.println(c.getSpeed());
		}
		for(int i = 0; i < 5; i++) {
			c.brake();
			System.out.println(c.getSpeed());
		}
	}
}
