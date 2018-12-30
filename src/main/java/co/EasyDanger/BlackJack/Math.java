package co.EasyDanger.BlackJack;

import javax.servlet.http.HttpSession;

import co.EasyDanger.BlackJack.cards.Deck;
import co.EasyDanger.BlackJack.cards.Ending;
import co.EasyDanger.BlackJack.players.Dealer;
import co.EasyDanger.BlackJack.players.Hand;
import co.EasyDanger.BlackJack.players.Player;

public class Math
{
	
	public static void debugger(HttpSession session)
	{
		Boolean debug = (Boolean) session.getAttribute("Debug");
		if (debug == null)
		{
			debug = true;
		}
		if (!debug)
		{
			debug = true;
		} else
		{
			debug = false;
		}
		session.setAttribute("Debug", debug);
	}
	
	public static Boolean dealerHandShow(Player player)
	{
		for (Hand hand : player)
		{
			if (hand.getEnd().getVal().equals("Busted"))
			{
				return false;
			}
		}
		return true;
	}
	
	public static void firstDeal(Deck deck, Player player, Dealer dealer)
	{
		deck.shuffle();
		player.getHands().setCards(deck.drawCard());
		dealer.setCards(deck.drawCard());
		player.getHands().setCards(deck.drawCard());
		dealer.setCards(deck.drawCard());
		if (dealer.getValue() == 21)
		{
			player.getLast().setEnd(Ending.DEALERBJ);
		}
		if (player.getLast().getValue() == 21)
		{
			player.getLast().setEnd(Ending.BJ);
		}
		if ((player.getLast().getValue() == 21) && (21 == dealer.getValue()))
		{
			player.getLast().setEnd(Ending.PUSH);
		}
	}
	
	public static Boolean scoreHand(Player player, Dealer dealer)
	{
		Boolean stayed = true;
		if (player.getLast().getValue() > dealer.getValue())
		{
			player.getLast().setEnd(Ending.WIN);
		}
		if (dealer.getValue() > player.getLast().getValue())
		{
			player.getLast().setEnd(Ending.LOSE);
		}
		if (dealer.getValue() == player.getLast().getValue())
		{
			player.getLast().setEnd(Ending.PUSH);
		}
		if (dealer.getValue() > 21)
		{
			player.getLast().setEnd(Ending.DEALERBUSTED);
		}
		if (player.size() > 1)
		{
			stayed = false;
		}
		player.nextHand();
		return stayed;
	}
}
