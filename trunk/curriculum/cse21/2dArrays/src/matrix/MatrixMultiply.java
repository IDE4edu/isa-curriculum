package matrix;

import java.util.*;
import java.io.*;

public class MatrixMultiply {

	
	public static int[][] readMatrix() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the file name: ");
		String filename = input.next();
		
		return readMatrix(filename);
		
	}
	
	
	
	
	

	public static int[][] readMatrix(String filename) {
		
		// Fill-in
		
		int [][] mat = null;
		try {
			Scanner file = new Scanner ( new FileReader(filename) );
			int row = file.nextInt();
			int column = file.nextInt();
			mat = new int[row][column];
			for (int i = 0; i < row; i++)
				for (int j = 0; j < column; j++)
					mat[i][j] = file.nextInt();
			file.close();
		} catch (NoSuchElementException e) {
			System.err.println(e);
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
		return mat;
	} 


	
	
	// writes a matrix to the file
	public static void writeMatrix(int[][] matrix, String filename) {

		// Fill-in
		
		try {
			FileWriter fw = new FileWriter(filename);
			BufferedWriter bw = new BufferedWriter(fw);
			String header = "" + matrix.length + " " + matrix[0].length;
			bw.write(header);
			bw.newLine();
			for (int r=0; r<matrix.length; r++) {
				String line = "";
				for (int c=0; c<matrix[0].length; c++) {
					line += matrix[r][c] + " ";
				}
				bw.write(line); 
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
		
		
		
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


	
	
	// prints a matrix
	public static void printMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				// 'format' will print 5 spaces no matter what, which will 
				// help line things up.
				System.out.format("%5d ", matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	

	

}
