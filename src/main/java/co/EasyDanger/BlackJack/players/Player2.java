package co.EasyDanger.BlackJack.players;

import java.util.LinkedList;
import java.util.List;

import co.EasyDanger.BlackJack.cards.Card;

public class Player2 {
	
	List<Hand> hands = new LinkedList<Hand>();
	Integer numOfHands = 1;

	public Hand getHands() {
		return hands.get(numOfHands-1);
	}

	public void setHands(Hand hand) {
		this.hands.add(hand);
	}
	public void splitHand(Hand hand) {
		Card card = hand.getCards().get(1);
		hand.getCards().remove(1);
		Hand splitHand = new Hand(card);
		this.hands.add(splitHand);
		numOfHands += 1;
	}

	public Integer getNumOfHands() {
		return numOfHands;
	}
}