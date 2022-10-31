package onboarding.domain.problem6;

import java.util.HashSet;

/**
 * 
 * Problem number : 6
 * Comment : 한 지원자의 신청폼(이메일, 닉네임) 정보를 제공한다.
 * @author doyoung
 */
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
        String nickname = this.nickname;
        for (int i = 0; i < nickname.length() - 1; i++) {
            twoWords.add(nickname.substring(i, i + 2));
        }
        return twoWords;
    }
}
