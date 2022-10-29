package onboarding.domain;

import java.util.HashSet;

/**
 * 크루의 닉네임 신청 정보를 표현하는 vo 클래스
 * @author yoondgu
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

    public String getNickname() {
        return nickname;
    }

    /**
     * 닉네임을 이루는 모든 두 글자 문자열을 반환한다.
     * @return 중복없는 모든 두 글자 문자열의 집합
     */
    public HashSet<String> getAllUsedTwoWordsByNickname() {
        HashSet<String> twoWords = new HashSet<>();
        for (int i = 0; i < this.nickname.length() - 1; i++) {
            twoWords.add(this.nickname.substring(i, i + 2));
        }
        return twoWords;
    }
}
