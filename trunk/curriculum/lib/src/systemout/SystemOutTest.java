package systemout;


import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.*;


public class SystemOutTest {

	
	// Extend this class in your test class
	//
	// For each test/set-of-tests for a particular run of user code
	//  1- run the user's code that prints to System.out
	//  2- call collectUserOutput();
	//  3- call the relevant assertSO... methods
 
	
	
	// will hold the lines from the last set of user output
	public static List<String> userOutput = new ArrayList<String>();

	
	
	////// SysOut asserts

	public static void assertSOContainsLine(String message, String line) {
		assertTrue(message, userOutput.contains(line));
	}
	
	public static void assertSOHasLine(String message, int index, String line) {
		assertTrue(message, userOutput.get(index).equals(line));
	}
	
	
	public static void assertSOContainsLines(String message, String[] lines) {
		fail("unimplemented");
	}
	
	public static void assertSOContainsLines (String message, List<String> lines) {
		fail("unimplemented");
	}
	
	public static void assertSOEquals (String message, String[] lines) {
		assertArrayEquals(message, userOutput.toArray(), lines); 
	}
	
	public static void assertSOEquals (String message, List<String> lines) {
		assertArrayEquals(message, userOutput.toArray(), lines.toArray());
	}
	
	public static void assertSONumLines(String message, int numLines) {
		assertTrue(message, userOutput.size() == numLines);
	}
	
	// pattern match stuff would be nice

	
	
	/////////////
	
	// call this after running the user's code
	public static void collectUserOutput() {
		// user code just got run, hopefully

		userOutput.clear();
		while (userOutputScanner.hasNextLine()) {
			userOutput.add(userOutputScanner.nextLine());
		}

		preUserRunSetUp();
	}
	
	public static String filenamePrefix = "tmpSysoutTest";
	static Scanner userOutputScanner;

	private static void preUserRunSetUp() {
		File userOutputTempFile;
		try {
			userOutputTempFile = File.createTempFile(filenamePrefix, null);
			PrintStream userOutputTempStream = new PrintStream (userOutputTempFile);
			System.setOut (userOutputTempStream);
			userOutputScanner = new Scanner(userOutputTempFile);
			oldPrintStreams.add(userOutputTempStream);
			oldFiles.add(userOutputTempFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@BeforeClass
	public static void initialSetup() {
		preUserRunSetUp();
	}
	
	static List<PrintStream> oldPrintStreams = new ArrayList<PrintStream>();
	static List<File> oldFiles = new ArrayList<File>();
	
	@AfterClass
	public static void tearDown() {
		for (PrintStream ps : oldPrintStreams) {
			ps.close();
		}
		for (File f : oldFiles) {
			f.delete();
		}
	}
}
