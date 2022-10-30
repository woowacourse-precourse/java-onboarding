package onboarding.problem6.domain;

public class Email {

    private static final String AT_SIGN = "@";

    private final String email;

    private final String domain;

    public Email(String email) {
        if (!email.contains(AT_SIGN)) {
            throw new RuntimeException("이메일 형식이 잘못되었습니다.");
        }
        String[] emailAndDomain = email.split(AT_SIGN);
        this.email = emailAndDomain[0];
        this.domain = emailAndDomain[1];
    }
}
