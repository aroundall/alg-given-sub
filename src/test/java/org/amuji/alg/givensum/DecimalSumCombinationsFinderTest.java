package org.amuji.alg.givensum;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class DecimalSumCombinationsFinderTest {
    @Test
    void has_decimals() {
        List<BigDecimal> givenNumbers = Lists.newArrayList(
                new BigDecimal("9.050"),
                new BigDecimal("8.00"),
                new BigDecimal("1.00"),
                new BigDecimal("10.00"),
                new BigDecimal("4.00"),
                new BigDecimal("5.00"),
                new BigDecimal("7.10"),
                new BigDecimal("3.00"),
                new BigDecimal("2.00"),
                new BigDecimal("6.00")
        );
        DecimalSumCombinationsFinder finder = new DecimalSumCombinationsFinder(new BigDecimal("16.15"), givenNumbers);

        Set<List<BigDecimal>> combinations = finder.getCombinations();

        assertThat(combinations.size(),equalTo(1));
        combinations.forEach(System.out::println);
    }

    @Test
    void without_decimals() {
        List<BigDecimal> givenNumbers = Lists.newArrayList(
                new BigDecimal("9.000"),
                new BigDecimal("8.00"),
                new BigDecimal("1.00"),
                new BigDecimal("10.00"),
                new BigDecimal("4.00"),
                new BigDecimal("5.00"),
                new BigDecimal("7.00"),
                new BigDecimal("3.00"),
                new BigDecimal("2.00"),
                new BigDecimal("6.00")
        );
        DecimalSumCombinationsFinder finder = new DecimalSumCombinationsFinder(new BigDecimal("16.00"), givenNumbers);

        Set<List<BigDecimal>> combinations = finder.getCombinations();

        assertThat(combinations.size(),equalTo(22));
        combinations.forEach(System.out::println);
    }

}
