public class ZeroBeforeOneISA {

	public static int [ ] rearrange (int [ ] values) {
		int [ ] rtn = new int[values.length];
		for (int k=0; k<values.length; k++) {
			rtn[k] = values[k];
		}
		int last0pos = -1;
		for (int k=0; k<rtn.length; k++) {
			if (rtn[k]==0) {
				last0pos++;
				if (k!=last0pos) {
					int temp = rtn[last0pos];
					rtn[last0pos] = rtn[k];
					rtn[k] = temp;
				}
			}
			if (!isOK (rtn, k)) {
				System.out.println ("inconsistency at position " + k);
			}
		}
		return rtn;
	}

	// Check for consistency.
	// values[0..last0pos] should be 0 and values[last0pos+1..k] should be 1.
	public static boolean isOK (int [ ] values, int k) {
		int j;
		for (j=0; j<=k && values[j]==0; j++) {
		}
		if (j>k) {
			return true;	// all elements from 0 through k are 0
		}
		for ( ; j<=k && values[j]==1; j++) {
		}
		return j>k; 
	}
}
