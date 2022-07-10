package org.amuji.alg.givensum;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class SumCombinationsFinderTest {
    @Test
    void test() {
        List<Integer> givenNumbers = Lists.newArrayList(
                9,
                8,
                10,
                1,
                4,
                5,
                7,
                3,
                2,
                6
        );
        SumCombinationsFinder finder = new SumCombinationsFinder(16, givenNumbers);

        Set<List<Integer>> combinations = finder.getCombinations();
        assertThat(combinations.size(), equalTo(22));
        combinations.forEach(System.out::println);
    }
}