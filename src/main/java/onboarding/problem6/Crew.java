package onboarding.problem6;

import java.util.List;

public class Crew {
    private String email;
    private String nickname;

    private Crew() {
    }

    public Crew(String email, String nickname) {
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
