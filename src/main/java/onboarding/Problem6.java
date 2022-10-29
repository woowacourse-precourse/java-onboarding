package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static Map<String, Set<String>> mapByTwoCharacters(List<List<String>> forms) {
        Map<String, Set<String>> nicknameSetMap = new HashMap<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);
            for (int i = 0; i < nickname.length() - 1; i++) {
                String twoCharacters = nickname.substring(i, i + 2);
                Set<String> nicknameList = nicknameSetMap.getOrDefault(twoCharacters, new HashSet<>());
                nicknameList.add(nickname);
                nicknameSetMap.put(nickname.substring(i, i + 2), nicknameList);
            }
        }

        return nicknameSetMap;
    }
}
