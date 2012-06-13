
public class MergerISA {

	public static int [ ] merged (int [ ] a, int [ ] b) {
		int [ ] rtn = new int[a.length+b.length];
		int aIndex = 0;
		int bIndex = 0;
		int rIndex = 0;
		while (aIndex < a.length && bIndex < b.length) {
			if (a[aIndex] < b[bIndex]) {
				rtn[rIndex] = a[aIndex];
				aIndex++;
				rIndex++;
			} else {
				rtn[rIndex] = b[bIndex];
				bIndex++;
				rIndex++;
			}
			if (!isOK (a, b, rtn, aIndex, bIndex, rIndex)) {
				System.out.println ("inconsistency 1: aIndex = " + aIndex
					+ "; bIndex = " + bIndex + "; rIndex = " + rIndex);
			}
		}
		while (aIndex < a.length) {
			rtn[rIndex] = a[aIndex];
			aIndex++;
			rIndex++;
			if (!isOK (a, b, rtn, aIndex, bIndex, rIndex)) {
				System.out.println ("inconsistency 2: aIndex = " + aIndex
					+ "; bIndex = " + bIndex + "; rIndex = " + rIndex);
			}
		}
		while (bIndex < b.length) {
			rtn[rIndex] = b[bIndex];
			bIndex++;
			rIndex++;
			if (!isOK (a, b, rtn, aIndex, bIndex, rIndex)) {
				System.out.println ("inconsistency 3: aIndex = " + aIndex
					+ "; bIndex = " + bIndex + "; rIndex = " + rIndex);
			}
		}
		return rtn;
	}
	
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
