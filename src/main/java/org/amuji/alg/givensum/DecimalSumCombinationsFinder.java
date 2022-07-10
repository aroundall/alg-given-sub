package org.amuji.alg.givensum;

import java.math.BigDecimal;
import java.util.*;

public class DecimalSumCombinationsFinder {
    private final BigDecimal target;
    private final Set<List<BigDecimal>> combinations = new HashSet<>();

    public DecimalSumCombinationsFinder(BigDecimal target, List<BigDecimal> givenNumbers) {
        this.target = target;
        subset(givenNumbers, new ArrayList<>());
    }

    private void subset(List<BigDecimal> nums,  List<BigDecimal> partial) {
        BigDecimal s = partial.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        if (s.compareTo(target) == 0) {
            combinations.add(partial);
        }

        if (s.compareTo(target) > 0) {
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            BigDecimal n = nums.get(i);
            List<BigDecimal> remaining = nums.subList(i + 1, nums.size());
            ArrayList<BigDecimal> p = new ArrayList<>(partial);
            p.add(n);
            subset(remaining, p);
        }
    }

    public Set<List<BigDecimal>> getCombinations() {
        return combinations;
    }
}
