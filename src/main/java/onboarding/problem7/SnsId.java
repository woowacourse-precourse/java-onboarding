package onboarding.problem7;

import onboarding.problem7.exception.UserInputException;

import java.util.Objects;
import java.util.regex.Pattern;

public class SnsId {
    private static final Pattern ID_RANGE = Pattern.compile("^[a-z]{1,30}$");
    private final String user;

    public SnsId(String user) {
        checkInput(user);
        this.user = user;
    }

    private static void checkInput(String user) {
        if (!ID_RANGE.matcher(user).matches()){
             throw new UserInputException("아이디는 영어 소문자로 1자 이상 30자 이하여야 합니다.");
        }
    }

    public String getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SnsId snsId = (SnsId) o;
        return Objects.equals(user, snsId.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
