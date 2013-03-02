package introOOP;

public class Card {
	private String rankName;
	private String suitName;

	public Card(String rankName, String suitName) {
		this.rankName = rankName;
		this.suitName = suitName;
	}

	public String rank() {
		return rankName;
	}

	public String suit() {
		return suitName;
	}

	public int value() {
		// Fill in here -- should return a int between 1 and 13
		return 0;
	}

}
