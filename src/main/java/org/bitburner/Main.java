package org.bitburner;

import org.bitburner.contracts.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Started Main");
        String encryptedText = "PRINT SHIFT ARRAY INBOX QUEUE";
        int shiftLeft = 21;
        System.out.println(Encryption1CaesarCipher.generateCaesarCipher(encryptedText, shiftLeft));
    }
}