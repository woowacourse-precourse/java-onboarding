package onboarding.problem4;

public class BlueFrogValidator {
    public static final String INVALID_STRING_LENGTH_MASSAGE_FORMAT = "문자열은 %d 이상 %d 이하의 길이로 주어져야 합니다.";

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 1000;

    public static void validate(String target) {
        isWordLengthBetween(target, MIN_LENGTH, MAX_LENGTH);
    }

    private static void isWordLengthBetween(String target, int min, int max) {
        if (target.length() < min || max < target.length()) {
            throw new IllegalArgumentException(String.format(INVALID_STRING_LENGTH_MASSAGE_FORMAT, min, max));
        }
    }
}
