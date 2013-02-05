import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.xml.crypto.KeySelector.Purpose;

import org.junit.Before;
import org.junit.Test;

import systemout.SystemOutTest;

public class TEST_for_GenCheeseShop extends SystemOutTest {

	static String[] selling_list_template = { "We sell %d kinds of Cheese",
			"Dalaran Sharp: $1.25 per pound",
			"Stormwind Brie: $10.0 per pound",
			"Alterac Swiss: $40.0 per pound", "Cheese Type D: $9.15 per pound",
			"Cheese Type E: $2.5 per pound", "Cheese Type F: $8.74 per pound",
			"Cheese Type G: $9.88 per pound", "Cheese Type H: $2.91 per pound",
			"Cheese Type I: $6.66 per pound", "Cheese Type J: $0.36 per pound",
			"Cheese Type K: $2.88 per pound", "Cheese Type L: $7.23 per pound",
			"Cheese Type M: $7.13 per pound", "Cheese Type N: $6.22 per pound",
			"Cheese Type O: $7.17 per pound", "Cheese Type P: $2.56 per pound",
			"Cheese Type Q: $4.57 per pound", "Cheese Type R: $3.52 per pound",
			"Cheese Type S: $0.59 per pound", "Cheese Type T: $3.8 per pound" };

	// arg, this part may fail badly because students will use System.out.print rather than println...
	// and, it will cause the line numbers to screw up -- with out.print, all of these are come on one line with the next line as well.
	static String[] cheese_purchase_requests = {
			"Enter the amount of Dalaran Sharp:",
			"Enter the amount of Stormwind Brie:",
			"Enter the amount of Alterac Swiss:",
			"Enter the amount of Cheese Type D:",
			"Enter the amount of Cheese Type E:",
			"Enter the amount of Cheese Type F:",
			"Enter the amount of Cheese Type G:",
			"Enter the amount of Cheese Type H:",
			"Enter the amount of Cheese Type I:",
			"Enter the amount of Cheese Type J:",
			"Enter the amount of Cheese Type K:",
			"Enter the amount of Cheese Type L:",
			"Enter the amount of Cheese Type M:",
			"Enter the amount of Cheese Type N:",
			"Enter the amount of Cheese Type O:",
			"Enter the amount of Cheese Type P:",
			"Enter the amount of Cheese Type Q:",
			"Enter the amount of Cheese Type R:",
			"Enter the amount of Cheese Type S:",
			"Enter the amount of Cheese Type T:" };

	static String[] itemizedList = {
			"%d lbs of Dalaran Sharp @ 1.25 = $1.25",
			"%d lbs of Stormwind Brie @ 10.0 = $10.0",
			"%d lbs of Alterac Swiss @ 40.0 = $40.0",
			"%d lbs of Cheese Type D @ 9.15 = $9.15",
			"%d lbs of Cheese Type E @ 2.5 = $2.5",
			"%d lbs of Cheese Type F @ 8.74 = $8.74",
			"%d lbs of Cheese Type G @ 9.88 = $9.88",
			"%d lbs of Cheese Type H @ 2.91 = $2.91",
			"%d lbs of Cheese Type I @ 6.66 = $6.66",
			"%d lbs of Cheese Type J @ 0.36 = $0.36",
			"%d lbs of Cheese Type K @ 2.88 = $2.88",
			"%d lbs of Cheese Type L @ 7.23 = $7.23",
			"%d lbs of Cheese Type M @ 7.13 = $7.13",
			"%d lbs of Cheese Type N @ 6.22 = $6.22",
			"%d lbs of Cheese Type O @ 7.17 = $7.17",
			"%d lbs of Cheese Type P @ 2.56 = $2.56",
			"%d lbs of Cheese Type Q @ 4.57 = $4.57",
			"%d lbs of Cheese Type R @ 3.52 = $3.52",
			"%d lbs of Cheese Type S @ 0.59 = $0.59",
			"%d lbs of Cheese Type T @ 3.8 = $3.8" };

	static String[] get_selling_list(int len) {
		String[] ret = Arrays.copyOf(selling_list_template, (len + 1));
		ret[0] = String.format(ret[0], len);
		return ret;
	}
	
	static String[] get_purchase_requests(int len) {
		return (Arrays.copyOf(cheese_purchase_requests, len));
	}

	static List<String> get_itemized_list(String[] amounts) {
		ArrayList<String> ret = new ArrayList<String>();
		for (int i=0; i<amounts.length; i++) {
			int amt = Integer.parseInt(amounts[i]);
			String line = itemizedList[i];
			if (amt > 0) {
				ret.add(String.format(line, amt));
			}
		}
		return (ret);
	}
	
	//////
	
	private double get_subtotal() {
		int line_index = userOutput.size() - 2 - 1; // third to last line
		return (get_dollar_amount_at_end(userOutput.get(line_index)));
	}

