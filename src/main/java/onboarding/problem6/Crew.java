package onboarding.problem6;

import java.util.List;

public class Crew {

    private Email email;
    private Nickname nickname;

    public Crew(String email, String nickname) {
        this.email = new Email(email);
        this.nickname = new Nickname(nickname);
    }

    public Email getEmail() {
        return email;
    }

    public List<String> getPartOfNickname() {
        return nickname.getPartOfNickname();
    }
}
