package onboarding.problem2;

import java.util.Stack;

/**
 * Decoder for decoding cryptogram
 */
public class Decoder {

    private final String CIPHERTEXT;

    /**
     * Constructor with cryptogram string
     *
     * @param cryptogram encrypt text
     */
    public Decoder(String cryptogram) {
        CIPHERTEXT = cryptogram;
    }

    /**
     * Decode the encrypted text to plain text
     *
     * @return plain text
     */
    public String decode() {
        Stack<Character> plainStack = new Stack<>();
        plainStack.push(CIPHERTEXT.charAt(0));
        // Treat duplication and create plain stack
        // Build plain text with stack
        return "";
    }
}
