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
}
