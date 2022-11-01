package onboarding;

import java.util.List;

public abstract class Validation {
    private static final String LOWER_ALPHABET_REGEX = "^[a-z]*$";
    private static final String EMAIL_FORM_REGEX = "^(.+)@(.+)$";
    private static final String NICKNAME_FORM_REGEX = "^[가-힣]*$";

    private static final String EMAIL_DOMAIN = "email.com";
    private static final int MIN_EMAIL_LENGTH = 11;
    private static final int MAX_EMAIL_LENGTH = 19;

    private static final int MIN_NICKNAME_LENGTH = 1;
    private static final int MAX_NICKNAME_LENGTH = 19;

    public static boolean validateNotNull(Object object) {
        return object != null;
    }

    public static boolean validateListSize(List list, int size) {
        return list.size() == size;
    }

    public static boolean validateIntegerRange(int integer, int minValue, int maxValue) {
        return integer >= minValue
                && integer <= maxValue;
    }
    public static boolean validateStringLengthRange(String string, int minLength, int maxLength) {
        return string.length() >= minLength
                && string.length() <= maxLength;
    }

    public static boolean validateListSizeRange(List list, int minSize, int maxSize) {
        return list.size() >= minSize
                && list.size() <= maxSize;
    }

    public static boolean validateLowerAlphabet(String string) {
        return string.matches(LOWER_ALPHABET_REGEX);
    }

    public static boolean validateEmailForm(List<List<String>> forms) {
        for (List<String> form : forms) {
            String email = form.get(0);

            if (!email.matches(EMAIL_FORM_REGEX)) {
                return false;
            }
            if (email.length() <= MIN_EMAIL_LENGTH || email.length() >= MAX_EMAIL_LENGTH) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateEmailDomain(List<List<String>> forms) {
        for (List<String> form : forms) {
            String email = form.get(0);

            if (!email.endsWith(EMAIL_DOMAIN)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateNicknameForm(List<List<String>> forms) {
        for (List<String> form : forms) {
            String nickname = form.get(1);

            if (!nickname.matches(NICKNAME_FORM_REGEX)) {
                return false;
            }
            if (nickname.length() <= MIN_NICKNAME_LENGTH || nickname.length() >= MAX_NICKNAME_LENGTH) {
                return false;
            }
        }
        return true;
    }
}
