public class InsertionSort {
	
	// Precondition: elements 0 through k-1 of list are in increasing order.
	// Postcondition: elements 0 through k of list are in increasing order.
	public static void insert (int list[ ], int k) {
		int temp = list[k];
		while (k > 0 && list[k-1] > temp) {
			list[k] = list[k-1];
			k--;
		}
		list[k] = temp;
	}
	
	// Return true if the first k elements of list are in increasing order;
	// return false otherwise.
	public static boolean isOK (int [ ] list, int k) {
		if (k<0 || k>=list.length) {
			return false;
		}
		for (int j=0; j<k; j++) {
			if (list[j]>list[j+1]) {
				return false;
			}
		}
		return true;
	}

	// Return the result of applying the insertion sort algorithm to the list array.
	public static int [ ] insertionSort (int [ ] list) {
		int [ ] rtn = new int[list.length];
		for (int k=0; k<list.length; k++) {
			rtn[k] = list[k];
		}
		for (int k=0; k<rtn.length; k++) {
			insert (rtn, k);
			if (!isOK (rtn, k)) {
				System.out.println ("inconsistency at position " + k);
			}
		}
		return rtn;
	}
	
	public static void main (String [ ] args) {
		int [ ] list = {3, 1, 7, 4, 5, 9, 2, 8, 6};
		list = insertionSort (list);
		for (int k=0; k<list.length; k++) {
			System.out.print (list[k]);
		}
		System.out.println ( );
	}
}
