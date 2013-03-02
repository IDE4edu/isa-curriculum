package card_v1;

/* 
 * You can open this file from the package explorer: lab8 | src | card_v1 | Card.java
 */

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

}
