public class Money {

	protected int amount;

	public Money(int amount) {
		this.amount = amount;
	}

	public Money times(int multiplier) {
		return new Money(amount * multiplier);
	}

	public boolean equals(Object object) {
		Money money = (Money) object;
		return this.amount == money.amount;
	}

}