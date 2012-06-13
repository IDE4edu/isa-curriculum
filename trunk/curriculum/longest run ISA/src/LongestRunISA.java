public class LongestRunISA  {
	
	public static int longestRun (int [ ] values) {
		// code to find the longest sequence of consecutive equal elements (start+length)

		int bestStartPos = 0;
		int maxLen = 1;
		int startPos = 0;

		for (int k=1; k<values.length; k++) {
			if (values[k] == values[startPos]) {
				if (k-startPos+1 > maxLen) {
					maxLen = k-startPos+1;
					bestStartPos = startPos;
				}
			} else {
				startPos = k;
			}
			if (!isOK (values, k, startPos, bestStartPos, maxLen)) {
				System.out.println ("inconsistency at position " + k);
			}
		}
		return bestStartPos;
	}
		
	// invariant
	//	0 <= bestStartPos <= startPos <= k < values.length
	//	startPos is the position of start of current run, 
	//		so values[startPos] ... values[k] are all equal 
	//			and values[startPos-1], if it exists, is different
	//	values[bestStartPos] ... values[bestStartPos+maxLen-1] are all equal,
	//		and values[bestStartPos-1], if it exists, is different,
	//	and maxLen is maximal
	public static boolean isOK (int [ ] values, int k, int startPos, int bestStartPos, int maxLen) {
		if (bestStartPos < 0 || startPos < bestStartPos || k < startPos || k >= values.length) {
			return false;
		}
		if (maxLen < 1) {
			return false;
		}
		// is startPos the starting position of the current run?
		for (int j=startPos; j<k; j++) {
			if (values[j] != values[j+1]) {
				return false;
			}
		}
		// is the (alleged) starting position of the current run actually where it starts?
		if (startPos > 0 && values[startPos] == values[startPos-1]) {
			return false;
		}
		// do bestStartPos and maxLen define a run?
		for (int j=0; j<maxLen-1; j++) {
			if (values[j+bestStartPos] != values[j+bestStartPos+1]) {
				return false;
			}
		}
		// is bestStartPos where the longest run starts?
		if (bestStartPos > 0 && values[bestStartPos] == values[bestStartPos-1]) {
			return false;
		}
		// is bestStartPos+maxLen-1 where the longest run ends?
		if (bestStartPos+maxLen-1<k && values[bestStartPos+maxLen-1]==values[bestStartPos+maxLen]) {
			return false;
		}
		// is any other run longer than maxLen?
		int len=1;
		for (int j=1; j<=k; j++) {
			if (values[j] != values[j-1]) {
				len = 1;
			} else {
				len++;
			}
			if (len > maxLen) {
				return false;
			}
		}
		return true;
	}
}
