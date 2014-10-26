
public class Sum implements Expression {
	protected Expression augend;
	protected Expression addend;
	
	public Sum(Expression augend, Expression addend) {
		this.augend = augend;
		this.addend = addend;
	}
	
	public Money reduce(Bank bank, String to) {
		Money augend = this.augend.reduce(bank, to);
		Money addend = this.addend.reduce(bank, to);
		int amount = augend.amount + addend.amount;
		return new Money(amount, to);
	}

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}
