package org.bitburner.contracts;

public class AlgorithmicStockTrader1 {
    public static int findBiggestGap(int[] numbers) {
        int gap = 0;
        for (int i = 1; i < numbers.length; i++) {
            int currentNumber = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int comparedNumber = numbers[j];
                if (comparedNumber - currentNumber > gap) {
                    gap = comparedNumber - currentNumber;
                }
            }
        }

        return gap;
    }
}
