import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
	GradeBook g1 = new GradeBook(5);
	GradeBook g2 = new GradeBook(5);
	@Before
	public void setUp() throws Exception {
		g1 = new GradeBook(5);
		g1.addScore(5);
		g1.addScore(20);
		g1.addScore(65);
		g2 = new GradeBook(5);
		g2.addScore(10);
		g2.addScore(70);
		g2.addScore(30);
	}

	@After
	public void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	public void testAddScore() {
		System.out.println(g1.toString());
		assertTrue(g1.toString().equals("5.0 20.0 65.0"));
		assertTrue(g2.toString().equals("10.0 70.0 30.0"));
		assertEquals(3, g1.getScoresSize());
		assertEquals(3, g2.getScoresSize());
	}

	@Test
	public void testSum() {
		assertEquals(90, g1.sum(), 0);
		assertEquals(90, g1.sum(), 0);
	}

	@Test
	public void testMinimum() {
		assertEquals(5.0, g1.minimum(), 0);
		assertEquals(10.0, g2.minimum(), 0);
	}

	@Test
	public void testFinalScore() {
		assertEquals(85.0, g1.finalScore(), 0);
		assertEquals(100.0, g2.finalScore(), 0);
	}

}
