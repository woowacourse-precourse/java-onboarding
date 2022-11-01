package onboarding.problem2;

import java.util.regex.Pattern;

public class ConstantsP2 {
    public static final int CIPHER_MIN_LENGTH = 1;
    public static final int CIPHER_MAX_LENGTH = 1000;
    public static final Pattern INPUT_PATTERN = Pattern.compile("^[a-z]*$");

    private ConstantsP2() {
    }
}
