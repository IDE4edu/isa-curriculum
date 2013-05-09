package edu.berkeley.eduride.testing.tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquareTestComplicated extends edu.berkeley.eduride.EduRideTest{
	
	@Test
	@MethodCall("new Square(5).area()")
	@hideWhenSuccessful
	@Description("BLAHBLAHBLAH")
	public void testAssertSame() {
		assertSame("assertSame failed", 1,2);
	}

	@Test
	@Name("new Square(5).area()")
	@SuccessMessage("You got it right!")
	@Description("BLAHBLAHBLAH")
	public void testAssertArrayEquals() {
		int[] x = {1,2,3,4,5,6,7,8,8,0};
		int[] y = {1,2,3,4,5,6,7,8,9,0};
		assertArrayEquals("assertArrayEquals failed", x,y);
	}
	
	@Test
	@MethodCall("new Square(5).area()")
	@hideWhenSuccessful
	@Description("BLAHBLAHBLAH")
	public void testAssertTrue() {
		int obs = new Square(5).area();
		assertTrue("assertTrue failed", 25 == obs);
	}
	
	@Test
	@MethodCall("new Square(5).area()")
	@hideWhenSuccessful
	@Expected("25")
	@Description("Hipster ipsum  Whatever thundercats high life chillwave scenester stumptown, put a bird on it ethnic tofu fingerstache american apparel")
	public void testArea1() {
		int obs = new Square(5).area();
		assertEquals("testArea1 failed", 25, obs);
	}
	
	@Test
	@MethodCall("new Square(3).area()")
	@SuccessMessage("You got it woot!")
	@Expected("25")
	public void testArea2() {
		int exp = 9;
		@Observed
		int obs = new Square(3).area();
		assertEquals("testArea2 failed", exp, obs);
	}
	
	
	@Test
	@Name("new Square(5).perimeter()")
	@hideWhenSuccessful
	@Expected("25")
	public void testPerimeter() {
		int obs = new Square(5).perimeter();
		assertEquals("testPerimiter failed", 20, obs);
	}
}
