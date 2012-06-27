 /* There is a problem with this solution to reverse, intended to reverse an array.
  * Fix it!
  */

public class Reverse {

   public void reverse (int[] array){

       int temp;
       
       for (int i=0; i < array.length; i++) {
           temp = array[i];
           array[i] = array[array.length - i];
           array[array.length - i] = temp;
       }
   
   
   }
   
   
//HIDDEN CODE START

   // Put the name of the enclosing class here
   public static final String THIS_CLASS = "Reverse";
   
   // the main testing function
   public String[] __start() {
	   // odd length
	   int[] orig1 = {1, 2, 3};
       int[] array1 = {1, 2, 3};
       int[] result1 = {3, 2, 1};
       __reverse(array1);  // calls a wrapped version of the student method - see below
       __arraycompare (orig1, array1, result1);
       // even length...
       int[] orig2 = {1, 2, 3, 4, 5, 6};
       int[] array2 = {1, 2, 3, 4, 5, 6};
       int[] result2 = {6, 5, 4, 3, 2, 1};
       __reverse(array2);
       __arraycompare (orig2, array2, result2);
       // Check boundary case.
       int[] array3 = {};
       __reverse(array3);
       __t.claim(array3.length == 0, "Something strange happened when reversing empty arrays...");

       return(__t.report());   // reports first fail...
   }
   

   // wrap the function(s) the student writes, to catch exceptions, if you want
   //  its a bit tricky if this has to return something after an exception is called
   private void __reverse(int[] array) {
	   try {
		   this.reverse(array);
	   } catch (Exception e) {
		   String[] temp = __t.reportException(e, "Your reverse method compiled, but then broke when invoked with <tt>" + __print(array) + "</tt>.");
		   __t.claim(false, temp[1]);
	   }
   }

   // a utility method, to make the main testing function easier
   private void __arraycompare(int[] orig, int[] rev, int[] comp) {
       __t.claim((rev.length == comp.length), "A returned array isn't the right length.  When invoked with "
    		   + __print(orig) + ", your code returned " + __print(rev) + "."); 

       __t.claim(java.util.Arrays.equals(rev, comp), "Your reversed array has the wrong values.  When invoked with "
    		   + __print(orig) + ", your code returned " + __print(rev) + ".");
   }
   
   // another little utility method
	private String __print(int[] arr) {
		return "<tt>" + java.util.Arrays.toString(arr) + "</tt>";
	}
	
	/* The solution.  Its nice to include here for testing...
	       for (int i=0; i < array.length/2; i++) {
	           temp = array[i];
	           array[i] = array[array.length - (i + 1)];
	           array[array.length - (i + 1)] = temp;
	       }                                                          
	 */

	
	// Don't edit this stuff
	public org.uccp.apcsa.BlueJExerciseTest __t;
	public static String[] __TEST(String studentInputs) {
		try {  // this is ridiculous, Nate
			Class<?> theClass = Class.forName(THIS_CLASS);
			Object obj = theClass.newInstance();
			java.lang.Class<?>[] startArgs = null;
			java.lang.reflect.Method startMethod = theClass.getMethod("__start", startArgs);
			java.lang.reflect.Field tField = theClass.getField("__t");
			tField.set(obj, new org.uccp.apcsa.BlueJExerciseTest(studentInputs));
			return (String[]) (startMethod.invoke(obj));
		} catch (Exception e) {
			org.uccp.apcsa.BlueJExerciseTest t = new org.uccp.apcsa.BlueJExerciseTest();
			return t.reportException(e, "Uh oh.  There must be a problem in your constructor, because your class couldn't instantiate an object.");
		}
	} // Don't edit above here.

	
//HIDDEN CODE END
}
/**
 * BLUEJ EXERCISE
 * TEXTBOX:A1:8:10
 * ASSERTION:A1:parenBalanced:Your parentheses are not balanced; this won't compile.
 * TESTSCHEME:__TEST
 */
