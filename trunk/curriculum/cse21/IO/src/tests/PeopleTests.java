package tests;

import static org.junit.Assert.*;
import edu.berkeley.eduride.EduRideTest;
import edu.berkeley.eduride.EduRideTest.Description;

@Description("Test for the People class")

public class PeopleTests extends EduRideTest {

	@Test
	public void test ( ) {
		ArrayList<Person> correct = new ArrayList<Person> ( );
		correct.add (new Person ("Obama", 52, "Washington, DC"));
		correct.add (new Person ("Washington", 67, "New York City, NY"));
		People group = new People (	);
		ArrayList<Person> computed = group.readFile ("presidents");
		assertEquals ("length mismatch", correct.size(0), computed.size(0));
		assertEquals ("first person mismatch", correct.get(0), computed.get(0));
		assertEquals ("second person mismatch", correct.get(1), computed.get(1));
	}
}
