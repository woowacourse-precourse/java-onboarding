package onboarding.problem6;

public class Crew {

    private static final String EMAIL_REGEX = ".*(@email.com)$";
    private static final String NICKNAME_REGEX = "^([ㄱ-ㅎㅏ-ㅣ가-힣]).*";
    private static final int EMAIL_MAX_LENGTH = 19;
    private static final int EMAIL_MIN_LENGTH = 11;
    private static final int NICKNAME_MAX_LENGTH = 19;
    private static final int NICKNAME_MIN_LENGTH = 1;

    private final String email;
    private final String nickname;

    public Crew(String email, String nickname) {
        this.email = validateEmail(email);
        this.nickname = validateNickname(nickname);
    }

    private String validateEmail(String email) {
        if (!email.matches(EMAIL_REGEX)) {
            throw new RuntimeException("Email 형식이 올바르지 않습니다.");
        }
        if (email.length() < EMAIL_MIN_LENGTH || email.length() > EMAIL_MAX_LENGTH) {
            throw new RuntimeException("Email 은 11자 이상 20자 미만의 길이만 사용 가능합니다.");
        }
        return email;
    }

    private String validateNickname(String nickname) {
        if (!nickname.matches(NICKNAME_REGEX)) {
            throw new RuntimeException("Nickname 형식이 올바르지 않습니다.");
        }
        if (nickname.length() < NICKNAME_MIN_LENGTH || nickname.length() > NICKNAME_MAX_LENGTH) {
            throw new RuntimeException("Nickname 은 1자 이상 20자 미만의 길이만 사용 가능합니다.");
        }
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }
}
