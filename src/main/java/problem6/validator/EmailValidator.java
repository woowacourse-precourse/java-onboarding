package problem6.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    private final List<String> emails;
    private final String REGEX = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
    private final String DOMAIN = "email.com";

    public EmailValidator(Map<String, String> forms) {
        this.emails = new ArrayList<>(forms.keySet());
    }

    public void validate(int inputSize) {
        validateDuplicateEmail(inputSize);
        for (String email : emails) {
            validateEmailPattern(email);
            validateEmailLength(email);
            validateEmailDomain(email);
        }
    }

    public void validateDuplicateEmail(int inputSize) {
        if (emails.size() != inputSize) {
            throw new IllegalArgumentException("중복된 이메일이 존재합니다.");
        }
    }

    private void validateEmailPattern(String email) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("올바르지 않은 이메일 형식입니다.");
        }
    }

    private void validateEmailLength(String email) {
        if (!isValidEmailLength(email)) {
            throw new IllegalArgumentException("11 이상 20 미만 길이의 이메일만 입력 가능합니다.");
        }
    }

    private boolean isValidEmailLength(String email) {
        int length = email.length();
        return (length >= 11) && (length < 20);
    }

    private void validateEmailDomain(String email) {
        if (!isValidEmailDomain(email)) {
            throw new IllegalArgumentException("올바르지 않은 이메일 도메인입니다.");
        }
    }

    private boolean isValidEmailDomain(String email) {
        String emailDomain = email.split("@")[1];
        return emailDomain.equals(DOMAIN);
    }
}
