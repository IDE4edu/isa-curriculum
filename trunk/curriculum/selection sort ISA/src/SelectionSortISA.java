public class SelectionSortISA {
	
	// Find the smallest item in list elements starting at position k,
	// and exchange it with element k.
	private static void update (int list [ ], int k) {
		int minpos = k;
		for (int j=k+1; j<list.length; j++) {
			if (list[j] < list[minpos]) {
				minpos = j;
			}
		}
		int temp = list[k];
		list[k] = list[minpos];
		list[minpos] = temp;
	}
	
	public static boolean isOK (int [ ] list, int k) {
		if (k<0 || k>=list.length) {
			return false;
		}
		for (int j=0; j<k; j++) {
			if (list[j]>list[j+1]) {
				return false;
			}
		}
		for (int j=k+1; j<list.length; j++) {
			if (list[k]>list[j]) {
				return false;
			}
		}
		return true;
	}

	public static int [ ] selectionSort (int [ ] list) {
		int [ ] rtn = new int[list.length];
		for (int k=0; k<list.length; k++) {
			rtn[k] = list[k];
		}
		for (int k=0; k<rtn.length; k++) {
			update (rtn, k);
			if (!isOK (rtn, k)) {
				System.out.println ("inconsistency at position " + k);
			}
		}
		return rtn;
	}

	public static void main (String [ ] args) {
		int [ ] list = {3, 1, 7, 4, 5, 9, 2, 8, 6};
		selectionSort (list);
		for (int k=0; k<list.length; k++) {
			System.out.print (list[k]);
		}
		System.out.println ( );
	}

}
