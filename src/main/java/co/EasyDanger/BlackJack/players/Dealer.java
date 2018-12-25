package co.EasyDanger.BlackJack.players;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.EasyDanger.BlackJack.cards.Deck;

public class Dealer extends Hand {

	public Dealer() {
		super();
	}

	public void play(HttpSession session, RedirectAttributes redir) {
		Deck deck = (Deck) session.getAttribute("Deck");
		while (this.getValue() < 17) {
			this.setHand(deck.drawCard());
		}
	}
}
