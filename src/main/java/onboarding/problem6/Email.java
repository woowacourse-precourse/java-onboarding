package onboarding.problem6;

import java.util.Objects;
import java.util.regex.Pattern;

public class Email {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-\\.]+@([email]+\\.)+[com]{2,4}$$");
    private static final int MIN = 11;
    private static final int MAX = 19;
    private final String email;

    public Email(String email) {
        checkEmail(email);
        this.email = email;
    }

    private static void checkEmail(String email) {
        checkMin(email);
        checkMax(email);
        validateFormat(email);
    }

    private static void checkMax(String email) {
        if (email.length() > MAX) {
            throw new EmailException("이메일에 최대로 입력할 수 있는 수는 19자 입니다.");
        }
    }

    private static void checkMin(String email) {
        if (email.length() < MIN) {
            throw new EmailException("이메일은 최소 11자가 되어야 합니다.");
        }
    }

    private static void validateFormat(String email) {
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new EmailException("이메일이 형식에 맞지 않습니다. 사용 가능항 도메인은 email.com 뿐입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    public String getEmail() {
        return email;
    }


}
