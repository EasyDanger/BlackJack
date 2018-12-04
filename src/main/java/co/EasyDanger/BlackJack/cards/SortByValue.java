package co.EasyDanger.BlackJack.cards;

import java.util.Comparator;

public class SortByValue implements Comparator<Card> {

	public int compare(Card a, Card b) {
		return a.getValue() - b.getValue();
	}

}