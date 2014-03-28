package tests;

import static org.junit.Assert.*;

import oop.SeasonCounter;

import org.junit.Test;

public class SeasonCounterTest {

	@Test
	public void testSeasonCounter() {
		SeasonCounter ctr = new SeasonCounter ( );
		assertEquals ("wrong initial value for counter", "spring", ctr.toString());
		ctr.reset();
		assertEquals ("wrong value for counter after reset", "spring", ctr.toString());
		ctr.increment();
		assertEquals ("wrong value after one increment", "summer", ctr.toString());
		ctr.increment();
		assertEquals ("wrong value after two increments", "fall", ctr.toString());
		ctr.increment();
		assertEquals ("wrong value after three increments", "winter", ctr.toString());
		ctr.increment();
		assertEquals ("wrong value after four increments", "spring", ctr.toString());
		ctr.increment();
		assertEquals ("wrong value after five increments", "summer", ctr.toString());
		ctr.reset();
		assertEquals ("wrong value for counter after reset", "spring", ctr.toString());
		ctr.increment();
		assertEquals ("wrong value after one increment", "summer", ctr.toString());
		ctr.increment();
		assertEquals ("wrong value after two increments", "fall", ctr.toString());
		ctr.increment();
		assertEquals ("wrong value after three increments", "winter", ctr.toString());
		ctr.increment();
		assertEquals ("wrong value after four increments", "spring", ctr.toString());
	}

}
