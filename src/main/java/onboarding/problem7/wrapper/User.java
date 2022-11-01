package onboarding.problem7.wrapper;

public class User {
    private final String userId;
    public User(String userId) {
        validateUserIdLength(userId);
        validateUserIdForm(userId);
        this.userId = userId;
    }

    private void validateUserIdForm(String userId) {
        String regularExpressionOfLowerCase = "[a-z]+";
        if (!userId.matches(regularExpressionOfLowerCase)) {
            throw new IllegalArgumentException("userId는 소문자만 가능합니다.");
        }
    }

    private void validateUserIdLength(String userId) {
        int userIdLength = userId.length();
        if (userIdLength > 30 || userIdLength < 1) {
            throw new IllegalArgumentException("userId의 길이는 1이상 30이하여야 합니다.");
        }
    }
}
