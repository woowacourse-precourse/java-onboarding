package onboarding;

public class Member {
    private String name, email;

    public Member(String name, String email) {
        validNickname(name);
        validEmail(email);

        this.name = name;
        this.email = email;
    }

    private void validEmail(String email) {
        if (email.length() < 11 || email.length() > 20)
            throw new IllegalArgumentException("이메일 글자수 오류");

        if (!email.contains("@email.com"))
            throw new IllegalArgumentException("잘못된 이메일 도메인");
    }

    private void validNickname(String name) {
        if (name.length() < 1 || name.length() > 20)
            throw new IllegalArgumentException("닉네임 글자수 오류");

        if (!name.matches("^[ㄱ-ㅎ ㅏ-ㅣ 가-힣]*$"))
            throw new IllegalArgumentException("한글 외의 닉네임 포함");
    }

    public String getNickname() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }
}
