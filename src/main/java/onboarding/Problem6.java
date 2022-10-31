package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, Set<String>> overlapMap = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

        }

        return answer;
    }

    private static List<String> getSubStringList(String nickname) {
        List<String> subStringList = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            subStringList.add(nickname.substring(i, i + 2));
        }
        return subStringList;
    }
}
