package co.EasyDanger.BlackJack.players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import co.EasyDanger.BlackJack.cards.Card;
import co.EasyDanger.BlackJack.cards.SortByValue;

public class Player {

	private List<Card> hand = new LinkedList<Card>();
	private Integer value = 0;

	public List<Card> getHand() {
		return hand;
	}

	public Integer getValue() {
		value = 0;
		List<Card> temp = new ArrayList<Card>(hand);
		Collections.sort(temp, new SortByValue());
		for (Card card : temp) {
			if (card.getName().equals("Ace") && (value > 10)) {
				value += 1;
			} else {
				value += card.getValue();
			}
		}
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public void setHand(Card card) {
		this.hand.add(card);
	}

}
