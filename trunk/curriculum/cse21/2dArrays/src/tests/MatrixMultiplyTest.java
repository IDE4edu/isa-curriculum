package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;


import matrix.MatrixMultiply;

import org.junit.Test;

import edu.berkeley.eduride.EduRideTest;
import edu.berkeley.eduride.EduRideTest.Description;
import edu.berkeley.eduride.EduRideTest.Name;

// CONTAINS SOLUTIONS -- JAR THIS

@Description("Tests for writing and reading matrices")
public class MatrixMultiplyTest extends EduRideTest{

	
	
	@Test
	@Name("readMatrix")
	public void testReadMatrix() {
		testRead1x1();
		testRead1x2();
		testRead2x1();
		testRead2x2();
	}
	
	

	
	
	

	private static void testRead1x1() {
		int [ ] [ ]	correct = {{4}};
		int [ ] [ ] computed = MatrixMultiply.readMatrix("/lib/tests/1x1.txt");
		assertEquals ("matrix row length incorrect", correct.length, computed.length);
		assertEquals ("matrix col length incorrect", correct[0].length, computed[0].length);
		for (int r=0; r<correct.length; r++) {
			for (int c=0; c<correct[0].length; c++) {
				assertEquals ("matrix values incorrect", correct[r][c], computed[r][c]);
			}
		}
	}
	

	private void testRead2x2 ( ) {
		int [ ] [ ]	correct = {{1, 2}, {3, 4}};
		int [ ] [ ] computed = MatrixMultiply.readMatrix("/lib/tests/2x2.txt");
		assertEquals ("matrix row length incorrect", correct.length, computed.length);
		assertEquals ("matrix col length incorrect", correct[0].length, computed[0].length);
		for (int r=0; r<correct.length; r++) {
			for (int c=0; c<correct[0].length; c++) {
				assertEquals ("matrix values incorrect", correct[r][c], computed[r][c]);
			}
		}
	}
	

	private void testRead2x1 ( ) {
		int [ ] [ ]	correct = {{1}, {3}};
		int [ ] [ ] computed = MatrixMultiply.readMatrix("/lib/tests/2x1.txt");
		assertEquals ("matrix row length incorrect", correct.length, computed.length);
		assertEquals ("matrix col length incorrect", correct[0].length, computed[0].length);
		for (int r=0; r<correct.length; r++) {
			for (int c=0; c<correct[0].length; c++) {
				assertEquals ("matrix values incorrect", correct[r][c], computed[r][c]);
			}
		}
	}


	private void testRead1x2 ( ) {
		int [ ] [ ]	correct = {{1, 2}};
		int [ ] [ ] computed = MatrixMultiply.readMatrix("/lib/tests/1x2.txt");
		assertEquals ("matrix row length incorrect", correct.length, computed.length);
		assertEquals ("matrix col length incorrect", correct[0].length, computed[0].length);
		for (int r=0; r<correct.length; r++) {
			for (int c=0; c<correct[0].length; c++) {
				assertEquals ("matrix values incorrect", correct[r][c], computed[r][c]);
			}
		}
	}
	
	
	
	///////////////////////////
	
	
	
	@Test
	@Name("writeMatrix")
	public void testWriteMatrix() {
		
		
	}
	
	

}
