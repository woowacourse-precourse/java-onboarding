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

    /**
     * Method for treating single duplication
     * @param index index of current index
     */
    private void treatDuplication(int index) {
        from = index;
        duplicate = true;
        if (index == 0) {
            builder.delete(from, to);
            length = 0;
        }
    }

    /***
     * Method for treating single non-duplication
     * @param index current index
     */
    private void treatNonDuplication(int index) {
        if (duplicate) {
            builder.delete(from, to);
            duplicate = false;
        }
        now = next;
        to = index + 1;
    }
}
