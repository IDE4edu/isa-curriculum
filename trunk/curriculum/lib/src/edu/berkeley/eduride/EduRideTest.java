package edu.berkeley.eduride;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines the annotations and other special features of EduRide JUnit tests
 *
 */
public class EduRideTest {
	
	
	
	///////////////////////////
	// Annotations


	
	/**
	 * Annotation for a @Test method to indicate that it should <b>not</b> be included
	 * in result list when successful.  Typically used for tests that check whether the 
	 * student has 'cheated' or otherwise not followed directions.
	 *
	 */
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface  hideWhenSuccessful {
	}
	
	
	/**
	 * Indicates the <b>name</b> of the @Test to be shown in the result list.  Interchangeable
	 * with @MethodCall(String).  If this is missing, the Java method name will be used.
	 *
	 * @Param name the name to show
	 */
	@Retention(RetentionPolicy.RUNTIME)
	public @interface  Name {
		public String value();
	}
	
	
	/**
	 * Indicates the <b>name</b> of the @Test to be shown in the result list.  Interchangeable
	 * with @Name(String).  If this is missing, the Java method name will be used.
	 *
	 * @Param name the name to show
	 */
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface  MethodCall {
		public String value();
	}

	
	/**
	 * Indicates the value for the <b>expected</b> field in the result list.  Use of this
	 * annotation will take precedence over any expected value that is generated at runtime by
	 * failures of comparison asserts, such as <i>AssertEquals</i>.  
	 *
	 * @Param expected
	 */
	@Target({ElementType.METHOD})
	@Retention(RetentionPolicy.RUNTIME)
	public @interface  Expected {
		public String value();
	}
	

	/**
	 * Indicates the value for the <b>Description</b> field in the result list (usually,
	 * this is shown in a tooltip when hovering over the name). If not present, a test result
	 * will contain the message <b>name</b>.   
	 *
	 * @Param description 
	 */
	@Retention(RetentionPolicy.RUNTIME)
	public @interface  Description {
		public String value();
	}
	
	/**
	 * Indicates the <b>message</b> to give if the test is successful.  Will not show up
	 * if the test is unsuccessful.  If not present, a successful test will contain
	 * no <b>message</b> field.
	 *
	 * @Param message
	 */
	@Retention(RetentionPolicy.RUNTIME)
	public @interface SuccessMessage {
		public String value();
	}
	
	

}
