
public abstract class Money {

	protected int amount;
	protected String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public boolean equals(Object object) {
		Money money = (Money) object;
		return this.getClass().equals(money.getClass()) && this.amount == money.amount;
	}

	public static Money Dollar(int amount) {
		return new Dollar(amount, "USD");
	}
	
	public static Money Franc(int amount) {
		return new Franc(amount, "CHF");
	}
	
	public abstract Money times(int multiplier);

	public String currency() {
		return currency;
	}

}