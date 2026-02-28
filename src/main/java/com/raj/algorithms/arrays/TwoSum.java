package com.raj.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Utility class for solving the classic Two Sum problem.
 *
 * <p>Problem statement:</p>
 * <p>Given an integer array {@code nums} and an integer {@code target}, return indices of the two
 * numbers such that they add up to {@code target}. Exactly one valid answer is assumed.</p>
 *
 * <p>Approach used: one-pass hash map ({@code value -> index})</p>
 * <ul>
 *   <li>Time complexity: O(n)</li>
 *   <li>Space complexity: O(n)</li>
 * </ul>
 */
public final class TwoSum {

    private TwoSum() {
        // Utility class; prevent instantiation.
    }

    /**
     * Returns indices of two numbers whose sum equals the target.
     *
     * @param nums   input array (must not be null)
     * @param target target sum
     * @return array of size 2 with indices [i, j]
     * @throws NullPointerException     if nums is null
     * @throws IllegalArgumentException if no two-sum pair exists
     */
    public static int[] twoSum(int[] nums, int target) {
        Objects.requireNonNull(nums, "nums must not be null");

        Map<Integer, Integer> indexByValue = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int needed = target - current;

            if (indexByValue.containsKey(needed)) {
                return new int[]{indexByValue.get(needed), i};
            }

            indexByValue.put(current, i);
        }

        throw new IllegalArgumentException("No valid two-sum pair found for target: " + target);
    }
}
