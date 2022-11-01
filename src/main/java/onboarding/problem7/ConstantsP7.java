package onboarding.problem7;

import java.util.regex.Pattern;

public class ConstantsP7 {
    public static final Pattern USER_ID_PATTERN = Pattern.compile("^[a-z]*$");
    public static final int MIN_USER_ID_LENGTH = 1;
    public static final int MAX_USER_ID_LENGTH = 30;

    public static final int MIN_FRIENDS_LENGTH = 1;
    public static final int MAX_FRIENDS_LENGTH = 10000;

    public static final int MIN_VISITORS_LENGTH = 0;
    public static final int MAX_VISITORS_LENGTH = 10000;

    private ConstantsP7() {
    }
}
