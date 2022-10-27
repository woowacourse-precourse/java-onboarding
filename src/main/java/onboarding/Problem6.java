package onboarding;

import java.util.*;

class Crew {
    private String email;
    private String nickname;
    private boolean isDuplicate;
    private Set<String> tokens = new HashSet(); // 개인이 가지고 있는 tokens

    public Crew(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
        isDuplicate = false;
        makeTokens(this.nickname);
    }

    private void makeTokens(String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String token = nickname.substring(i, i+2);
            this.tokens.add(token);
        }
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean getIsDuplicate() {
        return isDuplicate;
    }

    public Set<String> getTokens() {
        return tokens;
    }

    public void setIsDuplicateTrue() {
        this.isDuplicate = true;
    }
}

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {

    }
}


