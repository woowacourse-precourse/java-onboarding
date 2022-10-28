package onboarding.problem6;

import java.util.regex.Pattern;

public class CrewValidator {

    private static final String EMAIL_FORMAT = "@email.com";
    private static final String KOREAN_REGEX = "^[가-힣]*$";

    private static final Integer NICKNAME_MINIMUM_LENGTH = 1;
    private static final Integer NICKNAME_MAXIMUM_LENGTH = 20;

    private static final Integer EMAIL_MINIMUM_LENGTH = 11;
    private static final Integer EMAIL_MAXIMUM_LENGTH = 20;


    public static void validateNickName(String nickName) {
        if (!Pattern.matches(KOREAN_REGEX, nickName)) {
            throw new IllegalArgumentException("닉네임은 한글만 가능합니다.");
        }
        if (nickName.length() < NICKNAME_MINIMUM_LENGTH || nickName.length() >= NICKNAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("닉네임의 전체 길이는 1자 이상 20자 미만입니다.");
        }
    }

    public static void validateEmail(String email) {
        if (!email.contains(EMAIL_FORMAT)) {
            throw new IllegalArgumentException("이메일은 이메일 형식이어야 하고 도메인은 email.com 이어야 합니다.");
        }
        if (email.length() < EMAIL_MINIMUM_LENGTH|| email.length() >= EMAIL_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("이메일의 전체 길이는 11자 이상 20자 미만이어야 합니다.");
        }
    }
}
