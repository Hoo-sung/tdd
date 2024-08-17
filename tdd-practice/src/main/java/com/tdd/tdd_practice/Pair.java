package com.tdd.tdd_practice;

import java.util.Objects;

public class Pair {
    private String from;
    private String to;

    public Pair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair pair = (Pair) obj;
        return Objects.equals(from, pair.from) && Objects.equals(to, pair.to);
    }

    @Override
    public int hashCode() {
        int result =  from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
    }
}
