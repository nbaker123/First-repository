/**
 * The purpose of this class is to represent a management company of properties
 * 
 * I swear that I have not taken any code
 * @author Nicholas Baker
 *
 */

public class ManagementCompany {
	private final int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;

	/**
	 *   No-Arg Constructor that creates a ManagementCompany object 
	 *   using empty strings and the plot set to a Plot with x, y set to 0 , width and depth set to 10.
	 *   properties array is initialized here as well.
	 */
	public ManagementCompany() {
		name = "";
		taxID = "";
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}

	/**
	 * Constructor Creates a ManagementCompany object using the passed information.
plot is set to a Plot with x, y set to 0 , width and depth set to 10
properties array is initialized here as well
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.mgmFeePer = mgmFee;
		this.name = name;
		this.taxID = taxID;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	/**
	 * Constructor Creates a ManagementCompany object using the passed information.
	 * @param mgmFee
	 * @param name
	 * @param taxID
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public ManagementCompany(double mgmFee, String name, String taxID, int x, int y, int width, int depth) {
		this.mgmFeePer = mgmFee;
		this.name = name;
		this.taxID = taxID;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}

	/**
	 * Copy Constructor that creates a ManagementCompany object from another ManagementCompany object
	 * @param otherCompany
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		plot = new Plot(otherCompany.plot);
		properties = otherCompany.properties;
	}

	/**
	 * Adds the property object to the "properties" array
	 * @param property
	 * @return Returns either -1 if the array is full, -2 if property is null, -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property, or the index in the array where the property was added successfully.
	 */
	public int addProperty(Property property) {

		//If the property is null, return -2
		if(property == null) return -2;

		//Making a deep copy just to be safe
		Property newProp = new Property(property);

		//int for the index to put the property in. It is -1 if an index
		//has not been found
		int index = -1;

		//Returns -1 if the properties array is full
		if(properties[properties.length-1] != null) return -1;

		//Determines what else to do and return based on the situation
		if(!this.plot.encompasses(newProp.getPlot())) return -3;
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] == null && index == -1) {
				properties[i] =newProp;
				index = i;
			}
			else if(properties[i] == null) continue;
			else if(newProp.getPlot().overlaps(properties[i].getPlot())) return -4;
		}
		if(index != -1) {
			properties[index] = newProp;
			return index;
		}

		//In case nothing happens in the control section
		return -1;
	}
	
	/**
	 * Creates a property object and adds it to the "properties" array, in a default plot.
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return Returns either -1 if the array is full, -2 if property is null, -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property, or the index in the array where the property was added successfully.
	 */
	public int addProperty(String name,String city,double rent,String owner) {

		//If the property is null, return -2
		if(name == null || city == null || owner == null) 
			return -2;

		//Creating the property
		Property newProp = new Property(city, owner, name, rent);

		//Returns -1 if the properties array is full
		if(properties[properties.length-1] != null) return -1;

		//int for the index to put the property in. It is -1 if an index
		//has not been found
		int index = -1;

		//Determines what else to do and return based on the situation
		if(!this.plot.encompasses(newProp.getPlot())) return -3;
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] == null && index == -1) {
				properties[i] =newProp;
				index = i;
			}
			else if(properties[i] == null) continue;
			else if(newProp.getPlot().overlaps(properties[i].getPlot())) return -4;
		}
		if(index != -1) {
			properties[index] = newProp;
			return index;
		}

		//In case nothing happens in the control section
		return -1;
	}

	/**
	 * Creates a property object and adds it to the "properties" array.
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return Returns either -1 if the array is full, -2 if property is null, -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property, or the index in the array where the property was added successfully.
	 */
	public int addProperty(String name,String city,double rent,String owner,int x,int y,int width,int depth) {

		//If any of the Strings are null, return -2
		if(name == null || city == null || owner == null) 
			return -2;

		//Creating the property
		Property newProp = new Property(city, owner, rent, name, x, y, width, depth);

		//Returns -1 if the properties array is full
		if(properties[properties.length-1] != null) return -1;

		//int for the index to put the property in. It is -1 if an index
		//has not been found
		int index = -1;

		//Determines what else to do and return based on the situation
		if(!this.plot.encompasses(newProp.getPlot())) return -3;
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] == null && index == -1) {
				properties[i] =newProp;
				index = i;
			}
			else if(properties[i] == null) continue;
			else if(newProp.getPlot().overlaps(properties[i].getPlot())) return -4;
		}
		if(index != -1) {
			properties[index] = newProp;
			return index;
		}

		//In case nothing happens in the control section
		return -1;
	}

	/**
	 * This method accesses each "Property" object within the array "properties" 
	 * and sums up the property rent and returns the total amount.
	 * @return Total rent
	 */
	public double totalRent() {
		double total = 0;
		for(int i = 0; i < properties.length; i++) 
			if(properties[i] != null) total += properties[i].getRentAmount();
		return total;
	}

	/**
	 * This method finds the property with the maximum rent amount and returns its toString result.
	 * @return Highest rent amount
	 */
	public double maxRentProp() {
		double largest = -999;
		for(int i = 0; i < properties.length; i++)
			if(properties[i] != null && properties[i].getRentAmount() > largest)
				largest = properties[i].getRentAmount();
		return largest;
	}

	/**
	 * This method finds the index of the property with the maximum rent amount.
	 * @return
	 */
	public int maxRentPropertyIndex() {
		double largest = -999;
		int index = 0;
		for(int i = 0; i < properties.length; i++)
			if(properties[i] != null && properties[i].getRentAmount() > largest) {
				largest = properties[i].getRentAmount();
				index = i;
			}
		return index;
	}

	/**
	 * DIaplays property information at index i
	 * @param i
	 * @return information on property at index i
	 */
	public String displayPropertyAtIndex(int i) {
		return properties[i].toString();
	}

	/**
	 * Returns management fee
	 * @return management fee
	 */
	public double getMgmFeePer() {
		return mgmFeePer;
	}

	/**
	 * Sets management fee
	 * @param mgmFeePer
	 */
	public void setMgmFeePer(double mgmFeePer) {
		this.mgmFeePer = mgmFeePer;
	}

	/**
	 * Returns company name
	 * @return company name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets company name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns the properties array
	 * @return properties array
	 */
	public Property[] getProperties() {
		return properties;
	}

	/**
	 * Sets the properties array
	 * @param properties
	 */
	public void setProperties(Property[] properties) {
		this.properties = properties;
	}

	/**
	 * Gets the taxID of the company
	 * @return taxID
	 */
	public String getTaxID() {
		return taxID;
	}

	/**
	 * Sets the taxID of the company
	 * @param taxID
	 */
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	/**
	 * Returns the company's plot
	 * @return plot
	 */
	public Plot getPlot() {
		return plot;
	}

	/**
	 * Sets the company's plot
	 * @param plot
	 */
	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	/**
	 * Returns 5
	 * @return 5
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	/**
	 * returns 10
	 * @return 10
	 */
	public int getMGMT_WIDTH() {
		return MGMT_WIDTH;
	}

	/**
	 * Returns 10
	 * @return 10
	 */
	public int getMGMT_DEPTH() {
		return MGMT_DEPTH;
	}

	/**
	 * Returns information on all of the properties in the company
	 * @return Information on all of the company's properties
	 */
	public String toString() {
		String str = "List of the properties for "+name+", taxID: "+taxID
				+"/n-------------------------------------------------";
		for(int i = 0; i < properties.length; i++)
			str += properties[i].toString()+"\n";
		return str;
	}
}
