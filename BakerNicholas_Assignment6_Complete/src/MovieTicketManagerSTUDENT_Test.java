

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieTicketManagerSTUDENT_Test {
	private MovieTicketManager ticketList;
	

	@Before
	public void setUp() throws Exception {
		ticketList = new MovieTicketManager();
		
		//Student add adult tickets
		ticketList.addTicket("Endgame", "PG13", 4,19,"NONE","Adult",0);
		ticketList.addTicket("A Quiet Place", "PG13", 2,12,"NONE","Adult",0);
		//Student add children tickets
		ticketList.addTicket("Little Mermaid", "G", 5,20,"NONE","Child",0);
		ticketList.addTicket("Little Mermaid", "G", 2,14,"NONE","Child",0);
		//Student add employee tickets
		ticketList.addTicket("Deadpool", "NR", 5,19,"NONE","Employee",12345);
		ticketList.addTicket("Action Point", "NR", 2,12,"NONE","Employee",12345);
		//Student add MoviePass member tickets
		ticketList.addTicket("Deadpool", "R", 5,19,"NONE","MoviePass",22222);
		ticketList.addTicket("Deadpool", "R", 1,13,"IMAX","MoviePass",22222);
	}

	@After
	public void tearDown() throws Exception {
		ticketList = null;
	}

	/**
	 * Student Test the number of visits to the theater within the month
	 * This only applied to those who have id members - Employees or MoviePass members
	 */
	@Test
	public void testNumVisits() {
		//Student test Employees' number of visits
		assertEquals(2, ticketList.numVisits(12345));
		//Student test MoviePass members' number of visits
		assertEquals(2, ticketList.numVisits(22222));
	}

	/**
	 * Student Test the number of times this movie has been viewed
	 * This only applied to those who have id numbers - Employees or MoviePass members
	 */
	@Test
	public void testNumThisMovie() {
		//Student test Employees' number of views
		assertEquals(1, ticketList.numThisMovie(12345, "Deadpool"));
		//Student test MoviePass members' number of views
		assertEquals(2, ticketList.numThisMovie(22222, "Deadpool"));
	}

}