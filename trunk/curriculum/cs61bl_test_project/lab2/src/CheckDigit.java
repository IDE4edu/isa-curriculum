import java.util.Scanner;


public class CheckDigit {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("Enter an integer id for verification: ");
		int id = scanner.nextInt();
		boolean isLegal = checkDigit(id);
		if (isLegal) {
			System.out.println(id + " is legal");
		} else {
			System.out.println(id + " is not legal");
		}
	}
	
	
	public static boolean checkDigit(int id) {
		
		// your missing code goes here
		
		return true;
	}
}
