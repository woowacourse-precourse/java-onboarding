package onboarding.problem2;

public class CryptogramValidation {

    public static boolean isValidCryptogram(String cryptogram) {
        return isValidLength(cryptogram) || isOnlyContainsLowerCase(cryptogram);
    }

    private static boolean isValidLength(String cryptogram) {
        final int MAX_VALUE = 1000;
        final int MIN_VALUE = 1;
        int length = cryptogram.length();

        return MIN_VALUE <= length && length <= MAX_VALUE;

    }

    private static boolean isOnlyContainsLowerCase(String cryptogram) {
        return cryptogram.matches("^[a-z]*$");  // 소문자만 있을 때 true를 반환하는 정규식이라고 한다.
    }
}
