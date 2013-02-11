package methodIntro;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

public class TEST_for_TypedMethods_1 extends systemout.SystemOutTest {
	
	int todo;
	
	@Test
	public void test_Output ( ) {
		collectUserOutput();
		String [ ] desiredOutput = {"1"};
		assertSOEquals("Your program should print 1.", desiredOutput);
	}

	@Test
	@Ignore
	public void test_MethodsUnchanged ( ) {
		// Make sure they didn't change silly.
	}

	@Test
	@Ignore
	public void test_MainContents ( ) {
		// Make sure that main contains calls to silly as specified.
	}

	@Override
	public void callUserCode() {
		String[ ] empty = {""};
		TypedMethods_1.main(empty);
	}

}
