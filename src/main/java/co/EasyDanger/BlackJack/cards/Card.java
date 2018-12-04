package co.EasyDanger.BlackJack.cards;

public class Card {

	int num;
	Suit suit;
	String name;
	Image image;
	Integer value;

	public Card() {
	}

	public Card(int num) {
		this.num = num % 13;
		if (num % 13 == 0) {
			this.name = "Ace";
			this.value = 11;
		} else if (num % 13 == 10) {
			this.name = "Jack";
			this.value = 10;
		} else if (num % 13 == 11) {
			this.name = "Queen";
			this.value = 10;
		} else if (num % 13 == 12) {
			this.name = "King";
			this.value = 10;
		} else {
			this.name = "" + ((num + 1) % 13);
			this.value = (num+1) % 13;
		}
		if (num > 38) {
			this.suit = Suit.HEART;
		} else if (num > 25) {
			this.suit = Suit.CLUB;
		} else if (num > 12) {
			this.suit = Suit.DIAMOND;
		} else {
			this.suit = Suit.SPADE;
		}
		this.image = new Image(this.name, this.suit);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Card[" + name + " of " + suit + ']';
	}

}

