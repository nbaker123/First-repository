/**
 * The purpose of this class is to mirror the traits and behavior of an employee's movie ticket
 * 
 * I swear that I have not taken any code
 * @author Nicholas Baker
 */

public class Employee extends Ticket{
	
	private final double BEFORE6 = 10.5;
	private final double AFTER6 = 13.5;
	private int id;	
	
	/**
	 * Default constructor
	 */
	public Employee() {
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
	 * @param id (ID number of employee)
	 */
	public Employee(String name, String rating, int date, int time, String f, int id) {
		super(name, rating, date, time, f);
		this.id = id;
		setPrice(calculateTicketPrice());
	}
	
	/**
	 * Parameter constructor
	 * @param e (an Employee object)
	 */
	public Employee(Employee e) {
		super((Ticket) e);
	}
	
	/**
	 * Calculates the price of this ticket.
	 * 1/2(Base price for adults (before or after 6) + feature price) + tax
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
		total = (base*0.5+format);
		return total+(total*getTAXRATE());
	}
	
	/**
	 * Returns the ID number of this employee
	 * @return the ID number of this employee
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Returns the base price for an employee ticket for a movie before 6 PM
	 * @return the base price for an employee ticket for a movie before 6 PM
	 */
	public double getBEFORE6() {
		return BEFORE6;
	}

	/**
	 * Returns the base price for an employee ticket for a movie at or after 6 PM
	 * @return the base price for an employee ticket for a movie at or after 6 PM
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
		return "EMPLOYEE-"+getId()+super.toString();
	}
}