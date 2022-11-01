package onboarding.problem7.wrapper;

import java.util.Objects;

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

    public String getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
