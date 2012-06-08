package src.test;
import src.NumberCheck;
import static org.junit.Assert.*;
import org.junit.Test;


public class NumberCheckTest {


	@Test
	public void tEven() {   
		run(randomEven());}

	@Test
	public void tOdd() {   
		run(randomEven() + 1);}

	@Test
	public void tNEven() {   
		run(-1 * randomEven());}

	@Test
	public void tNOdd() {   
		run(-1 * (randomEven() - 1));}
	
	@Test
	public void t2() { run(2);}

	@Test
	public void t1() { run(1);}

	@Test
	public void t0() { run(0);}

	@Test
	public void tn1() { run(-1);}

	@Test
	public void tn2() { run(-2);}


	
	
	private void run(int p) {
		NumberCheck obj = new NumberCheck(p);

		if ((isOdd(p) != obj.isOdd()) && (isEven(p) != obj.isEven())) {
			fail("Both isEven and isOdd were incorrect.  They should have returned " + isEven(p) + " and " + isOdd(p) + " respectively.  ");
		}
		assertEquals("<tt>isOdd</tt> of " + p + " is incorrect.", isOdd(p), obj.isOdd());
		assertEquals("<tt>isEven</tt> of " + p + " is incorrect.", isEven(p), obj.isEven());

	}


	private int randomEven() {
		return (((int)(Math.random() * 10)) * 2); 
	}


	private boolean isEven(int n) {
		return ((n % 2) == 0);
	}

	private boolean isOdd(int n) {
		return (!(isEven(n)));
	}

}