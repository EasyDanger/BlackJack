package co.EasyDanger.BlackJack.cards;

public enum Ending
{
	
	BJ(
			"BlackJack!"),
	DEALERBJ(
			"Dealer BlackJack!"),
	PUSH(
			"It's a push. No side."),
	BUSTED(
			"Busted"),
	DEALERBUSTED(
			"The Dealer busted!"),
	WIN(
			"You win!"),
	LOSE(
			"You lost!");
	
	private final String val;
	
	private Ending(String val)
	{
		this.val = val;
	}
	
	public String getVal()
	{
		return this.val;
	}
	
	@Override
	public String toString()
	{
		return val;
	}
}
