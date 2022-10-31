package onboarding.problem6;

import java.util.List;

public class Crew {
    private static final int EMAIL = 0;
    private static final int NICKNAME = 1;

    private String nickname;
    private String email;

    public Crew(String email,String nickname ) {
        this.email = email;
        this.nickname = nickname;

    }

    public Crew(List<String> emailAndNickname) {
        this(emailAndNickname.get(EMAIL), emailAndNickname.get(NICKNAME));
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }
}