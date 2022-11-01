package onboarding.problem6;

import java.util.regex.Pattern;

public class Email {

    private final String email;

    public Email(String email) {
        validate(email);
        this.email = email;
    }

    private void validate(String email) {
        if (!isValideLength(email)) {
            throw new IllegalArgumentException("이메일 길이는 11자 이상 20자 미만이어야 합니다.");
        }
        if (!isValideEmailPattern(email)) {
            throw new IllegalArgumentException("이메일 형식이 맞지 않습니다.");
        }
        if (!isValideDomain(email)) {
            throw new IllegalArgumentException("지원하지 않는 도메인 입니다.");
        }
    }

    private boolean isValideLength(String email) {
        return (email.length() >= 11) && (email.length() < 20);
    }

    private boolean isValideEmailPattern(String email) {
        return Pattern.matches("\\b[\\w.-]+@[\\w.-]+\\.\\w{2,4}\\b", email);
    }

    private boolean isValideDomain(String email) {
        return email.substring(email.indexOf("@") + 1).equals("email.com");
    }

    public String getEmail() {
        return email;
    }
}
