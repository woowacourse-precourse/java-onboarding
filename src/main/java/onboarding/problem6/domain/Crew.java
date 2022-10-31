package onboarding.problem6.domain;

public class Crew {

    private String email;
    private String nickname;

    public Crew(String email, String nickname) {
        validateNicknameLanguage(nickname);
        validateNicknameLength(nickname);
        validateEmailForm(email);
        validateEmailLength(email);

        this.email = email;
        this.nickname = nickname;
    }

    private void validateNicknameLanguage(String nickname) {
        String regularExpressionOfKorean = "^[가-힣]*$";
        if (!nickname.matches(regularExpressionOfKorean)) {
            throw new IllegalArgumentException("닉네임은 한글만 가능합니다.");
        }
    }

    private void validateNicknameLength(String nickname) {
        int nicknameLength = nickname.length();
        if (nicknameLength >= 20 || nicknameLength < 1) {
            throw new IllegalArgumentException("닉네임의 길이는 1자 이상 20자 미만이어야 합니다.");
        }
    }

    private void validateEmailLength(String email) {
        int emailLength = email.length();
        if (emailLength >= 20 || emailLength < 11){
            throw new IllegalArgumentException("이메일의 길이는 11자 이상 20자 미만이어야 합니다.");
        }
    }

    private void validateEmailForm(String email) {
        String regularExpressionOfEmailForm = "[\\w]+@email\\.com";
        if (!email.matches(regularExpressionOfEmailForm)) {
            throw new IllegalArgumentException("지원하지 않는 이메일 형식입니다.");
        }
    }
}
