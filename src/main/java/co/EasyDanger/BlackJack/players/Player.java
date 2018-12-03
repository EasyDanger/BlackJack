package co.EasyDanger.BlackJack.players;

import java.util.LinkedList;
import java.util.List;

import co.EasyDanger.BlackJack.Card;

public class Player {

	private List<Card> hand = new LinkedList<Card>();
	private Integer value = 0;
	private boolean aced = false;
	private boolean aced1 = false;

	public List<Card> getHand() {
		return hand;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public void setHand(Card card) {
		this.hand.add(card);
		if ((card.getValue() == 11) && (this.value > 10)) {
			this.value += 1;
		} else {
			value += card.getValue();
		}
		if (value > 21) {
			if (((hand.get(0).getName().equals("Ace"))) && !aced) {
				value -= 10;
				aced = true;
			}
			if (((hand.get(1).getName().equals("Ace"))) && !aced1 ) {
				value -= 10;
				aced1 = true;
			}
		}
	}

}
