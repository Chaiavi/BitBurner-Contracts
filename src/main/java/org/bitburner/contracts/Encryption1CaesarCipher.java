package org.bitburner.contracts;

public class Encryption1CaesarCipher {
    static final int CHARACTER_SPACE = 32;
    static final int CHARACTER_A = 65;
    static final int ALPHABET_LENGTH = 26;

    static public String generateCaesarCipher(String encryptedText, int shiftLeft) {
        String unencryptedText = "";
        for (char current : encryptedText.toCharArray()) {
            if (current != CHARACTER_SPACE) {
                char unencryptedChar = (char) (current - shiftLeft);
                if (unencryptedChar < CHARACTER_A) unencryptedChar += ALPHABET_LENGTH;
                unencryptedText += unencryptedChar;
            } else unencryptedText += " ";
        }
        return unencryptedText;
    }
}
