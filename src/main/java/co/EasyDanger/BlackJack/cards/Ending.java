package co.EasyDanger.BlackJack.cards;

public enum Ending {

	BJ("BlackJack!"), 
	DEALERBJ("Dealer BlackJack"), 
	PUSH("It's a push. Do side."), 
	BUSTED("You busted out!"),
	DEALERBUSTED("The Dealer busted!"), 
	WIN("You win!"), 
	LOSE("You lost!");

	private final String val;

	private Ending(String val) {
		this.val = val;
	}

	@Override
    public String toString() {
        return val;
    }
}
