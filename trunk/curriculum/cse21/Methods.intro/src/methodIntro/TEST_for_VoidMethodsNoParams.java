package methodIntro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TEST_for_VoidMethodsNoParams extends systemout.SystemOutTest {
	
	int todo;
	
	@Test
	public void testOutput ( ) {
		todo = 1;
		collectUserOutput();
		String [ ] desiredOutput = {"C", "B", "B"};
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
		if (todo==1 ) {
		  VoidMethodsNoParams.main(empty);
		} else if (todo==2) {
			VoidMethodsNoParams.m1();
		}
	}
}
