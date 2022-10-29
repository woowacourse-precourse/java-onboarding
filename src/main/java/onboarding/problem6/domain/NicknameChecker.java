package onboarding.problem6.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NicknameChecker {

    private final Map<String, Integer> nicknameChecker;
    private static final int NICKNAME_DUPLICATE_LENGTH = 2;
    private static final int NICKNAME_DUPLICATE = 2;

    public NicknameChecker() {
        this.nicknameChecker = new HashMap<>();
    }

    public void saveNickname(String nickname) {
        distinctSubString(nickname)
                .forEach(key -> nicknameChecker.put(key, nicknameChecker.getOrDefault(key, 0) + 1));
    }

    public List<String> distinctSubString(String text) {
        return IntStream.range(0, text.length() - 1)
                .mapToObj(i -> text.substring(i, i + NICKNAME_DUPLICATE_LENGTH))
                .distinct()
                .collect(Collectors.toList());
    }

    public boolean isDuplicate(String nickname) {
        return nicknameChecker.get(nickname) >= NICKNAME_DUPLICATE;
    }
}
