package org.bitburner;

import org.bitburner.contracts.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Started Main");
        int number = 822027495;
        System.out.println(BiggestPrimalFactor.findBiggestPrimalFactor(number));
    }
}