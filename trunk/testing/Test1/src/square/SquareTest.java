package square;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import edu.berkeley.eduride.EduRideTest.*;


@Description("Tests for Square.java")
public class SquareTest extends edu.berkeley.eduride.EduRideTest {
	
	
	@Test
	@Name("Tests of 'area'")
	public void testArea() {
		int obs5 = new Square(5).area();
		assertEquals("A square with sides of 5 didn't calculate area correctly", 25, obs5);
		int obs0 = new Square(0).area();
		assertEquals("A square with sides of 0 didn't calculate area correctly", 0, obs0);
		int obs100 = new Square(5).area();
		assertEquals("A square with sides of 5 didn't calculate area correctly", 10000, obs100);
	}
	

	// Maybe there should be a name and no fail message instead?
	@Test
	@hideWhenSuccessful
	public void testConstructor() {
		try {
			new Square(-1);
			new Square(10000);
			new Square (0);
		} catch (Exception e) {
			fail("The Square class threw an exception when constructed!");
		}
	}
	
	
	@Test
	@MethodCall("perimeter(5)")
	public void testPerimeter5() {
		assertEquals(20, new Square(5).perimeter());
	}
	

	
	@Test
	@MethodCall("perimeter(100)")
	public void testPerimeter100() {
		assertEquals(400, new Square(100).perimeter());
	}
	
	
	
	@Test
	@MethodCall("perimeter(0)")
	public void testPerimeter0() {
		assertEquals(0, new Square(0).perimeter());
	}
	
	
	
	
	
	@Ignore
	@Test
	/**
	 *  This a comment on the method
	 */
	public void ignoreThis() {
		fail("This test should be ignored");
	}
	

	
	
}
