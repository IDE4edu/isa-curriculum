import junit.framework.TestCase;
import java.util.Arrays;

public class InsertionSortISATest extends TestCase {
	
	// Test sorting a one-element array.
	public void testOneElemSelectionSort ( ) {
		int [ ] [ ] oneElemTests = {{1}};
		int [ ] oneElemSoln = {1};
		for (int k=0; k<oneElemTests.length; k++) {
			assertTrue ("fails for one-element array", Arrays.equals (InsertionSortISA.insertionSort (oneElemTests[k]), oneElemSoln));
		}
	}
	
	// Test sorting both two-element arrays.
	public void testTwoElemSelectionSort ( ) {
		int [ ] [ ] twoElemTests = {{1,2}, {2,1}};
		int [ ]	twoElemSoln = {1,2};
		for (int k=0; k<twoElemTests.length; k++) {
			assertTrue ("fails for two-element array", Arrays.equals (InsertionSortISA.insertionSort (twoElemTests[k]), twoElemSoln));
		}
	}
	
	// Test five-element arrays that alternate high/low in several places.
	public void testFiveElemSelectionSort ( ) {
		int [ ] [ ] fiveElemTests = {{5,4,3,2,1}, {1,2,3,4,5},
			{5,3,1,2,4}, {4,2,1,3,5}, {1,3,5,4,2}, {2,4,5,3,1}, {4,1,2,5,3}, {3,5,2,1,4}};
		int [ ] fiveElemSoln = {1,2,3,4,5};
		for (int k=0; k<fiveElemTests.length; k++) {
			assertTrue ("fails for " + toString(fiveElemTests[k]), Arrays.equals (InsertionSortISA.insertionSort (fiveElemTests[k]), fiveElemSoln));
		}
	}
	
	public void testAllTheSame ( ) {
		int [ ] allTheSame = {2,2,2};
		int [ ] allTheSameSoln = {2,2,2};
		assertTrue ("fails for elements all the same", Arrays.equals (InsertionSortISA.insertionSort (allTheSame), allTheSameSoln));
	}
	
	// Test for isOK while sorting one element.
	public void testIsOK1elem ( ) {
		int [ ] oneElem = {1};
		assertTrue (!InsertionSortISA.isOK (oneElem, -1));
		assertTrue (InsertionSortISA.isOK (oneElem, 0));
		assertTrue (!InsertionSortISA.isOK (oneElem, 1));
	}
	
	// Test for isOK while sorting two elements.
	public void testIsOK2elems ( ) {
		int [ ] array1 = {1,2};
		assertTrue (!InsertionSortISA.isOK (array1, -1));
		assertTrue (InsertionSortISA.isOK (array1, 0));
		assertTrue (InsertionSortISA.isOK (array1, 1));
		assertTrue (!InsertionSortISA.isOK (array1, 2));
		int [ ] array2 = {2,1};
		assertTrue (!InsertionSortISA.isOK (array2, -1));
		assertTrue (InsertionSortISA.isOK (array2, 0));
		assertTrue (!InsertionSortISA.isOK (array2, 1));
		assertTrue (!InsertionSortISA.isOK (array2, 2));
	}
	
	// Test for isOK while sorting five elements.
	public void testIsOK5elems ( ) {
		int [ ] array1 = {1,2,3,4,5};
		assertTrue (InsertionSortISA.isOK (array1, 0));
		assertTrue (InsertionSortISA.isOK (array1, 2));
		assertTrue (InsertionSortISA.isOK (array1, 4));
		assertTrue (!InsertionSortISA.isOK (array1, 5));
		int [ ] array2 = {1,2,3,5,4};
		assertTrue (InsertionSortISA.isOK (array2, 2));
		assertTrue (InsertionSortISA.isOK (array2, 3));
		assertTrue (!InsertionSortISA.isOK (array2, 4));
		assertTrue (!InsertionSortISA.isOK (array2, 5));
		int [ ] array3 = {5,4,3,2,1};
		assertTrue (InsertionSortISA.isOK (array3, 0));
		assertTrue (!InsertionSortISA.isOK (array3, 1));
		assertTrue (!InsertionSortISA.isOK (array3, 5));
	}
	
	// Return a printable form of the given array.
	private static String toString (int [ ] values) {
		String rtn = "{ ";
		for (int k=0; k<values.length; k++) {
			rtn = rtn + values[k] + " ";
		}
		return rtn + "}";
	}
}
