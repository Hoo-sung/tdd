package com.tdd.tdd_practice;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class tests {

    @Test
    void testDollarMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void testCurrency() throws Exception {
        //given
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
        //when

        //then
    }

    @Test
    public void testSimpleAddition() throws Exception {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testPlusReturnsSum() throws Exception {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }
//    @Test
//    public void testDifferentClassEquality(){
//        assertTrue(new Money(10,"CHF").equals(
//                new Franc(10,"CHF")));
//    }

    @Test
    public void testReduceSum() throws Exception {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void testReduceMoney() throws Exception {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testIdentityRate() throws Exception {
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    public void testMixedAddition() throws Exception {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFranc = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(
                fiveBucks.plus(tenFranc), "USD");
        assertEquals(Money.dollar(10), result);
    }

    @Test
    public void testSumPlusMoney() throws Exception {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(15),result);
    }

    @Test
    public void testSumTimes() throws Exception {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank =new Bank();
        bank.addRate("CHF","USD",2);
        Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20),result);
    }

}
