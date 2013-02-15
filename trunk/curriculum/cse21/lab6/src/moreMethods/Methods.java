package moreMethods;

public class Methods {
	
	public static void init(long[] arr) {
		// Initialize all the entries of the array to 0
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
	}

	public static long sumAll(int max) {
		// sumAll basic version
		long subTotal = 0;
		for (int i = 1; i <= max; i++) {
			subTotal += i;
		}
		return subTotal;
	}
	
	public static long sumAll(long[] arr, int max) {
		// Use the array to store sub results
		for (int i = 1; i <= max ; i++) {
			if (arr[i] == 0) {
				arr[i] = arr[i-1] + i;	
			}
		}
		return arr[max];
	}

	public static long squareSum(int max) {
		long subTotal = 0;
		for (int i = 1; i <= max; i++) {
			subTotal += i*i;
		}
		return subTotal;
	}
	
	public static long squareSum(long[] arr, int max) {
		for (int i = 1; i <= max ; i++) {
			if (arr[i] == 0) {
				arr[i] = arr[i-1] + i*i;	
			}
		}
		return arr[max];
	}

	public static long fib(int max) {
		if (max == 0) {
			return 0;
		} else if (max == 1) {
			return 1;
		}
		long subTotal = 0;
		long a,b;
		a = 0;
		b = 1;
		for (int i = 2; i <= max; i++) {
			subTotal = a+b;
			a = b;
			b = subTotal;
		}
		return subTotal;
	}
	
	public static long fib(long[] arr, int max) {
		arr[1]=1;
		for (int i = 2; i <= max ; i++) {
			if (arr[i] == 0) {
				arr[i] = arr[i-1] + arr[i-2];	
			}
		}
		return arr[max];
	}
	
	public static long factorial(int max) {
		long subTotal = 1;
		
		for (int i = 2; i <= max; i++) {
			subTotal = subTotal * i;
		}
		return subTotal;
	}
	
	public static long factorial(long[] arr, int max) {
		arr[0]=1;
		arr[1]=1;
		for (int i = 2; i <= max ; i++) {
			if (arr[i] == 0) {
				arr[i] = arr[i-1] * i;	
			}
		}
		return arr[max];
	}
}
