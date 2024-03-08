package org.bitburner;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1,4,5,6,9,10,13,15,16,17,18,19};
        int requiredSum = 80;

        System.out.println(totalWaysToSum2(numbers, requiredSum));
    }

    /** Contract Solution of Total Ways to Sum II */
    public static int totalWaysToSum2(int[] numbers, int rSum) {
        numbers = Arrays.stream(numbers).filter(num -> num <= rSum).toArray(); // Removes all numbers which are bigger than rSum // Stopping Condition #1
        if (rSum == 0) return 1; // Stopping Condition #2
        if (numbers.length == 0) return 0; // Stopping Condition #3
        if (numbers.length == 1)
            if (rSum % numbers[0] == 0) return 1; // Stopping Condition #4
            else return 0;

        return totalWaysToSum2(numbers, rSum - numbers[0]) + totalWaysToSum2(Arrays.stream(numbers, 1, numbers.length).toArray(), rSum);
    }
}