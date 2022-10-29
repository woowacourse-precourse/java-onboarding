package onboarding.problem6;

import java.util.List;

public class Crew {
    Email email;
    Nickname nickname;

    public Crew(Email email, Nickname nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public Crew(List<String> crewInfo) {
        this(new Email(crewInfo.get(0)), new Nickname(crewInfo.get(1)));
    }

    public Email getEmail() {
        return email;
    }

    public Nickname getNickname() {
        return nickname;
    }
}
