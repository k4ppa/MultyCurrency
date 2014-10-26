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
	
	@Test
	public void testPlusReturnSum() throws Exception {
		Money five = Money.Dollar(5);
		Expression result = five.plus(five);
		Sum sum = (Sum) result;
		assertEquals(five, sum.augend);
		assertEquals(five, sum.addend);
	}
	
	@Test
	public void testReduceSum() throws Exception {
		Expression sum = new Sum(Money.Dollar(3), Money.Dollar(4));
		Bank bank = new Bank();
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.Dollar(7), result);
	}
	
	@Test
	public void testReduceMoney() throws Exception {
		Bank bank = new Bank();
		Money result = bank.reduce(Money.Dollar(1), "USD");
		assertEquals(Money.Dollar(1), result);
	}
	
	@Test
	public void testReduceMoneyDifferenceCurrency() throws Exception {
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(Money.Franc(2), "USD");
		assertEquals(Money.Dollar(1), result);
	}
	
	@Test
	public void testArrayEquals() throws Exception {
		assertArrayEquals(new Object[] {"abc"}, new Object[] {"abc"});
	}
	
	@Test
	public void testIdentityRate() throws Exception {
		assertEquals(1, new Bank().rate("USD", "USD"));
	}
	
	@Test
	public void testMixedAddiction() throws Exception {
		Expression fiveBucks = Money.Dollar(5);
		Expression tenFrancs = Money.Franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
		assertEquals(Money.Dollar(10), result);
	}

    @Test
    public void testSumPlusMoney() {
        Expression fiveBucks = Money.Dollar(5);
        Expression tenFrancs = Money.Franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
        Money result = sum.reduce(bank, "USD");
        assertEquals(Money.Dollar(15), result);
    }

    @Test
    public void testSumTimes() {
        Expression fiveBucks = Money.Dollar(5);
        Expression tenFrancs = Money.Franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
        Money result = sum.reduce(bank, "USD");
        assertEquals(Money.Dollar(20), result);
    }
}


