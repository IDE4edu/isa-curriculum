/**
 * Fill in the two methods for the NumberCheck class below using what you know 
 * about booleans and conditionals.
 * isEven() should return true if the variable num is even, and false otherwise. 
 * isOdd() should return true if the variable num is odd, and false otherwise.
 */
public class NumberCheck{

   int myNum;

   // Constructor
   public NumberCheck(int n){
      myNum = n;
   }

   public boolean isEven() {

      if (             ) {                                            

      } else {

      }

   }

   

   public boolean isOdd() {




   }

//HIDDEN CODE START 

   //simple tests, won't catch exceptions...
   public static String[] __TEST(String studentInputs) {
      NumberCheck obj = new NumberCheck(0);
      org.uccp.apcsa.BlueJExerciseTest t = new org.uccp.apcsa.BlueJExerciseTest(studentInputs);

      for(int i=9; i>-9; i=i-3) {  // count down from 9 to -9.  Sure hope this hits zero, lol
         obj.myNum=i;
         t.claim(!((obj.isEven() != obj.__TESTeven()) && (obj.isOdd() != obj.__TESTodd())),
               "Both <tt>isEven()</tt> and <tt>isOdd()</tt> were incorrect when the number was set to <tt>" + obj.myNum +
               "</tt>.  They should have returned <tt>" + obj.__TESTeven() + "</tt> and <tt>" + obj.__TESTodd() + 
               "</tt> respectively.");
         t.claim((obj.isEven() == obj.__TESTeven()), 
               "When the number was set to <tt>" + obj.myNum +	
               "</tt>, <tt>isEven()</tt> returned the wrong answer.  It should have returned <tt>" +
               obj.__TESTeven() + "</tt>.");
         t.claim((obj.isOdd() == obj.__TESTodd()), 
               "When the number was set to <tt>" + obj.myNum +	
               "</tt>, <tt>isOdd()</tt> returned the wrong answer.  It should have returned <tt>" +
               obj.__TESTodd() + "</tt>.");	
         if (t.hasFailures()) {break;}
      }
      return t.report();   // just the first one, hey.
   }

   private boolean __TESTeven() {
      return ((myNum % 2) == 0);
   }
   private boolean __TESTodd() {
      return (!(__TESTeven()));
   }
//HIDDEN CODE END
}
/**
 * BLUEJ EXERCISE
 * TEXTBOX:A1:17:7
 * ASSERTION:A1:parenBalanced:Your parentheses aren't balanced; this won't compile!
 * ASSERTION:A1:braceBalanced:Your braces aren't balanced; this won't compile!
 * TEXTBOX:A2:29:4
 * ASSERTION:A2:parenBalanced:Your parentheses aren't balanced; this won't compile!
 * ASSERTION:A2:braceBalanced:Your braces aren't balanced; this won't compile!
 * TESTSCHEME:__TEST
 */
