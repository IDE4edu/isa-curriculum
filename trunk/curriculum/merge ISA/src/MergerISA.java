
public class MergerISA {

	// Combine arrays a and b, sorted in increasing order, 
	// into an new array rtn that's also sorted in increasing order.
	public static int [ ] merged (int [ ] a, int [ ] b) {
		int [ ] rtn = new int[a.length+b.length];
		// aIndex and bIndex keep track of values in a and b already added to rtn.
		// Invariant: aIndex + bIndex == rIndex, that is, aIndex values from a
		// and bIndex values from b have been added to rtn.
		int aIndex = 0;											// #1
		int bIndex = 0;											// #2
		int rIndex = 0;											// #3
		while (aIndex < a.length && bIndex < b.length) {		// #4
			if (a[aIndex] < b[bIndex]) {						// #5
				// The next element in a is to be added to rtn.
				rtn[rIndex] = a[aIndex];						// #6
				aIndex++;										// #7
				rIndex++;										// #8
			} else {
				// The next element in b is to be added to rtn.
				rtn[rIndex] = a[bIndex];						// #9
				bIndex++;										// #10
				rIndex++;										// #11
			}
			if (!isOK (a, b, rtn, aIndex, bIndex, rIndex)) {
				System.out.println ("inconsistency 1: aIndex = " + aIndex
					+ "; bIndex = " + bIndex + "; rIndex = " + rIndex);
				System.out.println ("a = " + toString(a) + "; b = "
						+ toString(b) + "; rtn = " + toString (rtn));
			}
		}
		// One of arrays a and b has run out of values.
		// Add the remaining values to rtn.
		while (aIndex < a.length) {								// #12
			rtn[rIndex] = a[aIndex];							// #13
			aIndex++;											// #14
			rIndex++;											// #15
			if (!isOK (a, b, rtn, aIndex, bIndex, rIndex)) {
				System.out.println ("inconsistency 2: aIndex = " + aIndex
					+ "; bIndex = " + bIndex + "; rIndex = " + rIndex);
				System.out.println ("a = " + toString(a) + "; b = "
						+ toString(b) + "; rtn = " + toString (rtn));
			}
		}
		while (bIndex < b.length) {								// #16
			rtn[rIndex] = b[bIndex];							// #17
			bIndex++;											// #18
			rIndex++;											// #19
			if (!isOK (a, b, rtn, aIndex, bIndex, rIndex)) {
				System.out.println ("inconsistency 3: aIndex = " + aIndex
					+ "; bIndex = " + bIndex + "; rIndex = " + rIndex);
				System.out.println ("a = " + toString(a) + "; b = "
						+ toString(b) + "; rtn = " + toString (rtn));
			}
		}
		return rtn;
	}
	
	// Check the arrays and index variables for internal consistency.
	public static boolean isOK (int [ ] a, int [ ] b, int [ ] r, int aIndex, int bIndex, int rIndex) {
		if (aIndex<0 || bIndex<0 || rIndex<0) {
			return false;
		}
		if (aIndex>a.length || bIndex>b.length || rIndex>r.length) {
			return false;
		}
		if (rIndex != aIndex + bIndex) {
			return false;
		}
		for (int k=0; k<rIndex-1; k++) {
			if (r[k] > r[k+1]) {
				return false;
			}
		}
		for (int k=0; k<rIndex; k++) {
			if (!contains (a, r[k]) && !contains (b, r[k])) {
				return false;
			}
		}
		for (int k=0; k<aIndex; k++) {
			if (!contains (r, a[k])) {
				return false;
			}
		}
		for (int k=0; k<bIndex; k++) {
			if (!contains (r, b[k])) {
				return false;
			}
		}
		return true;
	}

	// Return a printable form of the given array.
	private static String toString (int [ ] values) {
		String rtn = "{ ";
		for (int k=0; k<values.length; k++) {
			rtn = rtn + values[k] + " ";
		}
		return rtn + "}";
	}
	
	// Return true if the given array contains the given value.
	private static boolean contains (int [ ] values, int x) {
		for (int k=0; k<values.length; k++) {
			if (values[k] == x) {
				return true;
			}
		}
		return false;
	}
}
