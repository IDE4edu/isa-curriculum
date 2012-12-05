package recursionIntroduction;

public class RecursionTry {

	static int k = 0;

	public static void main(String[] args) {
		recur(k);
	}

	public static void recur(int k) {
		if (k <= 5) {
			System.out.println("count = " + k);
			recur(k + 1);
		}
	}
}
