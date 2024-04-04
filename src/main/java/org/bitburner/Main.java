package org.bitburner;

import org.bitburner.contracts.AlgorithmicStockTrader1;
import org.bitburner.contracts.UniquePathsInAGrid1;

public class Main {
    public static void main(String[] args) {
//        int[] numbers = {1,4,5,6,9,10,13,15,16,17,18,19};
//        int requiredSum = 80;
//        System.out.println(TotalWaysToSum2.totalWaysToSum2(numbers, requiredSum));

//        Stopwatch stopwatch = new Stopwatch();
//        System.out.println(BiggestPrimalFactor.findBiggestPrimalFactor(293668864));
//        System.out.println(stopwatch.getElapsedTime());

//        int[] numbers = {85,179,47,91,29,168,47,78,66,101,105,120,14,105,143,175,40,170,71,49,105,98,68,193,174,108,1,132,142,142,173,182,195,156,108,130,168};
//        System.out.println(AlgorithmicStockTrader1.findBiggestGap(numbers));

        int rows = 13;
        int columns = 9;
        System.out.println("The number of ways to get to target is: " + UniquePathsInAGrid1.getNumOfWaysToGetToTarget(rows, columns));
    }
}