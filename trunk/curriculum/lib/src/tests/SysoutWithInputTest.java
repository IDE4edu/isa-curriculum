package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import systemout.SystemOutTest;

public class SysoutWithInputTest extends SystemOutTest {

	@Override
	public void callUserCode() {
		String[] empty = {""};
		SysoutWithInput.main(empty);
	}
	
	@Test
	public void whatever_test1() {
		String[] in = {"45"};
		collectUserOutput(in);
		assertSOContainsLine("You didn't handle 45 as input correctly",
				"Adding 1 to your number gives us 46");
		System.out.println(userOutput);
	}

	
	@Test
	public void test2() {
		List<String> in = new ArrayList<String>();
		in.add("300");
		in.add("400");
		setUserInput(in);
		collectUserOutput();
		assertSOContainsLine("You didn't handle 300 as input correctly",
				"Adding 1 to your number gives us 301");
	}
	
	@Test
	public void test3() {
		List<String> in = new ArrayList<String>();
		in.add("0");
		collectUserOutput(in);
		assertSOContainsLine("Doesn't have the first line yo", "orig = 5");
		assertSOContainsLine("yo", "Adding 1 to your number gives us 1");
	}
}
