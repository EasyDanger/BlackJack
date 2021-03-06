package co.EasyDanger.BlackJack.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	List<Card> cards = new ArrayList<Card>();
	int numberOff = 1;

	public Deck(int howMany) {
		for (int i = 0; i < (howMany * 52); i++) {
			Card d = new Card(i);
			cards.add(i, d);
		}
	}

	public List<Card> getCards() {
		return cards;
	}

	public List<Card> shuffle() {
		Collections.shuffle(cards);
		return cards;
	}

	@Override
	public String toString() {
		return "Deck{" + cards + '}';
	}

	public Card drawCard() {
		Card card = cards.get(0);
		this.cards.remove(0);
		return card;
	}

}
