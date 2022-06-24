package com.terzeron.functional;

import java.util.List;

class Counter {
    public int varField;

    Counter(int var) {
        varField = var;
    }

    public static Counter makeCounter() {
        return new Counter(0);
    }

    public int execute() {
        return ++varField;
    }

    public String toString() {
        return Integer.toString(varField);
    }

    public static void main(String[] args) {
        Counter c1 = new Counter(0);
        Counter c2 = new Counter(0);

        c1.execute();
        c1.execute();

        c2.execute();

        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);
    }
}