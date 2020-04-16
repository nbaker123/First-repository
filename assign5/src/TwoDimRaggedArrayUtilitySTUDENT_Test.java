import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT = {{1, 4, 6}, {7, 8, 9, 0}, {2, 3, 5}};
	
	private File inputFile ,outputFile = new File("TestOut.txt");

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(45, TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT), 0.1);	
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(4.5, TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT), 0.1);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(11,  TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 0), 0.1);
		assertEquals(24,  TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 1), 0.1);
		assertEquals(10,  TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 2), 0.1);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(10,  TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 0), 0.1);
		assertEquals(15,  TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 1), 0.1);
		assertEquals(20,  TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 2), 0.1);
		assertEquals(0,  TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 3), 0.1);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(9,  TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT), 0.1);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() {
		double[][] array=null;
		 TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT, outputFile);
		 array = TwoDimRaggedArrayUtility.readFile(outputFile);
		 assertEquals(1, array[0][0], 0.1);
		 assertEquals(4, array[0][1], 0.1);
		 assertEquals(6, array[0][2], 0.1);
		 
		 assertEquals(7, array[1][0], 0.1);
		 assertEquals(8, array[1][1], 0.1);
		 assertEquals(9, array[1][2], 0.1);
		 assertEquals(0, array[1][3], 0.1);
		 
		 assertEquals(2, array[2][0], 0.1);
		 assertEquals(3, array[2][1], 0.1);
		 assertEquals(5, array[2][2], 0.1);
	}

}