public class Money {

	protected int amount;

	public Money(int amount) {
		this.amount = amount;
	}

	public boolean equals(Object object) {
		Money money = (Money) object;
		return this.getClass().equals(money.getClass()) && this.amount == money.amount;
	}

}