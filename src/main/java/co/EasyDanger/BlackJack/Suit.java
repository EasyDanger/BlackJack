package co.EasyDanger.BlackJack;

public enum Suit {

	SPADE, CLUB, HEART, DIAMOND;

	public String toString() {
		if (this == SPADE) {
			return "Spade";
		} else if (this == CLUB) {
			return "Club";
		} else if (this == HEART) {
			return "Heart";
		} else {
			return "Diamond";
		}
	}

}
