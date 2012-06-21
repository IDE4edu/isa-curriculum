import junit.framework.TestCase;
import java.util.Arrays;

public class InsertionSortIsOKTest extends TestCase {
	
	// Test for isOK while sorting one element.
	public void testIsOK1elem ( ) {
		int [ ] oneElem = {1};
		assertTrue (!InsertionSort.isOK (oneElem, -1));
		assertTrue (InsertionSort.isOK (oneElem, 0));
		assertTrue (!InsertionSort.isOK (oneElem, 1));
	}
	
	// Test for isOK while sorting two elements.
	public void testIsOK2elems ( ) {
		int [ ] array1 = {1,2};
		assertTrue (!InsertionSort.isOK (array1, -1));
		assertTrue (InsertionSort.isOK (array1, 0));
		assertTrue (InsertionSort.isOK (array1, 1));
		assertTrue (!InsertionSort.isOK (array1, 2));
		int [ ] array2 = {2,1};
		assertTrue (!InsertionSort.isOK (array2, -1));
		assertTrue (InsertionSort.isOK (array2, 0));
		assertTrue (!InsertionSort.isOK (array2, 1));
		assertTrue (!InsertionSort.isOK (array2, 2));
	}
	
	// Test for isOK while sorting five elements.
	public void testIsOK5elems ( ) {
		int [ ] array1 = {1,2,3,4,5};
		assertTrue (InsertionSort.isOK (array1, 0));
		assertTrue (InsertionSort.isOK (array1, 2));
		assertTrue (InsertionSort.isOK (array1, 4));
		assertTrue (!InsertionSort.isOK (array1, 5));
		int [ ] array2 = {1,2,3,5,4};
		assertTrue (InsertionSort.isOK (array2, 2));
		assertTrue (InsertionSort.isOK (array2, 3));
		assertTrue (!InsertionSort.isOK (array2, 4));
		assertTrue (!InsertionSort.isOK (array2, 5));
		int [ ] array3 = {5,4,3,2,1};
		assertTrue (InsertionSort.isOK (array3, 0));
		assertTrue (!InsertionSort.isOK (array3, 1));
		assertTrue (!InsertionSort.isOK (array3, 5));
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
