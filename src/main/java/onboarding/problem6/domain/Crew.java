package onboarding.problem6.domain;

public class Crew {

    private final Email email;

    private final Nickname nickname;

    public Crew(Email email, Nickname nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public Nickname getNickname() {
        return nickname;
    }

    public String getFullEmail() {
        return email.getFullEmail();
    }
}
