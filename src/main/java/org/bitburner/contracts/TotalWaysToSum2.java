package org.bitburner.contracts;

import java.util.Arrays;

/** Contract Solution of Total Ways to Sum II */
public class TotalWaysToSum2 {
    public static int totalWaysToSum2(int[] numbers, int requiredSum) {
        numbers = Arrays.stream(numbers).filter(num -> num <= requiredSum).toArray(); // Removes all numbers which are bigger than requiredSum // Stopping Condition #1
        if (requiredSum == 0) return 1; // Stopping Condition #2
        if (numbers.length == 0) return 0; // Stopping Condition #3
        if (numbers.length == 1)
            if (requiredSum % numbers[0] == 0) return 1; // Stopping Condition #4
            else return 0;

        return totalWaysToSum2(numbers, requiredSum - numbers[0]) + totalWaysToSum2(Arrays.stream(numbers, 1, numbers.length).toArray(), requiredSum);
    }
}
