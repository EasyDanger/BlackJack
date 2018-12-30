package co.EasyDanger.BlackJack.players;

import java.util.LinkedList;

import co.EasyDanger.BlackJack.cards.Card;

public class Player extends LinkedList<Hand>
{
	
	private static final long serialVersionUID = 1L;
	
	private Integer numOfHands = 0;
	
	public Hand getHands()
	{
		if (this.isEmpty())
		{
			this.add(new Hand());
			numOfHands += 1;
		}
		return this.getLast();
	}
	
	public void setHands(Hand hand)
	{
		this.add(hand);
	}
	
	public void splitHand(Hand hand)
	{
		Card card = hand.getCards().get(1);
		hand.getCards().remove(1);
		Hand splitHand = new Hand(card);
		this.add(splitHand);
		numOfHands += 1;
	}
	
	public Integer getNumOfHands()
	{
		return this.numOfHands;
	}
	
	public void nextHand()
	{
		numOfHands -= 1;
	}
}
