package onboarding.problem7.validation;

public class IdValidation {
    private static final int MAX_ID_LENGTH = 30;
    private static final int MIN_ID_LENGTH = 1;

    public static boolean validateIDLengthInRange(String id) {
        return (id.length() >= MIN_ID_LENGTH) && (id.length() <= MAX_ID_LENGTH);
    }
}
