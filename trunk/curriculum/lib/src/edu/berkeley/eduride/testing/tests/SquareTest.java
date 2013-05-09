package edu.berkeley.eduride.testing.tests;
import static org.junit.Assert.*;

import java.lang.annotation.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

//@RunWith(CustomRunner.class)
public class SquareTest extends edu.berkeley.eduride.EduRideTest {
	// Nate: I didn't delete the annotations. I just put them in 
	// SquareTestComplicated for now, cuz I wanted to test with a simple test case first
	
	
	@Ignore
	@Test
	/**
	 *  This a comment on the method
	 */
	public void ignoreThis() {
		fail("THIS IS THE FAIL STRING yo");
	}
	
	@Test
	public void testAssertSame() {
		assertSame("assertSame failed", 1,1);
	}

	@Ignore
	@Test
	public void testAssertArrayEquals() {
		int[] x = {1,2,3,4,5,6,7,8,8,0};
		int[] y = {1,2,3,4,5,6,7,8,9,0};
		assertArrayEquals("assertArrayEquals failed", x,y);
	}
	
	@Test
	public void testAssertTrue() {
		int obs = new Square(5).area();
		assertTrue("assertTrue failed", 25 == obs);

	}
	
	@Test
	public void testArea() {
		int obs = new Square(5).area();
		assertEquals("testArea1 failed", 25, obs);
	}
	

	
	@Test
	public void testPerimeter() {
		int obs = new Square(5).perimeter();
		assertEquals("testPerimiter failed", 20, obs);
	}
}
