package onboarding.problem6;

/**
 * 크루의 정보를 정의한 클래스
 */
class Crew {

    private final String email;
    private final String nickname;

    /**
     * 크루의 이메일과 닉네임을 초기화하는 생성자
     *
     * @param email 크루의 이메일
     * @param nickname 크루의 닉네임
     */
    public Crew(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    /**
     * 크루의 이메일을 반환하는 메소드
     *
     * @return 크루의 이메일
     */
    public String getEmail() {
        return email;
    }

    /**
     * 크루의 닉네임을 반환하는 메소드
     *
     * @return 크루의 닉네임
     */
    public String getNickname() {
        return nickname;
    }
}
