package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Set<String>> subStringMap = new HashMap<>();
        Set<String> duplicates = new HashSet<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            if (nickname.length() <= 1) continue;

            for (int i = 0; i < nickname.length() - 1; i++) {
                String subString = nickname.substring(i, i + 2);
                if (subStringMap.containsKey(subString)) {
                    duplicates.add(subString);
                } else {
                    subStringMap.put(subString, new HashSet<>());
                }
                subStringMap.get(subString).add(email);
            }
        }

        Set<String> answerSet = new HashSet<>();
        for (String duplicate : duplicates) {
            answerSet.addAll(subStringMap.get(duplicate));
        }

        List<String> answer = new ArrayList<>(answerSet);
        Collections.sort(answer);

        return answer;
    }
}
