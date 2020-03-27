/**
 * The main purpose of this class is to mirror the behavior of a plot of land
 * to be used in ManagementCompany
 * 
 * I swear I have not copied any code
 * 
 * @author Nicholas Baker
 */

public class Plot {
	
	//Attributes
	private int x, y, width, depth;
	
	/**
	 * No-arg Constructor, creates a Plot with x=0, y=0, width=1, depth=1
	 */
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	/**
	 * Copy Constructor, creates a new Plot using the information of the Plot passed to it.
	 * @param p - a Plot object
	 */
	public Plot(Plot p) {
		x = p.x;
		y = p.y;
		width = p.width;
		depth = p.depth;
	}
	
	/**
	 * Parameterized constructor
	 * @param x - the x coordinate of the upper left corner
	 * @param y - the y coordinate of the upper left corner
	 * @param width - the width of the rectangle
	 * @param depth - the height of the rectangle
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * Determines if this plot overlaps the parameter
	 * @param plot
	 * @return Returns true if this plot overlaps the parameter, false otherwise
	 */
	public boolean overlaps(Plot plot) {
		
		//Finds the upper and lower most of the two plots
		Plot upperMost;
		Plot lowerMost;
		
		if(plot.y > this.y) {
			upperMost = this;
			lowerMost = plot;
		}
		else {
			upperMost = plot;
			lowerMost = this;
		}
		
		//Determines if the plots overlap by first checking if one contains the other,
		//then by checking if their lines intersect
		if(upperMost.encompasses(lowerMost)) return true;
		if(upperMost.x >= lowerMost.x+lowerMost.width) return false;
		else {
			if((upperMost.y+upperMost.depth > lowerMost.y) 
					&& (upperMost.x+upperMost.width > lowerMost.x))
				return true;
		}
		return false;
	}
	
	/**
	 * Determines if this plot encompasses the parameter
	 * @param plot
	 * @return Returns true if this plot encompasses the parameter, false otherwise
	 */
	public boolean encompasses(Plot plot) {
		//Checks to see that plot's upper left corner is in a place that allows it to be
		//contained by the current plot, then determines if it is contained. If it is, the
		//method returns true
		if((plot.x < this.x+this.width && plot.x >= this.x) 
				&& (plot.y < this.y+this.depth && plot.y >= this.y)) {
			if((plot.y+plot.depth <= this.y+this.depth) 
					&& (plot.x+plot.width <= this.x+this.depth))
				return true;
		}
		
		//If this is not true, the method returns false
		return false;
	}
	
	/**
	 * Returns the x value
	 * @return the x value
	 */
	public int getX() {
		return x;
	}

	/**
	 * sets the x value
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Returns the y value
	 * @return the y value
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y value
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Returns the width value
	 * @return the width value
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * sets the width value
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Returns the depth value
	 * @return The depth value
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * Sets the depth value
	 * @param depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 * Prints the information about this plot
	 * @return the String representation of a Plot object in the following format:
	 *	Upper left: (1,1); Width: 3 Depth: 3
	 */
	public String toString() {
		return "Upper left: ("+x+","+y+"); Width: "+width+" Depth: "+depth;
	}
}
