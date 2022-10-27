package onboarding.problem6;

public class Crew {
    Email email;
    Nickname nickname;

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
