package org.bitburner.contracts;

import java.util.ArrayList;
import java.util.List;

public class BiggestPrimalFactor {
    public static int findBiggestPrimalFactor(int givenNumber) {
        List<Integer> primalFactors = new ArrayList<>();
        List<Integer> primalNumbers = findPrimalNumbersTill((int) Math.sqrt(givenNumber));
        System.out.println("Found " + primalNumbers.size() + " Primal numbers till " + givenNumber);

        while (givenNumber > 1) {
            int primalFactor = getFirstPrimalFactor(givenNumber, primalNumbers);
            primalFactors.add(primalFactor);
            givenNumber /= primalFactor;
            System.out.println("First Primal Number is: " + primalFactor + " (Continuing with " + givenNumber + ")");
        }

        int biggestPrimalFactor = Integer.MIN_VALUE;
        for (int currentFactor: primalFactors) {
            if (currentFactor > biggestPrimalFactor)
                biggestPrimalFactor = currentFactor;
        }

        return biggestPrimalFactor;
    }

    private static int getFirstPrimalFactor(int givenNumber, List<Integer> primalNumbers) {
        for (int primalNumber : primalNumbers)
            if (givenNumber % primalNumber == 0)
                return primalNumber;

        return Integer.MAX_VALUE;
    }

    public static List<Integer> findPrimalNumbersTill(int givenNumber) {
        List<Integer> primalNumbers = new ArrayList<>();

        for (int currentNumber = 2; currentNumber <= givenNumber; currentNumber++) {
            boolean isPrimal = true;

            for (int divider = 2; divider <= Math.sqrt(currentNumber); divider++) {
                if (currentNumber % divider == 0) {
                    isPrimal = false;
                    break;
                }
            }

            if (isPrimal)
                primalNumbers.add(currentNumber);
        }

        return primalNumbers;
    }
}
