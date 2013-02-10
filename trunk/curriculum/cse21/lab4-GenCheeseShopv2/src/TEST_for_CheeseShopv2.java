import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;
//import systemout.SystemOutTest;

// gotta rewrite this when, one day, I rewrite systemouttest

public class TEST_for_CheeseShopv2 extends SystemOutTest {

	// super hack to the rescue...
	final int CHECK_main = 0;
	final int CHECK_intro = 1;
	final int CHECK_getAmount = 2;
	// final int CHECK_calcSubTotal = 3;
	final int CHECK_itemizedList = 4;
	// final int CHECK_discount = 5;
	final int CHECK_printTotal = 6;

	int testMethod;

	Scanner getAmount_input;
	String getAmount_name;

	int il_sharp;
	int il_brie;
	int il_swiss;

	double pt_subTotal;
	int pt_discount;

	@Override
	// oh, a hack we will write, a hack we will write, ...
	public void callUserCode() {
		String[] empty = { "" };
		switch (testMethod) {
		case CHECK_main:
			CheeseShopv2.main(empty);
			break;
		case CHECK_intro:
			CheeseShopv2.intro();
			break;
		case CHECK_getAmount:
			CheeseShopv2.getAmount(getAmount_input, getAmount_name);
			break;
		case CHECK_itemizedList:
			CheeseShopv2.itemizedList(il_sharp, il_brie, il_swiss);
			break;
		case CHECK_printTotal:
			CheeseShopv2.printTotal(pt_subTotal, pt_discount);
			break;
		}
	}

	@Test
	public void test_intro() {
		String[] desiredOutput = { "We sell 3 kinds of Cheese",
				"Dalaran Sharp: $1.25 per pound",
				"Stormwind Brie: $10.00 per pound",
				"Alterac Swiss: $40.00 per pound" };
		testMethod = CHECK_intro;
		collectUserOutput();
		assertSOEquals(
				"The intro() method isn't writing the exact desired output",
				desiredOutput);
	}

	@Test
	@Ignore
	public void test_getAmount() {
		fail("We aren't able to test getAmount yet");
	}

	@Test
	public void test_calcSubTotal() {
		cst_help(0, 0, 0);
		cst_help(5, 0, 0);
		cst_help(0, 7, 0);
		cst_help(0, 0, 11);
		cst_help(3, 6, 0);
		cst_help(19, 0, 12);
		cst_help(0, 13, 4);
		cst_help(45, 15, 98);
	}

	private void cst_help(int sharp, int brie, int swiss) {
		try {
			double correct = sharp * 1.25 + brie * 10.0 + swiss * 40.00;
			assertEquals("Your calcSubTotal method is incorrect with " + sharp
					+ " lbs sharp, " + brie + " lbs brie, and " + swiss
					+ " lbs swiss.", correct,
					CheeseShopv2.calcSubTotal(sharp, brie, swiss), 0.0);
		} catch (Exception e) {
			fail("Your calcSubTotal method crashed with " + sharp
					+ " lbs sharp, " + brie + " lbs brie, and " + swiss
					+ " lbs swiss.");
		}
	}

	@Test
	public void test_itemizedList() {
		il_help(0, 0, 0);
		il_help(5, 0, 0);
		il_help(0, 7, 0);
		il_help(0, 0, 11);
		il_help(23,41, 57);
	}

	private void il_help(int sharp, int brie, int swiss) {
		try {
			ArrayList<String> desiredOutput = new ArrayList<String>();
			if (sharp > 0)
				desiredOutput.add(sharp + " lbs of Sharp @ $1.25 = $" + sharp
						* 1.25);
			if (brie > 0)
				desiredOutput.add(brie + " lbs of Brie @ $10.00 = $" + brie * 10.0);
			if (swiss > 0)
				desiredOutput.add(swiss + " lbs of Swiss @ $40.00 = $" + swiss
						* 40.00);
			testMethod = CHECK_itemizedList;
			il_sharp = sharp;
			il_brie = brie;
			il_swiss = swiss;
			collectUserOutput();
			String[] temp = {};
			String[] dout =  desiredOutput.toArray(temp);
//			debug("with " + sharp
//					+ " lbs sharp, " + brie + " lbs brie, and " + swiss
//					+ " lbs swiss.");
			//debug(dout);
			//debug(userOutput);
			assertSOEquals("Your itemizedList method is incorrect with " + sharp
					+ " lbs sharp, " + brie + " lbs brie, and " + swiss
					+ " lbs swiss.", desiredOutput);
		} catch (Exception e) {
			debug(e.toString());
			fail("Your itemizedList method crashed with " + sharp
					+ " lbs sharp, " + brie + " lbs brie, and " + swiss
					+ " lbs swiss.");
		}
	}

	
	
	
	@Test
	public void test_discount() {
		discount_help(0);
		discount_help(3923.4);
		discount_help(100.0);
		discount_help(100.1);
		discount_help(101);
		discount_help(99.9);
		discount_help(50.0);
		discount_help(50.1);
		discount_help(51);
		discount_help(49.9);
	}

	private void discount_help(double subTotal) {
		try {
			double correct = 0;
			if (subTotal >= 100)
				correct = 25;
			else if (subTotal >= 50)
				correct = 10;
			assertEquals(
					"Your discount method is incorrect with a subTotal of "
							+ subTotal, correct,
					CheeseShopv2.discount(subTotal), 0.0);
		} catch (Exception e) {
			fail("Your discount method crashed with a subTotal of " + subTotal);
		}
	}

	@Test
	public void test_printTotal() {
		pt_help(0.0, 0);
		pt_help(40.7, 0);
		pt_help(59.2, 10);
		pt_help(143.2, 25);
	}

	private void pt_help(double subTotal, int discount) {
		try {
			String[] desiredOutput = new String[3];
			desiredOutput[0] = "Sub Total: $" + subTotal;
			desiredOutput[1] = "-Discount: $" + discount;
			desiredOutput[2] = "Total    : $" + (subTotal - discount);
			testMethod = CHECK_printTotal;
			pt_subTotal = subTotal;
			pt_discount = discount;
			collectUserOutput();
			assertSOEquals(
					"Your printTotal method didn't print correctly with a subTotal of "
							+ subTotal + " and a discount of " + discount,
					desiredOutput);
		} catch (Exception e) {
			fail("Your printTotal method crashed with a subTotal of "
					+ subTotal + " and a discount of " + discount);
		}

	}
}
