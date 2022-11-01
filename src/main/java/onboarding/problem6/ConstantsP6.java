package onboarding.problem6;

import java.util.regex.Pattern;

public class ConstantsP6 {
    public static final int MIN_CREW_NUMBER = 1;
    public static final int MAX_CREW_NUMBER = 10000;

    public static final int MIN_EMAIL_LENGTH = 11;
    public static final int MAX_EMAIL_LENGTH = 20 - 1;

    public static final Pattern KOREAN = Pattern.compile("^[ㄱ-ㅎㅏ-ㅣ가-힣]*$");
    public static final int MIN_NICKNAME_LENGTH = 1;
    public static final int MAX_NICKNAME_LENGTH = 20 - 1;

    private ConstantsP6() {
    }
}
