import java.util.Scanner;

public class MovieDriver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Movie mov = new Movie();
		char answer = 'y';
		while(answer == 'y') {
			System.out.print("Enter the movie's title: ");
			mov.setTitle(input.nextLine());
			System.out.print("Enter the movie's rating: ");
			mov.setRating(input.nextLine());
			System.out.print("Enter the number of tickets sold for this movie: ");
			mov.setSoldTickets(Integer.parseInt(input.nextLine()));
			System.out.println(mov);
			System.out.print("Do you want to enter another? (y or n) ");
			answer = input.nextLine().charAt(0);
		}
		System.out.println("Goodbye");
	}
}
