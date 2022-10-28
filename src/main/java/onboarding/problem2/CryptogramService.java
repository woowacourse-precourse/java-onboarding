package onboarding.problem2;

public class CryptogramService {
    public static final String REPEATING_MORE_THAN_ONCE_REGEX = "(.)\\1+";

    public static String decodeCryptogram(String cryptogram) {
        cryptogram = removeSpacing(cryptogram);
        return removeDuplicated(cryptogram);
    }

    private static String removeSpacing(String target) {
        return target.replaceAll(" ", "");
    }

    private static String removeDuplicated(String target) {
        String result = target.replaceAll(REPEATING_MORE_THAN_ONCE_REGEX, "");
        if (isWordLengthChanged(target, result)) {
            result = removeDuplicated(result);
        }
        return result;
    }

    private static boolean isWordLengthChanged(String target, String result) {
        return !target.equals(result);
    }
}
