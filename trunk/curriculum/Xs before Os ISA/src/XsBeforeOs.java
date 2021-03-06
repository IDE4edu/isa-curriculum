public class XsBeforeOs {

	// Rearrange the elements of values so that all the X's precede all the O's.
	public static void rearrange (char [ ] values) {
		int lastXpos = -1;
		for (int k=0; k<values.length; k++) {
			if (values[k]=='X') {
				lastXpos++;
				if (k!=lastXpos) {
					char temp = values[lastXpos];
					values[lastXpos] = values[k];
					values[k] = temp;
				}
			}
			if (!isOK (values, k)) {
				System.out.println ("inconsistency at position " + k);
			}
		}
	}

	// Check for consistency.
	// Among elements 0 through k of values, all the X's precede all the O's.
	public static boolean isOK (char [ ] values, int k) {
		int j;
		for (j=0; j<=k && values[j]=='X'; j++) {
		}
		if (j>k) {
			return true;	// all elements from 0 through k are 'X'
		}
		for ( ; j<=k && values[j]=='O'; j++) {
		}
		return j>k; 
	}
}
