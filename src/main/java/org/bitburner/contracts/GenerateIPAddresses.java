package org.bitburner.contracts;

import java.util.Arrays;

public class GenerateIPAddresses {
    public static String[] generateIPAddresses(String digits, int index) {
        /* Stopping Conditions */
        int lastDotIndex = digits.lastIndexOf(".");
        int numOfDotOccurrences = (int) (digits.chars().filter(ch -> ch == '.').count());

        String digitsWithADot = "";
        if (lastDotIndex != index - 1)
            digitsWithADot = digits.substring(0, index) + "." + digits.substring(index);

        if (index > digits.length() - 1) {
            if (numOfDotOccurrences < 3 || Integer.parseInt(digits.substring(lastDotIndex + 1)) > 255)
                return new String[]{};
            return new String[]{digits};
        }

        if (numOfDotOccurrences == 3) {
            if (digits.charAt(lastDotIndex + 1) == '0')
                return new String[]{};

            return generateIPAddresses(digits, index + 1);
        }

        if (Integer.parseInt(digits.substring(lastDotIndex + 1, index + 1)) > 255) {
            return generateIPAddresses(digitsWithADot, index + 1);
        }

        /* The Actual Recursion */
        String[] firstOption = generateIPAddresses(digits, index + 1);
        if (index == 0 || digitsWithADot.isEmpty())
            return firstOption;

        String[] secondOption = generateIPAddresses(digitsWithADot, index + 1);
        if (digits.charAt(index - 1) == '0')
            return secondOption;

        String[] bothOptions = new String[firstOption.length + secondOption.length];
        System.arraycopy(firstOption, 0, bothOptions, 0, firstOption.length);
        System.arraycopy(secondOption, 0, bothOptions, firstOption.length, secondOption.length);

        return bothOptions;
    }
}
