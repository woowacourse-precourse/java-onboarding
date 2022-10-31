package onboarding.domain.problem6;

import java.util.HashSet;

public class Form {
    private String email;
    private String nickname;

    public Form(String email, String nickname) {
        super();
        this.email = email;
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public HashSet<String> getAllUsedTwoWordsByNickname() {
        HashSet<String> twoWords = new HashSet<>();
        for (int i = 0; i < this.nickname.length() - 1; i++) {
            twoWords.add(this.nickname.substring(i, i + 2));
        }
        return twoWords;
    }
}
