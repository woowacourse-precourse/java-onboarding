package onboarding.problem2;

/**
 * Decoder for decoding cryptogram
 */
public class Decoder {

    private final StringBuilder builder;

    private int length, from, to;
    private boolean duplicate;
    private char now, next;

    /**
     * Constructor with cryptogram
     * @param cryptogram cryptogram
     */
    public Decoder(String cryptogram) {
        builder = new StringBuilder(cryptogram);
    }
}
