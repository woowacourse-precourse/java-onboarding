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
        treatDuplication(plainStack);
        // Build plain text with stack
        return "";
    }

    /**
     * Search continuous duplication and remove treat
     *
     * @param plainStack non duplicated character stack
     */
    private void treatDuplication(Stack<Character> plainStack) {
        boolean duplicate = false;
        for (int i = 1; i < CIPHERTEXT.length(); i++) {
            char c = CIPHERTEXT.charAt(i);

            if (plainStack.peek() == c) {
                duplicate = true;
            } else if (duplicate) {
                plainStack.pop();
                duplicate = false;
                i--;
            } else {
                plainStack.push(c);
            }
        }

        if (duplicate) {
            plainStack.pop();
        }
    }
}
