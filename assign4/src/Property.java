/**
 * The main purpose of this class is to mirror the behavior of a property
 * to be used in ManagementCompany
 * 
 * I swear I have not copied any code
 * 
 * @author Nicholas Baker
 */

public class Property {
	
	//attributes
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	/**
	 *  No-arg Constructor, creates a new object with default values of empty 
	 *  strings, 0 for rent amount, and default Plot (sets the x, y values to zero, 
	 *  depth and width to 1)
	 */
	public Property() {
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0;
		plot = new Plot();
	}
	
	/**
	 *  Copy Constructor, creates a new object using the information of the object passed to it.
	 * @param p - a property object
	 */
	public Property(Property p) {
		this.city = p.city;
		this.owner = p.owner;
		this.propertyName = p.propertyName;
		this.rentAmount = p.rentAmount;
		plot = new Plot(p.plot);
	}

	/**
	 * Constructor, Parameterized constructor with no Plot information 
	 * (uses default Plot where x,y are set to 0, width and depth set to 1)
	 * @param city - the city where the property is located
	 * @param owner - the name of the owner of the property
	 * @param propertyName - the name of the property
	 * @param rentAmount - the rent amount for the property
	 */
	public Property(String city, String owner, String propertyName, double rentAmount) {
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		plot = new Plot();
	}

	/**
	 * Constructor, Parameterized constructor
	 * @param city - the city where the property is located
	 * @param owner - the owner of the property
	 * @param propertyName - the name of the property
	 * @param rentAmount - the rent amount for the property
	 * @param x - the x coordinate for the upper left corner of the plot
	 * @param y - the y coordinate for the upper left corner of the plot
	 * @param width - the width of the plot
	 * @param depth - the height of the plot
	 */
	public Property(String city, String owner, double rentAmount, String propertyName, 
			int x, int y, int width, int depth) {
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		plot = new Plot(x, y, width, depth);
	}

	/**
	 * Returns the city name
	 * @return the city name
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city name to the parameter value
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Returns the owner's name
	 * @return The owner's name
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Sets the owners name to the parameter value
	 * @param owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Returns the property name
	 * @return The property's name
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * Sets the property's name to the parameter value 
	 * @param propertyName
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * Returns the rent amount of this property
	 * @return The rent amount
	 */
	public double getRentAmount() {
		return rentAmount;
	}

	/**
	 * Sets the rent amount to the parameter value
	 * @param rentAmount
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	/**
	 * Returns the plot of this property
	 * @return The plot
	 */
	public Plot getPlot() {
		return plot;
	}
	/**
	 * Set the plot values
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public void setPlot(int x, int y, int width, int depth) {
		plot  = new Plot(x, y, width, depth);
	}
	
	/**
	 * Prints out the name, city, owner and rent amount for a property.
          Example:
              Property Name: Lakewood
               Located in Rockville
               Belonging to: Alex Tan
               Rent Amount: 3000.0
	 */
	public String toString() {
		return "Property Name: "+propertyName+"\n"
				+"  Located in "+city+"\n"
				+"  Belonging to: "+owner+"\n"
				+"  Rent Amount: "+rentAmount;
	}
}
