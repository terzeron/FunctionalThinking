package com.terzeron.functional;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberClassifier1 {
    private int _number;
    private Map<Integer, Integer> _cache;

    public NumberClassifier1(int targetNumber) {
        _number = targetNumber;
        _cache = new HashMap<>();
    }

    public boolean isFactor(int potential) {
        return _number % potential == 0;
    }

    public Set<Integer> getFactors() {
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(_number);
        for (int i = 2; i < _number; i++) {
            if (isFactor(i)) {
                factors.add(i);
            }
        }
        return factors;
    }

    public int aliquotSum() {
        if (_cache.get(_number) == null) {
            int sum = 0;
            for (int i : getFactors()) {
                sum += i;
                _cache.put(_number, sum - _number);
            }
        }
        return _cache.get(_number);
    }

    public boolean isPerfect() {
        return aliquotSum() == _number;
    }

    public boolean isAbundant() {
        return aliquotSum() > _number;
    }

    public boolean isDeficient() {
        return aliquotSum() < _number;
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
