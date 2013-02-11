package methodIntro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VoidMethodsWithParamsTest extends systemout.SystemOutTest {
	
	int todo;
	
//	@Test
//	public void test0 ( ) {
//		collectUserOutput ( );
//		String [ ] desiredOutput = { };
//		assertSOEquals("not equal", desiredOutput);
//	}

	@Test
	public void testgt0 ( ) {
		collectUserOutput ( );
		String [ ] desiredOutput = {"A", "A", "A"};
		assertSOEquals("not equal", desiredOutput);
	}

	@Test
	public void testMethodsUnchanged ( ) {
		// Make sure they didn't change m1, m2, or m3
	}

	@Test
	public void testMainContents ( ) {
		// Make sure that main contains a call to m1, m2, or m3,
		// then another call to m1, m2, or m3, and no other statements.
	}

	@Override
	public void callUserCode() {
		String[] empty = {""};
		VoidMethodsWithParams.main(empty);
	}
}