	private double get_discount() {
		int line_index = userOutput.size() - 1 - 1; // second to last line
		return (get_dollar_amount_at_end(userOutput.get(line_index)));

	}

	private double get_total() {
		int line_index = userOutput.size() - 1; // last line
		return (get_dollar_amount_at_end(userOutput.get(line_index)));
	}

	private double get_dollar_amount_at_end(String s) {
		int i = s.lastIndexOf("$") + 1;
		String aft = s.substring(i).trim(); // take out white space also
		return (Double.parseDouble(aft));
	}

	
	
	// should be inside a @Test, since it will fail if there is no field.
	private void set_MAXCHEESE(int val) {
		Class<?> c = GenCheeseShop.class;
		try {
			c.getField("MAXCHEESE");
		} catch (NoSuchFieldException e) {
			fail("NOTE: this test won't work, because you have defined MAXCHEESE inside your 'main' method, instead of above it.  Please move it above 'main', as shown in 'Lab21_3_Error.java'.");
		} catch (SecurityException e) {
			//  they don't allow reflection, hm...   what to do, what to do...
			e.printStackTrace();
		}
		GenCheeseShop.MAXCHEESE = val;
	}

	// gets called in before every test, via @Before
	private void set_randGen() {
		Class<?> c = GenCheeseShop.class;
		try {
			c.getField("ranGen");
		} catch (NoSuchFieldException e) {
			fail("NOTE: this test won't work, because you have defined 'ranGen' inside your 'main' method, instead of above it.  Please move it above 'main', as shown in 'Lab21_3_Error.java'.");
		} catch (SecurityException e) {
			// they don't allow reflection, hm...   what to do, what to do...
			e.printStackTrace();
		}
		GenCheeseShop.ranGen = new Random(100);
	}

	
	///////////
	
	
	// This is a sneaky thing we can do to catch the situation where the user 
	// has put the Scanner outside of main, which means it won't get recreated for each 
	// call to System.setIn for setUserInput().  Here, we bank on the fact that the 
	// Scanner is in a variable named 'input' ... if it isn't, we're doomed.
	@Override
	public void setUserInput(String[] input) {
		super.setUserInput(input);   // do the real setUserInput, which makes a new System.in
		Class<?> c = GenCheeseShop.class;
		try {
			Field f = c.getField("input");
			// no exception?  its there...
			f.set(null, new Scanner(System.in));
		} catch (Exception e){
			// whole lots of ways to be here-- all of them can be ignored
		}

	}


	@Override
	public void callUserCode() {
		String[] empty = { "" };
		GenCheeseShop.main(empty);

	}

	
	// before every test...
	@Before
	public void before_setup() {
		set_randGen();
	}

	// //////////
	// TESTS



	@Test
	// maxcheese of 0
	public void maxCheese_is_0() {
		set_MAXCHEESE(0);
		try {
			collectUserOutput();
			assertSONumLines(
					"When MAXCHEESE is 0, you should only have 4 lines of output",
					4);
			assertEquals("When MAXCHEESE is 0, your subtotal should be $0.00",
					get_subtotal(), 0.0, 0.0);
			assertEquals("When MAXCHEESE is 0, your discount should be $0.00",
					get_discount(), 0.0, 0.0);
			assertEquals("When MAXCHEESE is 0, your total should be $0.00",
					get_total(), 0.0, 0.0);
		} catch (Exception e) {
			fail("Your code crashes when MAXCHEESE is set to 0");
		}
	}

	@Test
	public void buy_one_of_each() {
		set_MAXCHEESE(4);
		try {
			String[] cheeseBuys = { "1", "1", "1", "1" };
			collectUserOutput(cheeseBuys);
			debug(userOutput);
			assertSOHasLines(
					"Your code doesn't list the cheese types correctly when MAXCHEESE is 4",
					0, get_selling_list(4));
			assertSOHasLines("Your code doesn't ask the user to input amounts correctly when MAXCHEESE is 4",
					5, get_purchase_requests(4));
			assertSOHasLines("Your code doesn't print out the ordered amounts when MAXCHEESE is 4 and one pound of each was ordered",
					9, get_itemized_list(cheeseBuys));
			assertEquals("When MAXCHEESE is 4 and one pound of each was ordered, your subtotal is wrong",
					get_subtotal(), 60.4, 0.0);
			assertEquals("When MAXCHEESE is 4 and one pound of each was ordered, your discount is wrong",
					get_discount(), 10.0, 0.0);
			assertEquals("When MAXCHEESE is 4 and one pound of each was ordered, your total is wrong",
					get_total(), 50.4, 0.0);
		} catch (Exception e) {
			fail("Your code crashes when MAXCHEESE is 4 and the user requests 1 pound of each type.");
		}
	}


	
	

}
