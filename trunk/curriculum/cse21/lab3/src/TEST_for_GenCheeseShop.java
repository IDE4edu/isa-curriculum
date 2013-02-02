import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import systemout.SystemOutTest;

public class TEST_for_GenCheeseShop extends SystemOutTest {

	static String[] output_template = { "We sell %d kinds of Cheese",
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
			"Cheese Type T: $3.8 per pound" };
	
	static String[ ] cheese_purchase_requests 
		= { "Enter the amount of Dalaran Sharp: ",
			"Enter the amount of Stormwind Brie: ",
			"Enter the amount of Alterac Swiss: ",
			"Enter the amount of Cheese Type D: ",
			"Enter the amount of Cheese Type E: ",
			"Enter the amount of Cheese Type F: ",
			"Enter the amount of Cheese Type G: ",
			"Enter the amount of Cheese Type H: ",
			"Enter the amount of Cheese Type I: ",
			"Enter the amount of Cheese Type J: ",
			"Enter the amount of Cheese Type K: ",
			"Enter the amount of Cheese Type L: ",
			"Enter the amount of Cheese Type M: ",
			"Enter the amount of Cheese Type N: ",
			"Enter the amount of Cheese Type O: ",
			"Enter the amount of Cheese Type P: ",
			"Enter the amount of Cheese Type Q: ",
			"Enter the amount of Cheese Type R: ",
			"Enter the amount of Cheese Type S: ",
			"Enter the amount of Cheese Type T: "
	};
	
	static String[ ] itemizedList = { "Display the itemized list? (1 for yes) ",
		"1 lbs of Dalaran Sharp @ 1.25 = $1.25",
		"1 lbs of Stormwind Brie @ 10.0 = $10.0",
		"1 lbs of Alterac Swiss @ 40 = $40.0", 
		"1 lbs of Cheese Type D @ 9.15 = $9.15",
		"1 lbs of Cheese Type E @ 2.5 = $2.5", 
		"1 lbs of Cheese Type F @ 8.74 = $8.74",
		"1 lbs of Cheese Type G @ 9.88 = $9.88", 
		"1 lbs of Cheese Type H @ 2.91 = $2.91",
		"1 lbs of Cheese Type I @ 6.66 = $6.66", 
		"1 lbs of Cheese Type J @ 0.36 = $0.36",
		"1 lbs of Cheese Type K @ 2.88 = $2.88", 
		"1 lbs of Cheese Type L @ 7.23 = $7.23",
		"1 lbs of Cheese Type M @ 7.13 = $7.13", 
		"1 lbs of Cheese Type N @ 6.22 = $6.22",
		"1 lbs of Cheese Type O @ 7.17 = $7.17", 
		"1 lbs of Cheese Type P @ 2.56 = $2.56",
		"1 lbs of Cheese Type Q @ 4.57 = $4.57", 
		"1 lbs of Cheese Type R @ 3.52 = $3.52",
		"1 lbs of Cheese Type S @ 0.59 = $0.59", 
		"1 lbs of Cheese Type T @ 3.8 = $3.8" 
	};
	
	static String[] summary_info
		= {"Sub Total: %f", "-Discount: %f", "Total    : %f"};
	
	static int[] cheeseBuys = {1, 0, 2, 0, 3, 0, 4, 0, 5, 0};

	static String[] get_output(int len) {
		String[] ret = Arrays.copyOf(output_template, (len + 1));

		ret[0] = String.format(ret[0], len);

		return ret;
	}

	@Override
	public void callUserCode() {
		String[] empty = { "" };
		GenCheeseShop.main(empty);
	}

	public void innerTest(int value) {
		GenCheeseShop.MAXCHEESE = value;
		GenCheeseShop.ranGen = new Random(100);
		try {
			collectUserOutput();
			assertSOEquals("Your output is incorrect when MAXCHEESE is set to "
					+ value, get_output(value));
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
