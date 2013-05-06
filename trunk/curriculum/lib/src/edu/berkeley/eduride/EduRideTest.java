package edu.berkeley.eduride;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class EduRideTest {
	
	// Annotations
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface  hideWhenSuccessful {
	}
	
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface  MethodCall {
		public String value();
	}

	@Target({ElementType.METHOD})
	@Retention(RetentionPolicy.RUNTIME)
	public @interface  Expected {
		public String value();
	}
	
	// Java throws away local variable annotations, ug.  not used
	@Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE})
	@Retention(RetentionPolicy.RUNTIME)
	public @interface  Observed {
		public String value() default "<>";
	}
	
	
	@Retention(RetentionPolicy.RUNTIME)
	public @interface  Description {
		public String value();
	}
	
	static int count = 0;
	public boolean doStuff() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}

		count ++;

		if(count % 2 == 0) { throw new RuntimeException("A Failure"); }

		return !(count % 3 == 0);
	}
}
