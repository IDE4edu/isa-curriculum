package introOOP;

public class CardRunner {

	
	public static void main (String [ ] args) {
		Card c1 = new Card ("8", "spades");
		Card c2 = new Card ("A", "diamonds");
		System.out.println ("Card 1 is the " + c1.rank ( ) + " of " + c1.suit ( ));
		System.out.println ("Card 2 is the " + c2.rank ( ) + " of " + c2.suit ( ));
	
}
}
