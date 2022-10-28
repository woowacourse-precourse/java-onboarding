package onboarding.problem6;

import java.util.List;

public class Crew {

    private String email;
    private String nickName;

    public Crew(String nickName, String email) {
        this.nickName = nickName;
        this.email = email;
    }

    public static Crew create(List<String> form) {
        final String email = form.get(0);
        final String nickName = form.get(1);

        CrewValidator.validateEmail(email);
        CrewValidator.validateNickName(nickName);

        return new Crew(nickName, email);
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmail() {
        return email;
    }
}
