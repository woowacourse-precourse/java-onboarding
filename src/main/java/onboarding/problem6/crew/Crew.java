package onboarding.problem6.crew;

public class Crew {
    private final String email;
    private final String nickname;

    Crew(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }
}
