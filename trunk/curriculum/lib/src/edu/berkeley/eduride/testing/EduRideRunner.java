package edu.berkeley.eduride.testing;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

import edu.berkeley.eduride.EduRideTest;

public class EduRideRunner extends Runner {
	List descriptions = new ArrayList();
	private final Class<? extends EduRideTest> testClass;
	private final EduRideTest testContainingInstance;
	private Description testSuiteDescription;

	public EduRideRunner(Class<? extends EduRideTest> testClass) { 
		this.testClass = testClass;
		System.out.println(testClass);
		testContainingInstance = reflectMeATestContainingInstance(testClass);
		testSuiteDescription = Description.createSuiteDescription("SquareTest is running");
		testSuiteDescription.addChild(createTestDescription("first bit happening"));
		testSuiteDescription.addChild(createTestDescription("second bit happening"));
		testSuiteDescription.addChild(createTestDescription("third bit happening"));
	}


	@Override
	public Description getDescription() {
		return testSuiteDescription;
	}

	@Override
	public void run(RunNotifier notifier) {
		for(Description description : testSuiteDescription.getChildren()) {
			notifier.fireTestStarted(description);
			try {
				if(doStuff()) {
					notifier.fireTestFinished(description);
				}
				else {
					notifier.fireTestIgnored(description);
				}
			} catch (Exception e) {
				notifier.fireTestFailure(new Failure(description, e));
			}
		}

	}

	private EduRideTest reflectMeATestContainingInstance(Class<? extends EduRideTest> testClass) {
		try {
			return testClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Description createTestDescription(String description) {
		return Description.createTestDescription(testClass, description);
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
