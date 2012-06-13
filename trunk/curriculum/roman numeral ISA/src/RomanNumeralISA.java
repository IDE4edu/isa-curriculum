public class RomanNumeralISA {
	
	public static int toDecimal (char romanDigit) {
		switch (romanDigit) {
			case 'I': case 'i': return 1;
			case 'V': case 'v': return 5;
			case 'X': case 'x': return 10;
			case 'L': case 'l': return 50;
			case 'C': case 'c': return 100;
			case 'D': case 'd': return 500;
			case 'M': case 'm': return 1000;
			default: return 0;
		}
	}

	public static int toDecimal (String romanNumeral) {
		int rtn;
		rtn = 0;
		for (int k=0; k<romanNumeral.length ( ); ) {  // note: k is incremented in the loop body
			if (k == romanNumeral.length ( ) - 1
					|| toDecimal (romanNumeral.charAt(k)) >= toDecimal (romanNumeral.charAt (k+1))) {
				rtn = rtn + toDecimal (romanNumeral.charAt (k));
				k++;
			} else {
				rtn = rtn - toDecimal (romanNumeral.charAt (k)) + toDecimal (romanNumeral.charAt (k+1));
				k += 2;
			}
			if (!isOK (romanNumeral, k, rtn)) {
				System.out.println ("Inconsistency for " + romanNumeral + " at position " + k + ", rtn = " + rtn);
			}
		}
		return rtn;
	}

	public static boolean isOK (String romanNumeral, int k, int rtn) {
		if (k <= 0 || k > romanNumeral.length ( )) {
			return false;
		}
		if (k > 0 && k < romanNumeral.length ( ) && toDecimal (romanNumeral.charAt(k-1)) < toDecimal (romanNumeral.charAt (k))) {
			return false;
		}
		if (!romanNumeral.substring (0, k).equals (toRoman (rtn))) {
			return false;
		}
		return true;
	}
	
	
	public static String toRoman (int n) {
		if (n >= 1000) {
			return "m" + toRoman (n-1000);
		} else if (n >= 900) {
			return "cm" + toRoman (n-900);
		} else if (n >= 500) {
			return "d" + toRoman (n-500);
		} else if (n >= 400) {
			return "cd" + toRoman (n-400);
		} else if (n >= 100) {
			return "c" + toRoman (n-100);
		} else if (n >= 90) {
			return "xc" + toRoman (n-90);
		} else if (n >= 50) {
			return "l" + toRoman (n-50);
		} else if (n >= 40) {
			return "xl" + toRoman (n-40);
		} else if (n >= 10) {
			return "x" + toRoman (n-10);
		} else if (n >= 9) {
			return "ix" + toRoman (n-9);
		} else if (n >= 5) {
			return "v" + toRoman (n-5);
		} else if (n >= 4) {
			return "iv" + toRoman (n-4);
		} else if (n >= 1) {
			return "i" + toRoman (n-1);
		} else {
			return "";
		}
	}
}
