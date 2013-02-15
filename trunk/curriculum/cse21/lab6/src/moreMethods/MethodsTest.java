package moreMethods;

import static org.junit.Assert.*;

import org.junit.Test;

public class MethodsTest {
	
	static final int VALUE_COUNT = 20;

	@Test
	public void testInit () {
		long [ ] values = new long[VALUE_COUNT+1];
		Methods.init (values);
		for (int k=0; k<=VALUE_COUNT; k++) {
			assertEquals ("init should set all elements to 0.", 0, values[k]);
		}
	}
	
	@Test
	public void testSumAll1 ( ) {
		assertEquals ("sumAll(0) should be 0.", 0, Methods.sumAll (0));
		assertEquals ("sumAll(" + VALUE_COUNT + ") should be " + VALUE_COUNT*(VALUE_COUNT+1)/2 + ".", 
				VALUE_COUNT*(VALUE_COUNT+1)/2, Methods.sumAll (VALUE_COUNT));
	}
	
	@Test
	public void testSumAll2 ( ) {
		long [ ] values = new long[VALUE_COUNT+1];
		Methods.init (values);
		long sum = Methods.sumAll (values, VALUE_COUNT);
		for (int k=1; k<=VALUE_COUNT; k++) {
			assertEquals ("Array value #" + k + " should be " + k*(k+1)/2 + ".", 
				k*(k+1)/2, values[k]);
		}
	}
	
	@Test
	public void testSquareSum1 ( ) {
		assertEquals ("squareSum(0) should be 0.", 0, Methods.squareSum (0));
		assertEquals ("squareSum(" + VALUE_COUNT + ") should be " + VALUE_COUNT*(VALUE_COUNT+1)*(2*VALUE_COUNT+1)/6 + ".", 
				VALUE_COUNT*(VALUE_COUNT+1)*(2*VALUE_COUNT+1)/6, Methods.squareSum (VALUE_COUNT));
		
	}
	
	@Test
	public void testSquareSum2 ( ) {
		long [ ] values = new long[VALUE_COUNT+1];
		Methods.init (values);
		long sum = Methods.squareSum (values, VALUE_COUNT);
		for (int k=1; k<=VALUE_COUNT; k++) {
			assertEquals ("Array value #" + k + " should be " + k*(k+1)*(2*k+1)/6 + ".", 
					k*(k+1)*(2*k+1)/6, values[k]);
		}
	}
	
	@Test
	public void testFib1 ( ) {
		assertEquals ("The 0th Fibonacci number is 0.", 0, Methods.fib(0));
		assertEquals ("The 1st Fibonacci number is 1.", 1, Methods.fib(1));
		int precedingF = 0;
		int currentF = 1;
		for (int k=2; k<=VALUE_COUNT; k++) {
			int newF = precedingF + currentF;
			precedingF = currentF;
			currentF = newF;
		}
		assertEquals ("Fibonacci number " + VALUE_COUNT + " is " + currentF, currentF, Methods.fib(VALUE_COUNT));
	}
	
	@Test
	public void testFib2 ( ) {
		long [ ] values = new long[VALUE_COUNT+1];
		Methods.init (values);
		long sum = Methods.fib (values, VALUE_COUNT);
		assertEquals ("Array value 0 should be 0.", 0, values[0]);
		assertEquals ("Array value 1 should be 1.", 1, values[1]);		
		for (int k=2; k<=VALUE_COUNT; k++) {
			assertEquals ("Array value #" + k + " should be " + Methods.fib(k) + ".", 
					Methods.fib(k), values[k]);
		}
	}
	
	@Test
	public void testFactorial1 ( ) {
		assertEquals ("0! is 1.", 1, Methods.factorial(0));
		assertEquals ("1! is 1.", 1, Methods.factorial(1));
		long fact = 1;
		for (int k=VALUE_COUNT; k>1; k--) {
			fact = fact*k;
		}
		assertEquals ("" + VALUE_COUNT + "! is " + fact, fact, Methods.factorial(VALUE_COUNT));
	}
	
	@Test
	public void testFactorial2 ( ) {
		long [ ] values = new long[VALUE_COUNT+1];
		Methods.init (values);
		long sum = Methods.factorial (values, VALUE_COUNT);
		assertEquals ("Array value 0 should be 0.", 1, values[0]);
		assertEquals ("Array value 1 should be 1.", 1, values[1]);		
		for (int k=2; k<=VALUE_COUNT; k++) {
			assertEquals ("Array value #" + k + " should be " + Methods.factorial(k) + ".", 
					Methods.factorial(k), values[k]);
		}
	}
}
