package onboarding;

import java.util.*;

public class Problem6 {
    static final int FORM_EMAIL = 0;
    static final int FORM_NICKNAME = 1;
    static List<String> answer = new ArrayList<>();
    static List<Set<String>> partsOfNicknameList = new ArrayList<>();
    static Map<String, Integer> nicknameAndCountMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        return answer;
    }

    public static void setupData(List<List<String>> forms) {
        forms.stream()
                .map(form -> nicknameDecomposition(form.get(FORM_NICKNAME)))
                .forEach(parts -> {
                    partsOfNicknameList.add(parts);
                    parts.forEach(part -> nicknameAndCountMap.put(part, nicknameAndCountMap.getOrDefault(part, 0) + 1));
                });
    }

    public static Set<String> nicknameDecomposition(String nickname) {
        Set<String> separatedNickname = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            separatedNickname.add(nickname.substring(i, i + 2));
        }
        return separatedNickname;
    }
}
