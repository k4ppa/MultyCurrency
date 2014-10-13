
public abstract class Money {

	protected int amount;

	public Money(int amount) {
		this.amount = amount;
	}

	public boolean equals(Object object) {
		Money money = (Money) object;
		return this.getClass().equals(money.getClass()) && this.amount == money.amount;
	}

	public static Money Dollar(int amount) {
		return new Dollar(amount);
	}
	
	public static Money Franc(int amount) {
		return new Franc(amount);
	}
	
	public abstract Money times(int multiplier);

}