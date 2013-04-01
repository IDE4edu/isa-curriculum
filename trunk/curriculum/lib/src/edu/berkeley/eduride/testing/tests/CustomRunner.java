package edu.berkeley.eduride.testing.tests;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class CustomRunner extends BlockJUnit4ClassRunner{

	int counter = 0;

	public CustomRunner(Class<?> klass) throws InitializationError {
		super(klass);

		// TODO Goal: Get squareTest to run and add another test case that 
		// has the @Ignored annotation

	}
	//
	//	public TheRunner(Class<? extends MyTargetTestClass> testClass) { 
	//		this.testClass = testClass;
	//		testContainingInstance = reflectMeATestContainingInstance(testClass);
	//		testSuiteDescription = Description.createSuiteDescription("All my stuff is happening now dudes");
	//		testSuiteDescription.addChild(createTestDescription("first bit happening"));
	//		testSuiteDescription.addChild(createTestDescription("second bit happening"));
	//		testSuiteDescription.addChild(createTestDescription("third bit happening"));
	//	}

	@Deprecated
	protected void validateInstanceMethods(List<Throwable> errors) {
		validatePublicVoidNoArgMethods(After.class, false, errors);
		validatePublicVoidNoArgMethods(Before.class, false, errors);
		validateTestMethods(errors);

		if (super.computeTestMethods().size() == 0)
			errors.add(new Exception("No runnable methods"));
	}

	@Ignore
	public void myFakeTest(){
	}

	@Override
	public List<FrameworkMethod> computeTestMethods(){
		List<FrameworkMethod> frameworkMethods = super.computeTestMethods();
		Method fakeMethod = null;
		try {
			fakeMethod = CustomRunner.class.getMethod("myFakeTest", null);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!frameworkMethods.contains(fakeMethod)){
			frameworkMethods.add(new FrameworkMethod(fakeMethod));
		}
		return frameworkMethods;
	}

}
