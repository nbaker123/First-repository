/**
 * The purpose of this class is to use the MovieTicketManagerInterface to mirror the
 * behavior of a movie ticket manager by keeping track of tickets, reading, sorting,
 * determining prices, adding,  and providing data for reports.
 * 
 * I swear that I have not taken any code
 * @author Nicholas Baker
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MovieTicketManager implements MovieTicketManagerInterface{

	private ArrayList<Ticket> tickets;
	
	public MovieTicketManager() {
		tickets = new ArrayList<Ticket>();
	}
	/**
	 * Returns the number of times this patron has visited the theater this month
	 * @param id of the patron
	 * @return the number of times this patron has visited the theater this month
	 */
	@Override
	public int numVisits(int id) {
		int count = 0;
		for(Ticket t:tickets) {
			if(t instanceof Employee || t instanceof MoviePass)
				if(t.getId() == id) count++;
		}
		return count;
	}

	/**
	 * Returns the number of times the patron has seen this movie
	 * @param id the id of the patron
	 * @param movie name of the movie
	 */
	@Override
	public int numThisMovie(int id, String movie) {
		int count = 0;
		for(Ticket t:tickets) {
			if(t instanceof Employee || t instanceof MoviePass)
				if(t.getId() == id && t.getMovieName().equals(movie)) count++;
		}
		return count;
	}

	/**
	 * Checks to see if this patron already saw a movie today
	 * @param id id of patron
	 * @param date current date
	 * @return number of movies the patron has seen today
	 */
	@Override
	public int numMoviesToday(int id, int date) {
		int count = 0;
		for(Ticket t:tickets) {
			if(t instanceof Employee || t instanceof MoviePass)
				if(t.getId() == id && t.getDay() == date) count++;
		}
		return count;
	}

	/**
	 * Adds a patron to the list and returns the ticket price
	 * @param m movie to be watched
	 * @param rating movie rating
	 * @param d date
	 * @param t time
	 * @param f feature
	 * @param type type of patron
	 * @param id id of the patron
	 * @return the price of the ticket. Returns -1 if type is invalid
	 */
	@Override
	public double addTicket(String movieN, String rating, int d, int t, String f, String type, int id) {
		Ticket ticket;
		if(type.equals("Child")) {
			ticket = new Child(movieN, rating, d, t, f);
			tickets.add(ticket);
			return ticket.getPrice();
		}
		else if(type.equals("Adult")) {
			ticket = new Adult(movieN, rating, d, t, f);
			tickets.add(ticket);
			return ticket.getPrice();
		}		
		else if(type.equals("Employee")) {
			ticket = new Employee(movieN, rating, d, t, f, id);
			if(numVisits(ticket.getId()) < 2) ticket.setPrice(0);
			
			//No else statement here because the default price was already set
			tickets.add(ticket);
			return ticket.getPrice();
		}
		else if(type.equals("MoviePass")) {
			ticket = new MoviePass(movieN, rating, d, t, f, id);
			if(numVisits(ticket.getId()) == 0) ticket.setPrice(9.99);
			else {
				if(numMoviesToday(id, d) == 0 && 
						numThisMovie(id, movieN) == 0 && f.equals("NONE"))
					ticket.setPrice(0);
				
				//No else statement because the default ticket price was already set beforehand
				//Just in case this if statement did not run
			}
			tickets.add(ticket);
			return ticket.getPrice();
		}		
		else return -1;
	}

	/**
	 * Returns the sales for the entire month
	 * @return the sales for the entire month
	 */
	@Override
	public double totalSalesMonth() {
		double sum = 0;
		for(Ticket t:tickets) {
			//System.out.println(t.getPrice());
			sum += t.getPrice();
		}
		System.out.println();
		return sum;
	}

	
	@Override
	public String monthlySalesReport() {
		double childTotal = 0;
		double adultTotal = 0;
		double employTotal = 0;
		double passTotal = 0;
		int childCount = 0;
		int adultCount = 0;
		int employCount = 0;
		int passCount = 0;
		for(Ticket t:tickets) {
			if(t instanceof Child) {
				childTotal += t.getPrice();
				childCount++;
			}
			if(t instanceof Adult) {
				adultTotal += t.getPrice();
				adultCount++;
			}
			if(t instanceof Employee) {
				employTotal += t.getPrice();
				employCount++;
			}
			if(t instanceof MoviePass) {
				passTotal += t.getPrice();
				passCount++;
			}
		}
		return "Monthly Sales Report\n\n"
				+ "		Sales		Number\n"
				+ "ADULT   "+adultTotal+"		"+adultCount+"\n"
				+"CHILD   "+childTotal+"			"+childCount+"\n"
				+"EMPLOYEE   "+employTotal+"			"+employCount+"\n"
				+"MOVIEPASS   "+passTotal+"			"+passCount+"\n"
						+ "Total Monthly Sales: $"+totalSalesMonth();
	}

	/**
	 * Returns an arraylist of strings that represent 3D tickets sorted by day
	 * @return an arraylist of strings that represent 3D tickets sorted by day
	 */
	@Override
	public ArrayList<String> get3DTickets() {
		ArrayList<Ticket> threeD = new ArrayList<Ticket>();
		ArrayList<String> result = new ArrayList<String>();
		for(Ticket t:tickets)
			if(t.getF() == 2) 
				threeD.add(t);
		threeD = sortByDay(threeD);
		for(int i = 0; i < threeD.size(); i++) {
			result.add(threeD.get(i).toString());
		}
		return result;
	}

	/**
	 * Returns an arrayList of strings which represent tickets, in chronological order
	 * use the toString of each Ticket in the ticketList
	 * @return an arrayList of strings which represent tickets, in chronological order
	 */
	@Override
	public ArrayList<String> getAllTickets() {
		ArrayList<String> result = new ArrayList<String>();
		tickets = sortByDay(tickets);
		for(Ticket t:tickets) {
			result.add(t.toString());
		}
		System.out.println("DONE");
		return result;
	}

	/**
	 * Returns an Arraylist of string representation of MoviePass tickets sorted by movieId
	 * @return an Arraylist of string representation of MoviePass tickets sorted by movieId
	 */
	@Override
	public ArrayList<String> getMoviePassTickets() {
		ArrayList<Ticket> passes = new ArrayList<Ticket>();
		ArrayList<String> result = new ArrayList<String>();
		for(Ticket t:tickets)
			if(t instanceof MoviePass) 
				passes.add(t);
		passes = sortById(passes);
		for(Ticket t:passes) {
			result.add(t.toString());
		}
		return result;
	}

	/**
	 * Reads from a file and populates an arraylist of Ticket objects
	 * @param file file to be read from
	 * @throws FileNotFoundException when file is not found
	 */
	@Override
	public void readFile(File file) throws FileNotFoundException {
		try {
			Scanner inFile = new Scanner(file);
			String str = "";
			String[] strs;
			while(inFile.hasNext()) {
				str = inFile.nextLine();
				strs = str.split(":");
				addTicket(strs[0], strs[1], Integer.parseInt(strs[2]), Integer.parseInt(strs[3]), 
						strs[4], strs[5], Integer.parseInt(strs[6]));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sorts the ArrayList of Tickets in chronological order
	 * @param tArray
	 * @return an ArrayList of Tickets Sorted in chronological order
	 */
	private ArrayList<Ticket> sortByDay(ArrayList<Ticket> tArray){
		for(int i = 1; i < tArray.size(); i++) {
			for(int j = i; j > 0; j--) {
				if(tArray.get(j).getDay() < tArray.get(j-1).getDay())
					Collections.swap(tArray, j, j-1);
			}
		}
		return tArray;
	}
	
	/**
	 * Sorts the ArrayList of Tickets by ID number 
	 * @param tArray
	 * @return an ArrayList of Tickets sorted by ID number
	 */
	private ArrayList<Ticket> sortById(ArrayList<Ticket> tArray){
		for(int i = 1; i < tArray.size(); i++) {
			for(int j = i; j > 0; j--) {
				if(tArray.get(j).getId() < tArray.get(j-1).getId())
					Collections.swap(tArray, j, j-1);
			}
		}
		return tArray;
	}
	
	public void print(ArrayList<String> ticket1) {
		for(String t:ticket1)
			System.out.println(t);
	}
	
	public int getSize() {
		return tickets.size();
	}
	
	public Ticket get(int i) {
		return tickets.get(i);
	}
}
