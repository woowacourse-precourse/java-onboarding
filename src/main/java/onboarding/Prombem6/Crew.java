package onboarding.Prombem6;

import java.util.List;

public class Crew {
    private Email email;
    private Nickname nickname;

    public Crew(List<String> info) throws Exception {
        if(info.size() != 2) {
            throw new Exception("이메일과 닉네임만 입력해야 합니다");
        }
        email = new Email(info.get(0));
        nickname = new Nickname(info.get(1));
    }

    public Email getEmail() {
        return email;
    }

    public Nickname getNickname() {
        return nickname;
    }
}
