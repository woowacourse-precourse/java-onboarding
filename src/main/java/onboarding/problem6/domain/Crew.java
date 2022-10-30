package onboarding.problem6.domain;

public class Crew {

    private final Email email;

    private final Nickname nickname;

    public Crew(Email email, Nickname nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public Email getEmail() {
        return email;
    }

    public Nickname getNickname() {
        return nickname;
    }
}
