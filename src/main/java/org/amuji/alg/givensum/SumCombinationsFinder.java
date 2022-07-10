package org.amuji.alg.givensum;

import java.util.*;

public class SumCombinationsFinder {
    private final Integer target;
    private final Set<List<Integer>> combinations = new HashSet<>();

    public SumCombinationsFinder(Integer target, List<Integer> givenNumbers) {
        this.target = target;
        subset(givenNumbers, new ArrayList<>());
    }

    private void subset(List<Integer> nums,  List<Integer> partial) {
        Integer s = partial.stream().reduce(0, Integer::sum);

        if (Objects.equals(s, target)) {
            combinations.add(partial);
        }

        if (s >= target) {
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            Integer n = nums.get(i);
            List<Integer> remaining = nums.subList(i + 1, nums.size());
            ArrayList<Integer> p = new ArrayList<>(partial);
            p.add(n);
            subset(remaining, p);
        }
    }

    public Set<List<Integer>> getCombinations() {
        return combinations;
    }
}
