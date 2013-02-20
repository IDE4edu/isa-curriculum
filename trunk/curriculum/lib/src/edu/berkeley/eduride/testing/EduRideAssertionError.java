package edu.berkeley.eduride.testing;

public class EduRideAssertionError extends AssertionError {
	public java.lang.reflect.Method method;
	public Object expected;
	public Object observed;

	public EduRideAssertionError(AssertionError ae) {
		super(ae);
	}
}