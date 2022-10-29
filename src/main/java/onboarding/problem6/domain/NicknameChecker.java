package onboarding.problem6.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NicknameChecker {

    private final Map<String, Integer> nicknameChecker;

    public NicknameChecker() {
        this.nicknameChecker = new HashMap<>();
    }

    public List<String> distinctSubString(String text) {
        return IntStream.range(0, text.length() - 1)
                .mapToObj(i -> text.substring(i, i + 2))
                .distinct()
                .collect(Collectors.toList());
    }

    public void saveNickname(String nickname) {
        nicknameChecker.put(nickname, nicknameChecker.getOrDefault(nickname, 0) + 1);
    }

    public boolean isDuplicate(String nickname) {
        return nicknameChecker.get(nickname) >= 2;
    }
}
