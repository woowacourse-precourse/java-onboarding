package onboarding.problem6;

public class Crew {

    private static final String EMAIL_FORMAT = "@email.com";

    private String nickName;
    private String email;

    public Crew(String nickName, String email) {
        this.nickName = nickName;
        this.email = email;
    }

    public static Crew of(String nickName, String email) {
        validateEmail(email);
        return new Crew(nickName, email);
    }

    private static void validateEmail(String email) {
        if (!email.contains(EMAIL_FORMAT)) {
            throw new IllegalArgumentException("이메일은 이메일 형식이어야 하고 도메인은 email.com 이어야 합니다.");
        }
        if (email.length() < 11 || email.length() >= 20) {
            throw new IllegalArgumentException("이메일의 전체 길이는 11자 이상 20자 미만이어야 합니다.");
        }
    }
}
