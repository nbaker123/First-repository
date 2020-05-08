/**
 * The purpose of this class is to mirror the traits and behavior of a movie pass
 * 
 * I swear that I have not taken any code
 * @author Nicholas Baker
 */

public class MoviePass extends Ticket{

	private final double BEFORE6 = 10.5;
	private final double AFTER6 = 13.5;
	private int id;

	/**
	 * Default constructor
	 */
	public MoviePass() {
		super();
		id = 0;
	}

	/**
	 * Parameter constructor
	 * @param name
	 * @param rating
	 * @param date
	 * @param time
	 * @param f (feature of movie)
	 * @param id (ID number on this MoviePass)
	 */
	public MoviePass(String name, String rating, int date, int time, String f, int id) {
		super(name, rating, date, time, f);
		this.id = id;
		setPrice(calculateTicketPrice());
	}

	/**
	 * Copy constructor
	 * @param e (a MoviePass object)
	 */
	public MoviePass(MoviePass e) {
		super((Ticket) e);
	}

	/**
	 * Calculates the price of this MoviePass ticket. Only called by the manager if necessary
	 * Base price for adults (before or after 6) + feature price + tax
	 * @return the price of this ticket
	 */
	public double calculateTicketPrice() {
		double base = 0;
		double format = 0;
		double total = 0;

		if(getTime() < 18) base = BEFORE6;
		else base = AFTER6;

		switch(getF()) {
		case 1: format = 3; break;
		case 2: format = 2.5; break;
		default: format = 0;
		}
		total = base+format;
		return total+(base*getTAXRATE());
	}

	/**
	 * Returns the ID number on this MoviePass
	 * @return the ID number on this MoviePass
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns a String containing the data for this MoviePass ticket
	 * @return a String containing the data for this MoviePass ticket
	 */
	@Override
	public String toString() {
		return "MOVIEPASS-"+getId()+super.toString();
	}
}