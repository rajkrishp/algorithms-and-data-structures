package com.raj.algorithms.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void basicCase() {
        int[] result = TwoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    void duplicateValuesCase() {
        int[] result = TwoSum.twoSum(new int[]{3, 3}, 6);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    void negativeNumbersCase() {
        int[] result = TwoSum.twoSum(new int[]{-1, -2, -3, -4, -5}, -8);
        assertArrayEquals(new int[]{2, 4}, result);
    }

    @Test
    void noSolutionThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> TwoSum.twoSum(new int[]{1, 2, 3}, 100));
    }

    @Test
    void nullArrayThrows() {
        assertThrows(NullPointerException.class,
                () -> TwoSum.twoSum(null, 10));
    }
}
