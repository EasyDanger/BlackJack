package co.EasyDanger.BlackJack.cards;

public class Image {

	String url;

	public Image() {
		
	}
	public Image(String name, Suit suit) {
		char n = name.charAt(0);
		if (name.equals("10")) {
			n = '0';
		}
		char s = suit.toString().charAt(0);		
		url = "https://deckofcardsapi.com/static/img/" + n + s + ".png";
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return url;
	}
}
