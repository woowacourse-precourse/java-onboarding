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
     * Decoding message
     * @return decoded message
     */
    public String decode() {
        do {
            length = to = builder.length();
            duplicate = false;

            now = builder.charAt(length - 1);
            for (int index = length - 2; index >= 0; index--) {
                next = builder.charAt(index);
                checkDuplication(index);
            }

        } while (length != builder.length());

        return builder.toString();
    }

    /**
     * Check if there is duplication
     * @param index current index
     */
    private void checkDuplication(int index) {
        if (now == next) treatDuplication(index);
        else treatNonDuplication(index);
    }

    /**
     * Method for treating single duplication
     * @param index current index
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
