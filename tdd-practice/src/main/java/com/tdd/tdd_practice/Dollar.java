package com.tdd.tdd_practice;

public class Dollar extends Money{

    public Dollar(int amount) {
        super(amount);
    }

    @Override
    Money times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
