/**
   This program demonstrates how numeric types and operators behave in Java
*/
import java.util.Scanner;
public class NumericTypes {
	public static void main (String [] args) {
		//TASK #2 Create a Scanner object here
		Scanner input = new Scanner(System.in);
		//identifier declarations
		final int NUMBER = 2; // number of scores
		int score1 = 0; // first test score
		int score2 = 0; // second test score
		final int BOILING_IN_F = 212; // boiling temperature
		double fToC; // temperature in Celsius
		double average; // arithmetic average
		String output; // line of output to print out
		//Task #2 declare a variable to hold the user’s temperature
		int otherTemperature = 0;
		//Task #2 prompt user to input score1
		System.out.print("Enter a score: ");
		//Task #2 read score1 
		score1 = input.nextInt();
		//Task #2 prompt user to input score2
		System.out.print("Enter another score: ");
		//Task #2 read score2 
		score2 = input.nextInt();
		// Find an arithmetic average
		average = (score1 + score2) / NUMBER;
		output = score1 + " and " + score2 + " have an average of " + average;	
		System.out.println(output);
		// Convert Fahrenheit temperatures to Celsius
		fToC = ((double) 5/9) *(BOILING_IN_F - 32);
		output = BOILING_IN_F + " in Fahrenheit is " + fToC + " in Celsius.";
		System.out.println(output);
		//Task #2 prompt user to input another temperature
		System.out.print("Enter another temperature in Fahrenheit: ");
		//Task #2 read the user’s temperature in Fahrenheit
		otherTemperature = input.nextInt();
		//Task #2 convert the user’s temperature to Celsius
		fToC = ((double) 5/9) *(otherTemperature - 32);
		//Task #2 print the user’s temperature in Celsius
		System.out.println(otherTemperature + " in Fahrenheit is " + fToC + " in Celsius.");
		System.out.println("Goodbye"); // to show that the program is ended	
	}
}
