import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import systemout.SystemOutTest;


public class TEST_for_Lab21_3_Error extends SystemOutTest{

	static String[] output_template= 
		{"We sell %d kinds of Cheese",
		"Dalaran Sharp: $1.25 per pound",
		"Stormwind Brie: $10.0 per pound",
		"Alterac Swiss: $40.0 per pound",
		"Cheese Type D: $9.15 per pound",
		"Cheese Type E: $2.5 per pound",
		"Cheese Type F: $8.74 per pound",
		"Cheese Type G: $9.88 per pound",
		"Cheese Type H: $2.91 per pound",
		"Cheese Type I: $6.66 per pound",
		"Cheese Type J: $0.36 per pound",
		"Cheese Type K: $2.88 per pound",
		"Cheese Type L: $7.23 per pound",
		"Cheese Type M: $7.13 per pound",
		"Cheese Type N: $6.22 per pound",
		"Cheese Type O: $7.17 per pound",
		"Cheese Type P: $2.56 per pound",
		"Cheese Type Q: $4.57 per pound",
		"Cheese Type R: $3.52 per pound",
		"Cheese Type S: $0.59 per pound",
		"Cheese Type T: $3.8 per pound"};
	
	static String[] get_output(int len) {
		String[] ret = Arrays.copyOf(output_template, (len + 1));
		
		ret[0] = String.format(ret[0], len);
		
		return ret;
	}
	
	@Override
	public void callUserCode() {
		String[] empty = {""};
		Lab21_3_Error.main(empty);
	}

	
	
	public void innerTest(int value) {
		Lab21_3_Error.MAXCHEESE = value;
		Lab21_3_Error.ranGen = new Random(100);
		try {
			collectUserOutput();
			assertSOEquals("Your output is incorrect when MAXCHEESE is set to " + value, get_output(value));
		} catch (Exception e) {
			fail("Your code crashes when MAXCHEESE is set to " + value);
		}

	}

	@Test
	public void maxcheeseIs0() {
		innerTest(0);
	}


	@Test
	public void maxcheeseIs1() {
		innerTest(1);
	}
	

	@Test
	public void maxcheeseIs2() {
		innerTest(2);
	}
	

	@Test
	public void maxcheeseIs3() {
		innerTest(3);
	}
	

	@Test
	public void maxcheeseIs4() {
		innerTest(4);
	}
	

	@Test
	public void maxcheeseIs9() {
		innerTest(9);
	}
	

	@Test
	public void maxcheeseIs20() {
		innerTest(20);
	}
	
	
}
