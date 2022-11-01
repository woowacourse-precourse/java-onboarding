package onboarding.problem6;

public class Crew {

    private Email email;
    private Nickname nickname;

    public Crew(String email, String nickname) {
        this.email = new Email(email);
        this.nickname = new Nickname(nickname);
    }
}
