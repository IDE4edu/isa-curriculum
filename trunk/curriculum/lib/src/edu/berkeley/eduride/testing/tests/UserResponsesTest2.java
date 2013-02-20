package edu.berkeley.eduride.testing.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import systemout.SystemOutTest;

public class UserResponsesTest2 extends SystemOutTest {

	String [ ] correct = {"orig = 5", "new = 6"};

	

	@Override
	public void callUserCode() {
		String[] empty = {""};
		UserCode.main(empty);
	}
	
	@Before
	public void doit() {
		// we don't need to set up different input
		collectUserOutput();
	}
	

	
	@Test
	public void test() {
		System.out.println(userOutput);
		assertSOEquals("You don't have the right output", correct);
	}

}
