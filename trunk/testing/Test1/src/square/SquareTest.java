package square;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import edu.berkeley.eduride.EduRideTest.*;


@Description("Tests for Square.java")
public class SquareTest extends edu.berkeley.eduride.EduRideTest {
	// Nate: I didn't delete the annotations. I just put them in 
	// SquareTestComplicated for now, cuz I wanted to test with a simple test case first
	



	@Test
	@Name("Test Area (using assertTrue)")
	@SuccessMessage("You got it right!")
	@Description("BLAHBLAHBLAH")
	public void testAssertAreaTrue () {
		int obs = new Square(5).area();
		assertTrue("assertTrue failed", 25 == obs);

	}
	
	@Test
	@MethodCall("area(5)")
	public void testArea() {
		int obs = new Square(5).area();
		assertEquals("testArea failed", 25, obs);
	}
	

	
	@Test
	public void testPerimeter() {
		int obs = new Square(5).perimeter();
		assertEquals("testPerimiter failed", 20, obs);
	}
	
	
	
	
	@Ignore
	@Test
	/**
	 *  This a comment on the method
	 */
	public void ignoreThis() {
		Square sq = new Square(5);
		fail("This is the fail string, also a square of 5:" + sq);
	}
	
	
	@Test
	public void testAssertArrayEquals() {
		int[] x = {1,2,3,4,5,6,7,8,8,0};
		int[] y = {1,2,3,4,5,6,7,8,9,0};
		assertArrayEquals("assertArrayEquals failed", x,y);
	}
	
	
	
	
}
