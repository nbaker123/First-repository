/**
 * The purpose of this class is to mirror the traits and behavior of a movie ticket
 * 
 * I swear that I have not taken any code
 * @author Nicholas Baker
 */

public abstract class Ticket {
	private double price;
	private String movieName;
	private String rating;
	private int day;
	private int time;
	private final double TAXRATE= 0.096;
	enum Format{
		IMAX, THREE_D, NONE;
	}
	private Format f;

	/**
	 * Default constructor
	 */
	public Ticket() {
		price = 0;
		movieName = "";
		rating = "G";
		day = 1;
		time = 8;
		f = Format.NONE;
	}

	/**
	 * Parameter constructor
	 * @param name
	 * @param rating
	 * @param day
	 * @param time
	 * @param format (feature of movie)
	 */
	public Ticket(String name, String rating, int day, int time, String format) {
		price = 0;
		movieName = name;
		setRating(rating);
		setDay(day);
		setTime(time);
		setF(format);
	}

	/**
	 * Copy constructor
	 * @param t (a Ticket)
	 */
	public Ticket(Ticket t) {
		price = t.getPrice();
		movieName = t.getMovieName();
		rating = t.getRating();
		day = t.getDay();
		time = t.getTime();
		f = t.getF(0);
	}

	/**
	 * Returns the price of this ticket
	 * @return the price of the ticket
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price of this ticket to the desired value
	 * @param price
	 */
	public void setPrice(double price) {
		if(price < 0) this.price = 0;
		else this.price = price;
	}

	/**
	 * Returns the name of the movie on this ticket
	 * @return the name of the movie on this ticket
	 */
	public String getMovieName() {
		return movieName;
	}

	/**
	 * Sets the movie name on this ticket to the desired value
	 * @param movieName
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	/**
	 * Returns the rating of the movie on this ticket
	 * @return the rating of the movie on this ticket
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Sets the rating of the movie on this ticket to the desired rating.
	 * If the rating is not valid, then it will be set to "G" by default.
	 * @param rating
	 */
	public void setRating(String rating) {
		this.rating = "G";
		String[] ratings = {"G", "PG", "PG13", "R", "NR"};
		for(String str:ratings) 
			if(rating.equals(str)) this.rating = rating;
	}

	/**
	 * Returns the day of the movie on this ticket (1-31)
	 * @return the day of the movie on this ticket
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Sets the day of the movie on this ticket to the desired value.
	 * If the day is not between 1 and 31 (inclusive), then the day is set to 1 by default.
	 * @param day
	 */
	public void setDay(int day) {
		this.day = 1;
		if(day <= 31 && day >= 1) this.day = day;
	}

	/**
	 * Returns the time of the movie on this ticket in military time.
	 * @return the time of the movie on this ticket
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Sets the time of the movie on this ticket to the desired value.
	 * If the time is not between 8 and 23 (inclusive), then it is set to 8 by default.
	 * @param time
	 */
	public void setTime(int time) {
		this.time = 8;
		if(time <= 23 && time >= 8) this.time = time;
	}

	/**
	 * Returns the feature of the movie on this ticket in the form of an int.
	 * @return 0 for no feature, 1 for IMAX, 2 for 3D
	 */
	public int  getF() {
		if(f == Format.NONE) return 0;
		if(f == Format.IMAX) return 1;
		if(f == Format.THREE_D) return 2;
		return -1;
	}
	
	/**
	 * Returns the feature of this movie in the form of the enum Format
	 * @param g
	 * @return the feature of this movie as a Format
	 */
	private Format getF(int g) {
		return f;
	}

	/**
	 * Sets the feature of this movie to be the desired feature.
	 * @param f
	 */
	private void setF(Format f) {
		this.f = f;
	}

	/**
	 * Sets the feature of this movie to be the desired feature.
	 * If the string does not correspond with any of the possible features, then
	 * the feature will be set to NONE by default.
	 * @param str
	 */
	public void setF(String str) {
		switch(str) {
		case "IMAX": f = Format.IMAX; break;
		case "3D": f = Format.THREE_D; break;
		default: f = Format.NONE;
		}
	}

	/**
	 * Returns the tax rate for movie tickets (0.096)
	 * @return 0.096
	 */
	public double getTAXRATE() {
		return TAXRATE;
	}
	
	/**
	 * Returns a String containing the data on this movie ticket.
	 * @return a String containing data on this ticket
	 */
	@Override
	public String toString() {
		String format = "";
		String str = "";
		switch(f) {
		case IMAX: format = " IMAX"; break;
		case THREE_D: format = " 3D"; break;
		default: format = ""; break;
		}
		str = format+"  MOVIE: "+movieName+" Rating: "+rating
				+" Day: "+day+" Time: "+time+" Price: $"+price;
		return str;
	}

	/**
	 * (ABSTRACT) calculates the price of this ticket
	 * @return the price of this ticket
	 */
	public abstract double calculateTicketPrice();

	/**
	 * (ABSTRACT) returns the ID number on this ticket
	 * @return the ID number on this ticket
	 */
	public abstract int getId();
}
