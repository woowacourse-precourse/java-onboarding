package onboarding.problem2;

public class Cryptogram {

    private final String message;

    public Cryptogram(String message) {
        validateMessageRange(message);
        assertMessageContainsOnlyLowerAlpha(message);

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private void validateMessageRange(String message) throws IllegalArgumentException {
        if (!(1 <= message.length() && message.length() <= 1000)) {
            throw new IllegalArgumentException("message 의 길이는 1이상 1000이하 여야 합니다.");
        }
    }

    private void assertMessageContainsOnlyLowerAlpha(String message) throws IllegalArgumentException {
        for (char c : message.toCharArray()) {
            if (!Character.isAlphabetic(c) || !Character.isLowerCase(c)) {
                throw new IllegalArgumentException("message 은 모두 알파벳 소문자로 이루어져야 합니다.");
            }
        }
    }
}
