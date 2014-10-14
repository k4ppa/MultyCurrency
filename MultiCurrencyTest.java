import static org.junit.Assert.*;

import org.junit.Test;


public class MultiCurrencyTest {

	@Test
	public void testMultiplication() {
		Money five = Money.Dollar(5);
		assertEquals(Money.Dollar(10), five.times(2));
		assertEquals(Money.Dollar(15), five.times(3));
	}

	@Test
	public void testEquality() throws Exception {
		assertTrue(Money.Dollar(5).equals(Money.Dollar(5)));
		assertFalse(Money.Dollar(5).equals(Money.Dollar(6)));
		assertFalse(Money.Franc(5).equals(Money.Dollar(5)));
	}
	
	@Test
	public void testCurrency() throws Exception {
		assertEquals("USD", Money.Dollar(1).currency());
		assertEquals("CHF", Money.Franc(1).currency());
	}
	
	@Test
	public void testSimpleAddition() throws Exception {
		Money five = Money.Dollar(5);
		Expression sum = five.plus(five);
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum, "USD");
		assertEquals(Money.Dollar(10), reduced);
	}
}


