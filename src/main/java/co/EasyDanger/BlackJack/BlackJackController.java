package co.EasyDanger.BlackJack;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.EasyDanger.BlackJack.cards.Deck;
import co.EasyDanger.BlackJack.cards.Ending;
import co.EasyDanger.BlackJack.players.Dealer;
import co.EasyDanger.BlackJack.players.Player;

@Controller
public class BlackJackController
{
	
	@RequestMapping("/")
	public ModelAndView index(HttpSession session)
	{
		return new ModelAndView("index");
	}
	
	@RequestMapping("/deal")
	public ModelAndView deal(
			@RequestParam(name = "HowManyDecks", required = false) Integer howMany,
			HttpSession session)
	{
		ModelAndView mv = new ModelAndView("deal");
		if (howMany == null)
		{
			howMany = (Integer) session.getAttribute("HowMany");
		}
		session.setAttribute("HowMany", howMany);
		Deck deck = new Deck(howMany);
		Player player = new Player();
		Dealer dealer = new Dealer();
		
		Math.firstDeal(deck, player, dealer);
		
		session.setAttribute("Player", player);
		session.setAttribute("Dealer", dealer);
		session.setAttribute("Deck", deck);
		
		return mv;
	}
	
	@RequestMapping("/deal/hit")
	public ModelAndView hit(HttpSession session)
	{
		ModelAndView mv = new ModelAndView("deal");
		Player player = (Player) session.getAttribute("Player");
		Deck deck = (Deck) session.getAttribute("Deck");
		
		player.getHands().setCards(deck.drawCard());
		
		if (player.getLast().getValue() > 21)
		{
			player.getLast().setEnd(Ending.BUSTED);
		}
		
		session.setAttribute("Player", player);
		session.setAttribute("Deck", deck);
		
		return mv;
	}
	
	@RequestMapping("/new")
	public ModelAndView newGame(HttpSession session)
	{
		session.removeAttribute("Player");
		session.removeAttribute("Dealer");
		session.removeAttribute("Deck");
		session.removeAttribute("Stay");
		
		return new ModelAndView("redirect:/deal");
	}
	
	@RequestMapping("/deal/stay")
	public ModelAndView stay(HttpSession session)
	{
		ModelAndView mv = new ModelAndView("deal");
		Player player = (Player) session.getAttribute("Player");
		Dealer dealer = (Dealer) session.getAttribute("Dealer");
		
		dealer.play(session);
		
		Boolean stayed = Math.scoreHand(player, dealer);
		
		session.setAttribute("Stay", stayed);
		session.setAttribute("Dealer", dealer);
		session.setAttribute("Player", player);
		return mv;
	}
	
	@RequestMapping("/deal/split")
	public ModelAndView split(HttpSession session)
	{
		Player player = (Player) session.getAttribute("Player");
		player.splitHand(player.getHands());
		session.setAttribute("Player", player);
		return new ModelAndView("deal");
	}
	
	@RequestMapping("/debug")
	public ModelAndView debug(HttpSession session)
	{
		Math.debugger(session);
		return new ModelAndView("deal");
	}
}
