package onboarding.problem6.domain;

import java.util.HashMap;
import java.util.Map;

public class NicknameChecker {

    private static final int NICKNAME_DUPLICATE = 2;
    private final Map<String, Integer> nicknameChecker;

    public NicknameChecker() {
        this.nicknameChecker = new HashMap<>();
    }

    public void saveNickname(String nickname) {
        nicknameChecker.put(nickname, (nicknameChecker.getOrDefault(nickname, 0) + 1));
    }

    public boolean isDuplicate(String nickname) {
        return nicknameChecker.get(nickname) >= NICKNAME_DUPLICATE;
    }
}
