package onboarding.problem6.utils;

public class Constants {
    public static final int CERW_EMAIL = 0;
    public static final int CREW_NICNAME = 1;

    public static final int MAX_CREW_NUMBER = 1000;

    public static final int MIN_CREW_NUMBER = 1;

    public static final int DOMAIN_POSITION = 10;

    public static final int MIN_NICKNAME_LENGTH = 0;

    public static final int MAX_NICKNAME_LENGTH = 20;

    public static final int MIN_EMAIL_LENGTH = 10;

    public static final int MAX_EMAIL_LENGTH = 20;

    public static final int LEAST_DUPLICATED_WORD_LENGTH = 2;

    public static final String DOMAIN = "@email.com";

    public static final String HANGUL_REGEX = "^[ㄱ-ㅎ가-힣]*$";

    public static final String EMAIL_REGEX = "[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\\\w+\\\\.)+\\\\w+$";
}
