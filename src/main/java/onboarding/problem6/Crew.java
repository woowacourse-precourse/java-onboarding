package onboarding.problem6;

public class Crew {

    private final String email;
    private final String nickname;

    public Crew(String email, String nickname) {
        validateEmail(email);
        validateNickname(nickname);

        this.email = email;
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    private void validateEmail(String email) throws IllegalArgumentException {
        if (!(11<=email.length() && email.length()<20)) {
            throw new IllegalArgumentException("email 길이는 11자 이상 20자 미만이여야 합니다.");
        }

        if (!email.matches("^(.+)@email\\.com$")) {
            throw new IllegalArgumentException("email은 도메인 \"email.com\"을 가진 이메일 형식이여야 합니다.");
        }
    }

    private void validateNickname(String nickname) throws IllegalArgumentException {
        if (!(1<=nickname.length() && nickname.length()<20)) {
            throw new IllegalArgumentException("닉네임의 길이는 1이상 20자 미만이여야 합니다.");
        }

        if (!nickname.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]+$")) {
            throw new IllegalArgumentException("nickname은 한글만 주어져야 합니다.");
        }
    }
}
