

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany m;
	Property p1 = new Property ("Almost", "Glen", 5678.00, "Solid Snake",2,1,2,4);
	Property p2 = new Property ("BIGCITY", "Lakewood", 2234, "Tom Clancy",5,1,4,2);
	Property p3 = new Property("SMALLCITY", "NEWYORK", 2234, "Tom JOHNSON",0,4,1,1);
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		m = new ManagementCompany("THENEWCOMPANY", "6678", 4000);
		//student add three properties, with plots, to mgmt co
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
	}

	@After
	public void tearDown() {
		m = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		Property p4 = new Property("j", "john", "house1", 200);
		assertEquals(3, m.addProperty(p4),0);
		//student should add property with 8 args
		Property p5 = new Property("Potomac", "Joe", 600, "HOUSE2", 0, 2, 1, 1);
		assertEquals(4, m.addProperty(p5),0);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		Property p6 = new Property("Potomac", "Joe", 600, "HOUSE2", 0, 2, 11, 11);
		assertEquals(-1, m.addProperty(p4),0);
	}
 
	@Test
	public void testMaxRentProp() {
		assertEquals(5678.0, m.maxRentProp(), 0);
		//student should test if maxRentProp contains the maximum rent of properties
		
	}

	@Test
	public void testTotalRent() {
		assertEquals(10146.0, m.totalRent(), 0);
	}

 }