
public class Money implements Expression {

	protected int amount;
	protected String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public boolean equals(Object object) {
		Money money = (Money) object;
		return this.currency.equals(money.currency) && this.amount == money.amount;
	}

	public static Money Dollar(int amount) {
		return new Money(amount, "USD");
	}
	
	public static Money Franc(int amount) {
		return new Money(amount, "CHF");
	}
	
	public Money times(int multiplier) {
		return new Money(amount * multiplier, currency);
	}

	public String currency() {
		return currency;
	}

	@Override
	public String toString() {
		return amount + " " + currency;
	}

	public Expression plus(Money addend) {
		return new Money(amount + addend.amount, currency);
	}

}