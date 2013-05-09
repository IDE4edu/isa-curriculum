package edu.berkeley.eduride.testing.tests;

import java.lang.reflect.Method;
import java.util.List;

import junit.framework.AssertionFailedError;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

public class CustomRunner extends BlockJUnit4ClassRunner {

	int counter = 0;

	public CustomRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}




	@Override
	public List<FrameworkMethod> computeTestMethods() {
		List<FrameworkMethod> fms = super.computeTestMethods();
		Method ignoredTestMethod = null;
		try {
			ignoredTestMethod = CustomRunner.class.getMethod("ignoredMethod", null);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean seenIt = false;
		for (FrameworkMethod fm : fms) {
			if (fm.getClass().equals(RunEvenIfIgnored.class)) {
				seenIt = true;
			}
		}
		if (!seenIt) {
			fms.add(new RunEvenIfIgnored(ignoredTestMethod));
		}
		return fms;
	}



	protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
		Description description = describeChild(method);
		if (method.getClass().equals(RunEvenIfIgnored.class)) {
			EachTestNotifier eachNotifier = new EachTestNotifier(notifier, description);
			//eachNotifier.addFailedAssumption(new AssumptionViolatedException("CAN YOU SEE ME ASSUMPTION?"));
	        //eachNotifier.addFailure(new AssertionFailedError("CAN YOU SEE ME?"));
			eachNotifier.addFailure(new EduRideCommunication("CAN YOU SEE ME EDURIDE?"));
	        notifier.fireTestIgnored(description);
		}
		else {
			super.runChild(method, notifier);
		}
	}

	
	public class EduRideCommunication extends Throwable {
		private static final long serialVersionUID = 3726556059859848779L;

		public EduRideCommunication(String msg) {
			super(msg);
		}
	}
	
	
	public class RunEvenIfIgnored extends FrameworkMethod {

		public RunEvenIfIgnored(Method m) {
			super(m);
		}
		
		@Override
		public String getName() {
			return "Please Ignore This J@#K#@J@J@K#J%JJFDJsdkkejwo87fkshDw28eswh@#fjwofhwehowioi92039u5u029efowijf029je0f9j09jd09gfuw0d9fu0s9dfu0s9djf0sw9jf09sudf0wohjtru3g98yu43989few8rfijdsfijs09d8fjw08ej98rfj298fj8je8wjf08wjef08udsoigtjlkjfwo9vrewf98wu0t8u2e8";
		}
	}

	@Ignore
	public void ignoredMethod() {
	}


//	public class IgnoredDescription extends Description {
//		
//	}
//	
}
