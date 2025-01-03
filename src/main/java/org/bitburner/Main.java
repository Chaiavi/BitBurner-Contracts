package org.bitburner;

import org.bitburner.contracts.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String digits = "115322151";
        System.out.println(Arrays.toString(GenerateIPAddresses.generateIPAddresses(digits, 0)));
    }
}