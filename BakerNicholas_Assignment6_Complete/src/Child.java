/**
 * The purpose of this class is to mirror the traits and behavior of a child's movie ticket
 * 
 * I swear that I have not taken any code
 * @author Nicholas Baker
 */

public class Child extends Ticket{
	
	private final double BEFORE6 = 5.75;
	private final double AFTER6 = 10.75;
	
	/**
	 * Default constructor
	 */
	public Child() {
		super();
		setPrice(BEFORE6);
	}
	
	/**
	 * Parameter constructor
	 * @param name
	 * @param rating
	 * @param date
	 * @param time
	 * @param format (feature of movie)
	 */
	public Child(String name, String rating, int date, int time, String format) {
		super(name, rating, date, time, format);
		setPrice(calculateTicketPrice());
	}
	
	/**
	 * Copy constructor
	 * @param c (a Child object)
	 */
	public Child(Child c) {
		super((Ticket) c);
	}
	
	/**
	 * Calculates the price of this ticket.
	 * Base price for children (before or after 6) + feature price + tax
	 * @return the price of this ticket
	 */
	public double calculateTicketPrice() {
		double base = 0;
		double format = 0;
		double total = 0;
		
		if(getTime() < 18) base = BEFORE6;
		else base = AFTER6;
		
		switch(getF()) {
		case 1: format = 2; break;
		case 2: format = 1.5; break;
		default: format = 0;
		}
		total = base+format;
		return total+(total*getTAXRATE());
	}
	
	/**
	 * Returns -1 since child tickets do not have ID numbers
	 * @return -1
	 */
	public int getId() {
		return -1;
	}

	/**
	 * Returns the base price for a child ticket for a movie before 6 PM
	 * @return the base price for a child ticket for a movie before 6 PM
	 */
	public double getBEFORE6() {
		return BEFORE6;
	}

	/**
	 * Returns the base price for a child ticket for a movie at or after 6 PM
	 * @return the base price for a child ticket for a movie at or after 6 PM
	 */
	public double getAFTER6() {
		return AFTER6;
	}
	
	/**
	 * Returns a String containing the data for this ticket
	 * @return a String containing the data for this ticket
	 */
	@Override
	public String toString() {
		return "CHILD"+super.toString();
	}
}