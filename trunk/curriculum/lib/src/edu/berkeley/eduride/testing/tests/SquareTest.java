package edu.berkeley.eduride.testing.tests;
import static org.junit.Assert.*;

import java.lang.annotation.*;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CustomRunner.class)
public class SquareTest extends EduRideJunitTestClass{
	// Nate: I didn't delete the annotations. I just put them in 
	// SquareTestComplicated for now, cuz I wanted to test with a simple test case first
	
	@Test
	public void testAssertSame() {
		assertSame("assertSame failed", 1,1);
	}

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
	public void testArea1() {
		int obs = new Square(5).area();
		assertEquals("testArea1 failed", 25, obs);
	}
	
	@Test
	public void testArea2() {
		int exp = 9;
		int obs = new Square(3).area();
		assertEquals("testArea2 failed", exp, obs);
	}
	
	
	@Test
	public void testPerimeter() {
		int obs = new Square(5).perimeter();
		assertEquals("testPerimiter failed", 20, obs);
	}
}
