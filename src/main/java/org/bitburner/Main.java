package org.bitburner;

import org.bitburner.contracts.BiggestPrimalFactor;

public class Main {
    public static void main(String[] args) {
//        int[] numbers = {1,4,5,6,9,10,13,15,16,17,18,19};
//        int requiredSum = 80;
//        System.out.println(TotalWaysToSum2.totalWaysToSum2(numbers, requiredSum));

        Stopwatch stopwatch = new Stopwatch();
        System.out.println(BiggestPrimalFactor.findBiggestPrimalFactor(293668864));
        System.out.println(stopwatch.getElapsedTime());
    }
}