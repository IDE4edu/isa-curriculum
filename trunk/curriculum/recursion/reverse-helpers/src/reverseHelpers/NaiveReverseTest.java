package reverseHelpers;
import static org.junit.Assert.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.Test;


public class NaiveReverseTest {

	
	private String real_reverse(String s) {
		return new StringBuffer(s).reverse().toString();
	}	

	
	


	// we'd like to ensure they don't have any loops, and no use of Java library reverse...
	// But how!?!
	
	

	@Test
	@Name("Test on 'abcdef'")
	public void reverse_abcdef() {
		String tst = "abcdef";
		
		NaiveReverse nr = new NaiveReverse();
		String obs = nr.reverse6(tst);
		String exp = real_reverse(tst);
		assertEquals("reverse6(\""+tst+"\")", exp, obs);
	}
	
	@Test
	@Name("Test on 'abcdef'")
	@Description("This test runs your <tt>reverse6</tt> on a string that looks at what it returns.  If it is failing...")
	public void reverse_lolwtf() {
		String tst = "lolwtf";
		
		NaiveReverse nr = new NaiveReverse();
		String obs = nr.reverse6(tst);
		String exp = real_reverse(tst);
		assertEquals("reverse6(\""+tst+"\")", exp, obs);
	}
	
	
	@Test
	public void reverse_hidden1() {
		String tst = "yefcZu";
		NaiveReverse nr = new NaiveReverse();
		String obs = nr.reverse6(tst);
		String exp = real_reverse(tst);
		assertTrue("reverse6 on a mystery String" ,
			 	obs.equals(exp));
	}
	

	
	
	
	

	// Anotations
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Name {
		public String value();
	}

	@Target({ ElementType.METHOD, ElementType.LOCAL_VARIABLE })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Expected {
		public String value() default "<>";
	}

	@Retention(RetentionPolicy.RUNTIME)
	public @interface Description {
		public String value();
	}
	

	
}
