import java.io.*;
import java.util.ArrayList;

public class BinarySearchISA {
	
	private static ArrayList<Integer> previousGuesses = new ArrayList<Integer> ( );

    public static void main (String [ ] args) throws Exception {
        BufferedReader keyboard = new BufferedReader (new InputStreamReader (System.in));
        String answer;
        System.out.println ("Please think of an integer between 0 and 20 (inclusive).");
        int low, high, guess;
        low = 0;
        high = 20;
        guess = (low+high)/2;
        System.out.println ("Is your number " + guess + "? (Type y or n.)");
        answer = keyboard.readLine ( );
        while (!answer.equals ("y")) {
            System.out.println ("Is " + guess + " too high? (Type y or n.)");
            answer = keyboard.readLine ( );
            if (answer.equals ("y")) {
                high = guess;
            } else {
                low = guess;
            }
            previousGuesses.add (guess);
            guess = (low+high)/2;
            if (!BinarySearchISA.isOK (guess, low, high, previousGuesses)) {
            	System.out.println ("problem with guesses: "
            			+ "guess = " + guess + ", low = " + low + ", high = " + high);
            }
            System.out.println ("Is your number " + guess + "? (Type y or n.)");
            answer = keyboard.readLine ( );
        }
    }
    
    public static boolean isOK (int guess, int low, int high, ArrayList<Integer> previousGuesses) {
    	if (high > 20 || low <= 0 || high < low) {
    		return false;
    	}
    	if (previousGuesses.contains (guess)) {
    		return false;
    	}
    	return true;
    }
}
