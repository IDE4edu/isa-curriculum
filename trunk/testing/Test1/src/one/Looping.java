package one;

public class Looping {

	public static void main(String[] args) {
		
		System.out.println("in Looping");
	}
	
	
	public static void reverseInPlace(int[] input) {
		int len = input.length;
		for (int i = 0; i < len; i++) {
			input[i] = input[len-i];
		}
	}
	
	
	
	
	public static int[] reverseCopy(int[] input) {
		int len = input.length;
		int[] output = new int[len];
		for (int i = 0; i < len; i++) {
			output[i] = input[len-i];
		}
		return output;
	}
	
	
	
	
	
	
}
