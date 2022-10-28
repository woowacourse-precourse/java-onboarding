package onboarding.problem4;

/**
 * Class that reverses alphabets
 */
public class StringReverser {

    private final StringBuilder builder;

    /**
     * Constructor with string
     *
     * @param string string wanted to by reversed
     */
    public StringReverser(String string) {
        builder = new StringBuilder(string);
    }
}
