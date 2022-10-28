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

    /**
     * Reverses string
     *
     * @return reversed string
     */
    public String reverse() {
        for (int i = 0; i < builder.length(); i++) {
            char character = builder.charAt(i);
            if (Character.isUpperCase(character))
                builder.setCharAt(i, (char) (155 - character));
            else if (Character.isLowerCase(character))
                builder.setCharAt(i, (char) (219 - character));
        }
        return builder.toString();
    }
}
