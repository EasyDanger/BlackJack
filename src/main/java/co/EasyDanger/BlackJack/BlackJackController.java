package co.EasyDanger.BlackJack;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		Player dealer = new Player();
		Boolean dealerBJ = false;
		Boolean busted = false;
		deck.shuffle();
		player.setHand(deck.drawCard());
		dealer.setHand(deck.drawCard());
		player.setHand(deck.drawCard());
		dealer.setHand(deck.drawCard());

		if (dealer.getValue() == 21) {
			dealerBJ = true;
		}

		session.setAttribute("Player", player);
		session.setAttribute("Dealer", dealer);
		session.setAttribute("Deck", deck);
		session.setAttribute("DealerWon", dealerBJ);
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
		if (player.getValue() > 21 ) {
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
		Player player = (Player) session.getAttribute("Player");
		Deck deck = (Deck) session.getAttribute("Deck");
		Player dealer = (Player) session.getAttribute("Dealer");
		
		
		return mv;
	}

}
