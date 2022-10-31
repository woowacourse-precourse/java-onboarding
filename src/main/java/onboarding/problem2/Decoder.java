package onboarding.problem2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Decoder for decoding cryptogram
 */
public class Decoder {

    private final String CIPHERTEXT;
    private final Queue<Character> text = new LinkedList<>();

    /**
     * Constructor with cryptogram string
     *
     * @param cryptogram encrypt text
     */
    public Decoder(String cryptogram) {
        CIPHERTEXT = cryptogram;
        for (int i = 0; i < CIPHERTEXT.length(); i++)
            text.add(CIPHERTEXT.charAt(i));
    }

    /**
     * Decode the encrypted text to plain text
     *
     * @return plain text
     */
    public String decode() {
        int size;
        do {
            size = text.size();
            treatDuplication(size);
        } while (size != text.size() && !text.isEmpty());
        return buildPlain();
    }

    /**
     * Search continuous duplication and remove
     */
    private void treatDuplication(int size) {
        boolean duplicated = false;

        for (int i = 0; i < size - 1; i++) {
            Character poll = text.poll();
            if (text.peek() == poll)
                duplicated = true;
            else if (duplicated)
                duplicated = false;
            else
                text.add(poll);
        }

        if (duplicated)
            text.poll();
        else
            text.add(text.poll());
    }

    /**
     * Building plain text from plain stack
     *
     * @return plain text
     */
    private String buildPlain() {
        StringBuilder plainBuilder = new StringBuilder();
        while (!text.isEmpty())
            plainBuilder.append(text.poll());
        return plainBuilder.toString();
    }
}
