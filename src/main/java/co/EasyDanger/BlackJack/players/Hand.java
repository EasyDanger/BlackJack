package co.EasyDanger.BlackJack.players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import co.EasyDanger.BlackJack.cards.Card;
import co.EasyDanger.BlackJack.cards.Ending;
import co.EasyDanger.BlackJack.cards.SortByValue;

public class Hand extends LinkedList<Card>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer value;
	private Ending end;
	
	public Hand() {}
	public Hand(Card card) {
		this.add(card);
	}

	public List<Card> getCards() {
		return this;
	}

	public Integer getValue() {
		value = 0;
		List<Card> temp = new ArrayList<Card>(this);
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

	public void setCards(Card card) {
		this.add(card);
	}
	public Ending getEnd() {
		return end;
	}
	public void setEnd(Ending end) {
		this.end = end;
	}
}
