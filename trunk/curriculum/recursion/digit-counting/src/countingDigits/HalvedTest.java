package countingDigits;

import static org.junit.Assert.*;
import org.junit.Test;

public class HalvedTest {



	public class HRecursionTest extends Halved {
		public int called = 0;
		public int halved(int n) {
			called++;
			return super.halved(n);
		}
	}
	
	public class HPredicate extends Halved {
		
		int called = 0;
		
		// this is supposed to mimic what their halved() returns when called once
		public boolean halvedPredicate(int n) {
			called = 0;
			int val = halved(n);
			return (val == 0);
		}
		
		@Override
		public int halved(int n) {
			called++;
			if (called > 1) {
				// this is the 2nd time through, yo
				return 99;
			} else {
				//first time through...
				return super.halved(n);
			}
		}
	}
	
	
	@Test
	public void uses_recursion() {
		HRecursionTest hp = new HRecursionTest();
		hp.halved(30);
		assertTrue("Your procedure isn't using recursion!",(hp.called >= 15 ));
		hp.called = 0;
		hp.halved(8);
		assertTrue("Your procedure isn't using recursion!",(hp.called >= 4));
	}
	
	@Test
	public void halved_called_with_0() {
		Halved h = new Halved();
		assertEquals("Incorrect; called halved(0), and result was wrong", 0, h.halved(0));
	}
	
	@Test
	public void halved_called_with_1() {
		Halved h = new Halved();
		assertEquals("Incorrect; called halved(1), and result was wrong", 0, h.halved(1));
	}
	
	@Test
	public void halved_called_with_2() {
		Halved h = new Halved();
		assertEquals("Incorrect; called halved(2), and result was wrong", 1, h.halved(2));
	}
	
	@Test
	public void halved_called_with_5() {
		Halved h = new Halved();
		assertEquals("Incorrect; called halved(5), and result was wrong", 2, h.halved(5));
	}

	@Test
	public void halved_called_with_9999() {
		Halved h = new Halved();
		assertEquals("Incorrect; called halved(9999), and result was wrong", 4999, h.halved(9999));
	}
}
