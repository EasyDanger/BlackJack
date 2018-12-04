package co.EasyDanger.BlackJack;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.EasyDanger.BlackJack.cards.Deck;
import co.EasyDanger.BlackJack.players.Dealer;
import co.EasyDanger.BlackJack.players.Player;

@Controller
public class BlackJackController {

	@RequestMapping("/")
	public ModelAndView index(HttpSession session, RedirectAttributes redir) {
		return new ModelAndView("index");
	}

	@RequestMapping("/deal")
	public ModelAndView deal(HttpSession session, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView("deal");
		Deck deck = new Deck();
		Player player = new Player();
		Dealer dealer = new Dealer();
		Boolean dealerBJ = false;
		Boolean busted = false;
		Boolean debug = false;
		Boolean playerBJ = false;
		Boolean push = false;
		deck.shuffle();
		player.setHand(deck.drawCard());
		dealer.setHand(deck.drawCard());
		player.setHand(deck.drawCard());
		dealer.setHand(deck.drawCard());

		if (dealer.getValue() == 21) {
			dealerBJ = true;
		}
		if (player.getValue() == 21) {
			playerBJ = true;
		}
		if (player.getValue() == dealer.getValue()) {
			push = true;
		}
		
		session.setAttribute("Push", push);
		session.setAttribute("PlayerBJ", playerBJ);
		session.setAttribute("Debug", debug);
		session.setAttribute("Player", player);
		session.setAttribute("Dealer", dealer);
		session.setAttribute("Deck", deck);
		session.setAttribute("DealerBJ", dealerBJ);
		session.setAttribute("Busted", busted);

		return mv;
	}

	@RequestMapping("/deal/hit")
	public ModelAndView hit(HttpSession session, RedirectAttributes redir) {

		ModelAndView mv = new ModelAndView("deal");
		Player player = (Player) session.getAttribute("Player");
		Deck deck = (Deck) session.getAttribute("Deck");
		Boolean busted = (Boolean) session.getAttribute("Busted");
		
		player.setHand(deck.drawCard());
		
		if (player.getValue() > 21) {
			busted = true;
			session.setAttribute("Busted", busted);
		}
		
		session.setAttribute("Player", player);
		session.setAttribute("Deck", deck);
		
		return mv;
	}

	@RequestMapping("/new")
	public ModelAndView newGame(HttpSession session, RedirectAttributes redir) {
		session.invalidate();
		return new ModelAndView("redirect:/deal");
	}

	@RequestMapping("/deal/stay")
	public ModelAndView stay(HttpSession session, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView("deal");
		Boolean stayed = true;
		Player player = (Player) session.getAttribute("Player");
		Boolean playerWon = false;
		Boolean playerLost = false;
		Dealer dealer = (Dealer) session.getAttribute("Dealer");
		Boolean push = (Boolean) session.getAttribute("Push");
		
		dealer.play(session, redir);
			
		if (dealer.getValue() > 21) {
			playerWon = true;
		} else if (dealer.getValue() > player.getValue()) {
			playerWon = false;
			playerLost = true;
		} else if ((player.getValue() > dealer.getValue()) && (player.getValue() < 22)) {
			playerWon = true;
		}
		if (player.getValue() == dealer.getValue()) {
			push = true;
		}
		
		session.setAttribute("Stay", stayed);
		session.setAttribute("Push", push);
		session.setAttribute("PlayerLost", playerLost);
		session.setAttribute("Dealer", dealer);
		session.setAttribute("Player", player);
		session.setAttribute("PlayerWon", playerWon);
		
		return mv;
	}

	@RequestMapping("/debug")
	public ModelAndView debug(HttpSession session, RedirectAttributes redir) {
		Boolean debug = (Boolean) session.getAttribute("Debug");
		
		if (debug) {
			debug = false;
		} else {
			debug = true;
		}
		
		session.setAttribute("Debug", debug);
		
		return new ModelAndView("deal");
	}
}
