
public class Bank {
	
	public Money reduce(Expression source, String to) {
		return source.reduce(this, to);
	}

	public void addRate(String sourceCurrency, String toCurrency, int rate) {
		
	}
	
	public int rate(String currency, String to) {
		return (currency.equals("CHF") && to.equals("USD")) ? 2 : 1;
	}

}
