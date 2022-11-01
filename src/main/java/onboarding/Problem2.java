package onboarding;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem2 {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final String LOWER_ALPHABET_REGEX = "^[a-z]{1,1000}$";

    public static String solution(String cryptogram) {
        validateInput(cryptogram);
        return computeDuplicateRemovedStr(cryptogram);
    }

    private static void validateInput(String input) {
        if (!isValidCryptogramForm(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidCryptogramForm(String input) {
        return Pattern.matches(LOWER_ALPHABET_REGEX, input);
    }

    private static String computeDuplicateRemovedStr(String str) {
        int beforeRemoveSize;

        do
        {
            beforeRemoveSize = str.length();
            str = duplicateRemove(str);
        } while (beforeRemoveSize != str.length() && str.length() != ONE);
        return str;
    }

    static String duplicateRemove(String str) {
        return IntStream.range(ZERO, str.length())
            .filter(i -> isNotDuplicatedWord(str, i))
            .mapToObj(i -> String.valueOf(str.charAt(i)))
            .collect(Collectors.joining());
    }

    private static boolean isNotDuplicatedWord(String str, int i) {
        return isNotDuplicatedFirstWord(str, i) || isNotDuplicatedMiddleWord(str, i) || isNotDuplicatedLastWord(str, i);
    }

    private static boolean isNotDuplicatedFirstWord(String str, int i) {
        return i == ZERO && str.length() >= TWO && str.charAt(ZERO) != str.charAt(ONE);
    }

    private static boolean isNotDuplicatedLastWord(String str, int i) {
        return i == str.length() - ONE && str.length() >= TWO && str.charAt(str.length() - ONE) != str.charAt(str.length() - TWO);
    }

    private static boolean isNotDuplicatedMiddleWord(String str, int i) {
        return i != ZERO && i != str.length() - ONE && str.charAt(i) != str.charAt(i - ONE) && str.charAt(i) != str.charAt(i + ONE);
    }
}