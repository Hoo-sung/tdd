package com.tdd.tdd_practice;

public class Franc extends Money{

    public Franc(int amount) {
        super(amount);
    }

    @Override
    Money times(int multiplier) {
        return new Franc(amount*multiplier);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
