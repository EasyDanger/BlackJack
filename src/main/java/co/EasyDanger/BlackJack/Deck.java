package co.EasyDanger.BlackJack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	List<Card> cards = new ArrayList<Card>();
	ArrayDeque<Card> shuffled = new ArrayDeque<Card>();

	public Deck() {
		for (int i = 0; i < 52; i++) {
			Card d = new Card(i);
			cards.add(i, d);
		}
//        Collections.shuffle(cards);
//        for (Card card : cards) {
//            shuffled.push(card);
//        }
	}
	public List<Card> getCards() {
		return cards;
	}

	public List<Card> shuffle() {
		Collections.shuffle(cards);
		return cards;
	}

//    public Deque<Card> shuffle() {
//        shuffled.clear();
//        Collections.shuffle(cards);
//        for (Card card : cards) {
//            shuffled.push(card);
//        }
//        return shuffled;
//    }

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
