import java.util.Scanner;
public class WindChill {
	public static void main(String[] args) {
		final double CONST_ONE = 35.74;
		final double CONST_TWO = 0.6215;
		final double CONST_THREE = 35.75;
		final double CONST_FOUR = 0.16;
		final double CONST_FIVE = 0.4275;
		double temperature = 0;
		double windSpeed = 0;
		double windChill = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("Wind Chill Calculator\n\n");
		System.out.print("Enter the temperature in Fahrenheit (must be >= -45 and <= 40): ");
		temperature = input.nextDouble();
		System.out.print("Enter the wind speed (must be >= 5 and <= 60): ");
		windSpeed = input.nextDouble();
		windChill = CONST_ONE + (CONST_TWO * temperature) - (CONST_THREE * (Math.pow(windSpeed, CONST_FOUR))) 
				+ (CONST_FIVE * (temperature * (Math.pow(windSpeed, CONST_FOUR))));
		System.out.print("\nWind chill temperature: " + windChill + " degrees Fahrenheit\n\n");
		System.out.print("Programmer: Nicholas Baker");
	}
}
