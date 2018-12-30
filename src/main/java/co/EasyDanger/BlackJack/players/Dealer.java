package co.EasyDanger.BlackJack.players;

import javax.servlet.http.HttpSession;

import co.EasyDanger.BlackJack.cards.Deck;

public class Dealer extends Hand
{
	
	private static final long serialVersionUID = 1L;
	
	public Dealer()
	{
		super();
	}
	
	public void play(HttpSession session)
	{
		Deck deck = (Deck) session.getAttribute("Deck");
		while (this.getValue() < 17)
		{
			this.setCards(deck.drawCard());
		}
	}
}
