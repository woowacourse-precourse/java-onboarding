package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    private static final int EMAIL = 0;
    private static final int NICKNAME = 1;

    private static String getEmail(List<String> form) {
        return form.get(EMAIL);
    }

    private static String getNickName(List<String> form) {
        return form.get(NICKNAME);
    }

    private static void addDuplicateNickname(String nickname,
                                             Set<String> duplicateNickname) {
        Map<String, Set<String>> nicknameByword = new HashMap<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            String part = nickname.substring(i, i + 2);
            if (!nicknameByword.containsKey(part)) {
                nicknameByword.put(part, new HashSet<>());
            }
            nicknameByword.get(part).add(nickname);
            if (nicknameByword.get(part).size() >= 2) {
                duplicateNickname.addAll(nicknameByword.get(part));
            }
        }
    }

    private static Set<String> getDuplicateNickname(List<List<String>> forms) {
        Set<String> duplicateNickname = new HashSet<>();

        for (List<String> form : forms) {
            String email = getEmail(form);
            String nickname = getNickName(form);
            addDuplicateNickname(nickname, duplicateNickname);
        }
        return duplicateNickname;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Set<String> duplicateNickname = getDuplicateNickname(forms);

        return answer;
    }
}
