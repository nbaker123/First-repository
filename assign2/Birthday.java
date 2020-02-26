import java.util.Random;

import javax.swing.JOptionPane;

public class Birthday {
	public static void main(String[] args) {
		
		/*Declares the variables for the toy name, child name, child age,
		 *the random number generator to be used, and the variable to
		 *store the random number in*/
		String toyName;
		String name;
		int age;
		Random rand = new Random();
		int number = rand.nextInt(10000);
		
		//**NOTE: ALL S.O.P's ARE FOR THE SCREENSHOTS
		
		//choice is used and recycled for every yes or no type prompt
		String choice = "yes";

		//Prints the welcome message
		JOptionPane.showMessageDialog(null, "Welcome to the Toy Company"
				+ "\nto choose gifts for young children");
		System.out.println("Welcome to the Toy Company to choose gifts for young children\n\n");

		//As long as the user wishes to keep buying toys, the program will continue running
		while(choice.toLowerCase().equals("yes")) {

			//Prompts for and stores the child's name and age, and the toy's name
			name = JOptionPane.showInputDialog("Enter the name of the child");
			System.out.println("Enter the name of the child: "+name);
			age = Integer.parseInt(JOptionPane.showInputDialog("How old is the child?"));
			System.out.println("How old is the child? "+age);
			toyName = JOptionPane.showInputDialog("Choose a toy: a plushie, blocks, or a book");
			System.out.println("Choose a toy: a plushie, blocks, or a book: "+toyName);
			
			//Creates a Toy object with the toy name and child's age
			Toy toyOfInterest = new Toy(toyName, age);

			//If the toy name is not valid, then the user must input it again
			while(toyOfInterest.getToy() == "") {
				JOptionPane.showMessageDialog(null, "Invalid choice\nPlease choose again");
				System.out.println("Invalid choice. Please choose again.");
				toyName = JOptionPane.showInputDialog("Choose a toy: a plushie, blocks, or a book");
				System.out.println("\"Choose a toy: a plushie, blocks, or a book: "+toyName);
				
				//Recreates toyOfInterest with the new toy name
				toyOfInterest = new Toy(toyName, age);
			}

			//If the toy is not age appropriate, then a warning message will be printed
			while(!toyOfInterest.ageOK()) {
				choice = JOptionPane.showInputDialog("Toy is not age appropriate"
						+ "\nDo you want to buy a different toy?");
				System.out.println("Toy is not age appropriate. "
						+ "Do you want to buy a different toy? "+choice);

				//If the user wants to replace the toy, he/she must input it again
				if(choice.toLowerCase().equals("yes")) {
					toyName = JOptionPane.showInputDialog("Choose a toy: a plushie, blocks, or a book");
					System.out.println("Choose a toy: a plushie, blocks, or a book: "+toyName);
					
					//Recreates toyOfInterest with the new toy name
					toyOfInterest = new Toy(toyName, age);
				}
				
				//If the user does not want to replace the toy, then the program moves on
				else break;
			}
			
			//If the toy is age appropriate, then the program praises the user
			if(toyOfInterest.ageOK()) {
				JOptionPane.showMessageDialog(null, "Good choice!");
				System.out.println("Good choice!");
			}
			
			//Asks the user if he/she wants a card with the gift, and adds to the price of the gift if yes
			choice = JOptionPane.showInputDialog("Do you want a card with the gift? Yes or No");
			System.out.println("Do you want a card with the gift? Yes or No: "+choice);
			toyOfInterest.addCard(choice);
			choice = JOptionPane.showInputDialog("Do you want a balloon with the gift? Yes or No");
			System.out.println("Do you want a balloon with the gift? Yes or No: "+choice);
			toyOfInterest.addBalloon(choice);
			
			//Prints the child's name and age, and the final price of his/her gift
			JOptionPane.showMessageDialog(null, "The gift for "+name+toyOfInterest.toString());
			System.out.println("\nThe gift for "+name+toyOfInterest.toString());
			
			//Asks the user if he/she wants another toy. If so, this loop iterates again
			choice = JOptionPane.showInputDialog("Do you want another toy? Yes or No");
			System.out.println("Do you want another toy? Yes or No: "+choice);
			System.out.println();
		}
		
		//Prints order number and programmer's name
		JOptionPane.showMessageDialog(null, "Order number is "+number+
				"\nProgrammer: Nicholas Baker");
		System.out.println("Order number is "+number+
				"\nProgrammer: Nicholas Baker");
	}
}
