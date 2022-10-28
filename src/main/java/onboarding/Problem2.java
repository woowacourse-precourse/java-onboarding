package onboarding;

public class Problem2 {

    public static final String REPEATING_MORE_THAN_ONCE_REGEX = "(.)\\1+";

    public static String solution(String cryptogram) {
        return removeDuplicated(cryptogram);
    }

    public static String removeDuplicated(String target) {
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
