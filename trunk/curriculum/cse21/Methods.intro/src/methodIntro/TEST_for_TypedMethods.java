package methodIntro;

import static org.junit.Assert.*;

import org.junit.Test;

public class TEST_for_TypedMethods extends systemout.SystemOutTest {
	
	int todo;
	
	@Test
	public void testOutput ( ) {
		collectUserOutput();
		String [ ] desiredOutput = {"7"};
		assertSOEquals("Your program should print 7.", desiredOutput);
	}

	@Test
	public void testMethodsUnchanged ( ) {
		// Make sure they didn't change silly.
	}

	@Test
	public void testMainContents ( ) {
		// Make sure that main contains calls to silly as specified.
	}

	@Override
	public void callUserCode() {
		String[ ] empty = {""};
		TypedMethods.main(empty);
	}

}
