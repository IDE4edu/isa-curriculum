
public class MergerISA {
	
	private static String toString (int [ ] a) {
		String rtn = "";
		for (int k=0; k<a.length; k++) {
			rtn = rtn + a[k] + " ";
		}
		return rtn;
	}

	// Combine arrays a and b, sorted in increasing order, 
	// into an new array rtn that's also sorted in increasing order.
	public static int [ ] merged (int [ ] a, int [ ] b) {
		int [ ] rtn = new int[a.length+b.length];
		// aIndex and bIndex keep track of values in a and b already added to rtn.
		// Invariant: aIndex + bIndex == rIndex, that is, aIndex values from a
		// and bIndex values from b have been added to rtn.
		int aIndex = 0;
		int bIndex = 0;
		int rIndex = 0;
		while (aIndex < a.length && bIndex < b.length) {
			if (a[aIndex] < b[bIndex]) {
				// The next element in a is to be added to rtn.
				rtn[rIndex] = a[aIndex];
				aIndex++;
				rIndex++;
			} else {
				// The next element in b is to be added to rtn.
				rtn[rIndex] = b[aIndex];
				bIndex++;
				rIndex++;
			}
			if (!isOK (a, b, rtn, aIndex, bIndex, rIndex)) {
				System.out.println ("inconsistency 1: aIndex = " + aIndex
					+ "; bIndex = " + bIndex + "; rIndex = " + rIndex);
				System.out.println ("rtn = " + toString (rtn));
			}
		}
		// One of arrays a and b has run out of values.
		// Add the remaining values to rtn.
		while (aIndex < a.length) {
			rtn[rIndex] = a[aIndex];
			aIndex++;
			rIndex++;
			if (!isOK (a, b, rtn, aIndex, bIndex, rIndex)) {
				System.out.println ("inconsistency 2: aIndex = " + aIndex
					+ "; bIndex = " + bIndex + "; rIndex = " + rIndex);
				System.out.println ("rtn = " + toString (rtn));
			}
		}
		while (bIndex < b.length) {
			rtn[rIndex] = b[bIndex];
			bIndex++;
			rIndex++;
			if (!isOK (a, b, rtn, aIndex, bIndex, rIndex)) {
				System.out.println ("inconsistency 3: aIndex = " + aIndex
					+ "; bIndex = " + bIndex + "; rIndex = " + rIndex);
				System.out.println ("rtn = " + toString (rtn));
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
		return true;
	}
}
