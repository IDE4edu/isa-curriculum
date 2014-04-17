package io;

import java.util.*;
import java.io.*;

public class MatrixMultiply {

	
	public static int[][] readMatrix() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the First file name: ");
		String filename = input.next();
		
		return (readMatrix(filename));
	}
	
	
	public static int[][] readMatrix(String filename) {
		int [][] mat = null;
		
		// Fill-in

		return mat;
	}

	
	// returns the multiplied matrix
	public static int[][] multiply(int[][] m1, int[][] m2) {

		int m1rows = m1.length;
		int m1cols = m1[0].length;
		int m2rows = m2.length;
		int m2cols = m2[0].length;
		int[][] result = new int[m1rows][m2cols];
		for (int i = 0; i < m1rows; i++) {
			for (int j = 0; j < m2cols; j++) {
				for (int k = 0; k < m1cols; k++) {
					result[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return result;
	}

	
	// writes a matrix to the file
	public static void writeMatrix(int[][] matrix, String filename) {

		// Fill-in
		
	}
	
	
	public static void printMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				// 'format' will print 5 spaces no matter what, which will 
				// help line things up.
				System.out.format("%05d", matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	
	public static String defaultOutputFile = "data/matrixOutput.txt";
	
	public static void multiplyInteractive() {
		int[][] m1 = readMatrix();
		System.out.println("Matrix 1: ");
		printMatrix(m1);
		int[][] m2 = readMatrix();
		System.out.println("Matrix 2: ");
		printMatrix(m2);
		int[][] mult = multiply(m1, m2);
		System.out.println("Multipled matrix: ");
		printMatrix(mult);
		writeMatrix(mult, defaultOutputFile);
		
	}
	

}
