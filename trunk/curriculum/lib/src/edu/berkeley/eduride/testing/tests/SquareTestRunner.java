package edu.berkeley.eduride.testing.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

public class SquareTestRunner extends Runner {
	List descriptions = new ArrayList();
	private final Class<? extends EduRideJunitTestClass> testClass;
	private final EduRideJunitTestClass testContainingInstance;
	private Description testSuiteDescription;

	public SquareTestRunner(Class<? extends EduRideJunitTestClass> testClass) { 
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
				if(testContainingInstance.doStuff()) {
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

	private EduRideJunitTestClass reflectMeATestContainingInstance(Class<? extends EduRideJunitTestClass> testClass) {
		try {
			return testClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Description createTestDescription(String description) {
		return Description.createTestDescription(testClass, description);
	}

}
