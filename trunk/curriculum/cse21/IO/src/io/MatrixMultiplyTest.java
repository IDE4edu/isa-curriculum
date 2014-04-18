package io;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixMultiplyTest {

	@Test
	public void test1x1() {
		int [ ] [ ]	correct = {{4}};
		int [ ] [ ] computed = MatrixMultiply.readMatrix("/documents/github/isa-curriculum/trunk/curriculum/cse21/IO/src/io/1x1.txt");
		assertEquals (correct.length, computed.length);
		assertEquals (correct[0].length, computed[0].length);
		for (int r=0; r<correct.length; r++) {
			for (int c=0; c<correct[0].length; c++) {
				assertEquals (correct[r][c], computed[r][c]);
			}
		}
	}
	
	@Test
	public void test2x2 ( ) {
		int [ ] [ ]	correct = {{1, 2}, {3, 4}};
		int [ ] [ ] computed = MatrixMultiply.readMatrix("/documents/github/isa-curriculum/trunk/curriculum/cse21/IO/src/io/2x2.txt");
		assertEquals (correct.length, computed.length);
		assertEquals (correct[0].length, computed[0].length);
		for (int r=0; r<correct.length; r++) {
			for (int c=0; c<correct[0].length; c++) {
				assertEquals (correct[r][c], computed[r][c]);
			}
		}
	}
	
	@Test
	public void test2x1 ( ) {
		int [ ] [ ]	correct = {{1}, {3}};
		int [ ] [ ] computed = MatrixMultiply.readMatrix("/documents/github/isa-curriculum/trunk/curriculum/cse21/IO/src/io/2x1.txt");
		assertEquals (correct.length, computed.length);
		assertEquals (correct[0].length, computed[0].length);
		for (int r=0; r<correct.length; r++) {
			for (int c=0; c<correct[0].length; c++) {
				assertEquals (correct[r][c], computed[r][c]);
			}
		}
	}

	@Test
	public void test1x2 ( ) {
		int [ ] [ ]	correct = {{1, 2}};
		int [ ] [ ] computed = MatrixMultiply.readMatrix("/documents/github/isa-curriculum/trunk/curriculum/cse21/IO/src/io/1x2.txt");
		assertEquals (correct.length, computed.length);
		assertEquals (correct[0].length, computed[0].length);
		for (int r=0; r<correct.length; r++) {
			for (int c=0; c<correct[0].length; c++) {
				assertEquals (correct[r][c], computed[r][c]);
			}
		}
	}
}
