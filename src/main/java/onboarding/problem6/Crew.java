package onboarding.problem6;

import java.util.List;
import java.util.regex.Pattern;

public class Crew {

    private static final String EMAIL_FORMAT = "@email.com";
    private static final String KOREAN_REGEX = "^[가-힣]*$";

    private String email;
    private String nickName;

    public Crew(String nickName, String email) {
        this.nickName = nickName;
        this.email = email;
    }

    public static Crew create(List<String> form) {
        final String email = form.get(0);
        final String nickName = form.get(1);

        validateEmail(email);
        validateNickName(nickName);
        return new Crew(nickName, email);
    }

    private static void validateNickName(String nickName) {
        if (!Pattern.matches(KOREAN_REGEX, nickName)) {
            throw new IllegalArgumentException("닉네임은 한글만 가능합니다.");
        }
        if (nickName.length() < 1 || nickName.length() >= 20) {
            throw new IllegalArgumentException("닉네임의 전체 길이는 1자 이상 20자 미만입니다.");
        }
    }

    private static void validateEmail(String email) {
        if (!email.contains(EMAIL_FORMAT)) {
            throw new IllegalArgumentException("이메일은 이메일 형식이어야 하고 도메인은 email.com 이어야 합니다.");
        }
        if (email.length() < 11 || email.length() >= 20) {
            throw new IllegalArgumentException("이메일의 전체 길이는 11자 이상 20자 미만이어야 합니다.");
        }
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmail() {
        return email;
    }
}
