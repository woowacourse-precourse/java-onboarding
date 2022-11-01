package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Problem6 {

    private static final int MINIMAL_SIZE = 2;
    private static final int EMAIL_LENGTH = 10;

    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new TreeSet<>(Comparator.comparing(s -> s.substring(0, s.length() - EMAIL_LENGTH)));
        Map<String, List<String>> nicknameMap = new TreeMap<>();
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            getDuplicatedNickname(answer, nicknameMap, email, nickname);
        }
        return new ArrayList<>(answer);
    }

    private static void getDuplicatedNickname(Set<String> answer, Map<String, List<String>> nicknameMap, String email,
        String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String key = nickname.substring(i, i + MINIMAL_SIZE);
            if (nicknameMap.containsKey(key)) {
                answer.add(email);
                answer.addAll(nicknameMap.get(key));
                continue;
            }
            nicknameMap.put(key, new ArrayList<>(List.of(email)));
        }
    }
}
