package onboarding.problem6;

import java.util.Set;

/**
 * Crew 닉네임의 경우의 수를 담는다.
 */
public class NicknameCasesBucket {

    private final String nickname;
    private final Set<String> nicknameCases;

    public NicknameCasesBucket(String nickname, Set<String> nicknameCases) {
        this.nickname = nickname;
        this.nicknameCases = nicknameCases;
    }

    public String getNickname() {
        return nickname;
    }

    public Set<String> getNicknameCases() {
        return nicknameCases;
    }
}
