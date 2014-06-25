import static org.junit.Assert.*;

import org.junit.Test;

import edu.berkeley.eduride.EduRideTest;


public class CheckDigitTest extends EduRideTest {

	@Test
	@Name("id=0")
	public void check0() {
		assertTrue("checkDigit(0) should return true", CheckDigit.checkDigit(0));
	}


	@Test
	@Name("id=1")
	public void check1() {
		assertFalse("checkDigit(1) should return false", CheckDigit.checkDigit(1));
	}

	@Test
	@Name("id=02")
	public void check02() {
		assertFalse("checkDigit(02) should return false", CheckDigit.checkDigit(02));
	}

	@Test
	@Name("id=10")
	public void check10() {
		assertFalse("checkDigit(10) should return false", CheckDigit.checkDigit(10));
	}

	@Test
	@Name("id=11")
	public void check11() {
		assertTrue("checkDigit(11) should return true", CheckDigit.checkDigit(11));
	}

	@Test
	@Name("id=31415924")
	public void check31415924() {
		assertTrue("checkDigit(31415924) should return true", CheckDigit.checkDigit(31415924));
	}

	@Test
	@Name("id=31415922")
	public void check31415922() {
		assertFalse("checkDigit(31415922) should return false", CheckDigit.checkDigit(31415922));
	}
	
}
