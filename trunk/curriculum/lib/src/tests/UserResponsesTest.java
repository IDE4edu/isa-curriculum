package tests;
import java.io.*;

public class UserResponsesTest {
	
	private static PrintStream userOutput;
	private static BufferedReader reread;
	private static String [ ] args = {""};

	public static void main (String [ ] origArgs) throws Exception {
		userOutput = new PrintStream (new File ("userOutput.txt"));
		System.setOut (userOutput);
		UserCode.main (args);
		userOutput.close ( );
		reread = new BufferedReader (new FileReader ("userOutput.txt"));
		String [ ] correctResults = {"orig = 5", "new = 6"};
		StringBuffer rereadChars = new StringBuffer ( );
		String sFromUser;
		int lineNum = 0;
		while ((sFromUser = reread.readLine ( )) != null) {
			if (lineNum >= correctResults.length) {
				System.err.println ("Mismatch: more input from user than expected");
				System.exit (1);
			}
			if (!correctResults[lineNum].equals (sFromUser)) {
				System.err.println ("Mismatch: expected = \"" + correctResults[lineNum] + "\", actual = \"" + sFromUser + "\"");
				System.exit (1);
			}
			lineNum++;
		}
		if (lineNum != correctResults.length) {
			System.err.println ("Mismatch: less input from user than expected");
			System.exit (1);
		}
		System.err.println ("Success!");
		reread.close ( );
	}

}
