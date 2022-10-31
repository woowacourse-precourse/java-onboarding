package onboarding.problem2;

public class CryptogramException {
    public static void checkException(String cryptogram) {
        int length = cryptogram.length();
        if (length < 1 || length > 1000) {
            throw new RuntimeException("길이는 1 이상 1000 이하여야 합니다.");
        }

        for (int i= 0; i < length; i++) {
            char letter = cryptogram.charAt(i);
            if (!Character.isLowerCase(letter)) {
                throw new RuntimeException("알파벳 소문자만 허용합니다.");
            }
        }
    }
}
