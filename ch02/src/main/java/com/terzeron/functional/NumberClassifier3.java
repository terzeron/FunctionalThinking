package com.terzeron.functional;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class NumberClassifier3 {
    public static IntStream factorsOf(int number) {
        return range(1, number + 1)
                .filter(potential -> number % potential == 0);
    }

    public static int aliquotSum(int number) {
        return factorsOf(number).sum() - number;
    }

    public static boolean isPerfect(int number) {
        return aliquotSum(number) == number;
    }

    public static boolean isAbundant(int number) {
        return aliquotSum(number) > number;
    }

    public static boolean isDeficient(int number) {
        return aliquotSum(number) < number;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10000; i++) {
            NumberClassifier1 classifier = new NumberClassifier1(i);
            if (classifier.isPerfect()) {
                System.out.println(i);
            }
        }
    }
}
