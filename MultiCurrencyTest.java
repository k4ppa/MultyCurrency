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
		assertTrue(Money.Franc(5).equals(Money.Franc(5)));
		assertFalse(Money.Franc(5).equals(Money.Franc(6)));
		assertFalse(Money.Franc(5).equals(Money.Dollar(5)));
	}
	
	@Test
	public void testFrancMultiplication() {
		Money five = new Franc(5);
		assertEquals(Money.Franc(10), five.times(2));
		assertEquals(Money.Franc(15), five.times(3));
	}
}
